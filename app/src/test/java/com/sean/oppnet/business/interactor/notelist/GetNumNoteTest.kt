package com.sean.oppnet.business.interactor.notelist

import com.sean.oppnet.business.data.cache.abstraction.NoteCacheDataSource
import com.sean.oppnet.business.domain.model.NoteFactory
import com.sean.oppnet.business.domain.state.DataState
import com.sean.oppnet.business.interactor.notelist.GetNumNote.Companion.GET_NUM_NOTES_SUCCESS
import com.sean.oppnet.di.DependencyContainer
import com.sean.oppnet.framework.presentation.notelist.state.NoteListStateEvent
import com.sean.oppnet.framework.presentation.notelist.state.NoteListViewState
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/*

Test cases:
1. getNumNotes_success_confirmCorrect()
    a) get the number of notes in cache
    b) listen for GET_NUM_NOTES_SUCCESS from flow emission
    c) compare with the number of notes in the fake data set

*/
@InternalCoroutinesApi
class GetNumNoteTest {

    // system in test
    private val getNumNote: GetNumNote

    // dependencies
    private val dependencyContainer: DependencyContainer
    private val noteCacheDataSource: NoteCacheDataSource
    private val noteFactory: NoteFactory

    init {
        dependencyContainer = DependencyContainer()
        dependencyContainer.build()
        noteCacheDataSource = dependencyContainer.noteCacheDataSource
        noteFactory = dependencyContainer.noteFactory
        getNumNote = GetNumNote(
            noteCacheDataSource = noteCacheDataSource
        )
    }


    @Test
    fun getNumNotes_success_confirmCorrect() = runBlocking {

        var numNotes = 0
        getNumNote.getNumNote(
            stateEvent = NoteListStateEvent.GetNumNotesInCacheEvent()
        ).collect(object: FlowCollector<DataState<NoteListViewState>?> {
            override suspend fun emit(value: DataState<NoteListViewState>?) {
                assertEquals(
                    value?.stateMessage?.response?.message,
                    GET_NUM_NOTES_SUCCESS
                )
                numNotes = value?.data?.numNotesInCache?: 0
            }
        })

        val actualNumNotesInCache = noteCacheDataSource.getNumNote()
        Assertions.assertTrue { actualNumNotesInCache == numNotes }
    }
}