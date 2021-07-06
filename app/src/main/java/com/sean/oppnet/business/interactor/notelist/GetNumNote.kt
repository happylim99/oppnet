package com.sean.oppnet.business.interactor.notelist

import com.sean.oppnet.business.data.cache.CacheResponseHandler
import com.sean.oppnet.business.data.cache.abstraction.NoteCacheDataSource
import com.sean.oppnet.business.data.util.safeCacheCall
import com.sean.oppnet.business.domain.state.*
import com.sean.oppnet.framework.presentation.notelist.state.NoteListViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNumNote(
    private val noteCacheDataSource: NoteCacheDataSource
){

    fun getNumNote(
        stateEvent: StateEvent
    ): Flow<DataState<NoteListViewState>?> = flow {

        val cacheResult = safeCacheCall(Dispatchers.IO){
            noteCacheDataSource.getNumNote()
        }
        val response =  object: CacheResponseHandler<NoteListViewState, Int>(
            response = cacheResult,
            stateEvent = stateEvent
        ){
            override suspend fun handleSuccess(resultObj: Int): DataState<NoteListViewState>? {
                val viewState = NoteListViewState(
                    numNotesInCache = resultObj
                )
                return DataState.data(
                    response = Response(
                        message = GET_NUM_NOTES_SUCCESS,
                        uiComponentType = UIComponentType.None(),
                        messageType = MessageType.Success()
                    ),
                    data = viewState,
                    stateEvent = stateEvent
                )
            }
        }.getResult()

        emit(response)
    }

    companion object{
        val GET_NUM_NOTES_SUCCESS = "Successfully retrieved the number of notes from the cache."
        val GET_NUM_NOTES_FAILED = "Failed to get the number of notes from the cache."
    }
}