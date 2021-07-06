package com.sean.oppnet.di

import com.sean.oppnet.business.data.NoteDataFactory
import com.sean.oppnet.business.data.cache.FakeNoteCacheDataSourceImpl
import com.sean.oppnet.business.data.cache.abstraction.NoteCacheDataSource
import com.sean.oppnet.business.data.network.FakeNoteNetworkDataSourceImpl
import com.sean.oppnet.business.data.network.abstraction.NoteNetworkDataSource
import com.sean.oppnet.business.domain.model.Note
import com.sean.oppnet.business.domain.model.NoteFactory
import com.sean.oppnet.business.domain.util.DateUtil
import com.sean.oppnet.util.isUnitTest
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class DependencyContainer {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.ENGLISH)
    val dateUtil =
        DateUtil(dateFormat)
    lateinit var noteNetworkDataSource: NoteNetworkDataSource
    lateinit var noteCacheDataSource: NoteCacheDataSource
    lateinit var noteFactory: NoteFactory
    lateinit var noteDataFactory: NoteDataFactory
    private var noteData: HashMap<String, Note> = HashMap()

    init {
        isUnitTest = true // for Logger.kt
    }

    fun build() {
        this.javaClass.classLoader?.let { classLoader ->
            noteDataFactory = NoteDataFactory(classLoader)

            // fake data set
            noteData = noteDataFactory.produceHashMapOfNotes(
                noteDataFactory.produceListOfNotes()
            )
        }
        noteFactory = NoteFactory(dateUtil)
        noteNetworkDataSource = FakeNoteNetworkDataSourceImpl(
            notesData = noteData,
            deletedNotesData = HashMap(),
            dateUtil = dateUtil
        )
        noteCacheDataSource = FakeNoteCacheDataSourceImpl(
            notesData = noteData,
            dateUtil = dateUtil
        )
    }

}