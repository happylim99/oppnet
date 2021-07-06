package com.sean.oppnet.business.data.cache.impl

import com.sean.oppnet.business.data.cache.abstraction.NoteCacheDataSource
import com.sean.oppnet.business.domain.model.Note
import com.sean.oppnet.framework.datasource.cache.abstraction.NoteDaoService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteCacheDataSourceImpl
@Inject
constructor(
    private val noteDaoService: NoteDaoService
): NoteCacheDataSource {

    override suspend fun insertNote(note: Note): Long {
        return noteDaoService.insertNote(note)
    }

    override suspend fun deleteNote(primaryKey: String): Int {
        return noteDaoService.deleteNote(primaryKey)
    }

    override suspend fun deleteNoteList(notes: List<Note>): Int {
        return noteDaoService.deleteNotes(notes)
    }

    override suspend fun updateNote(
        primaryKey: String,
        newTitle: String,
        newBody: String?,
        timestamp: String?
    ): Int {
        return noteDaoService.updateNote(
            primaryKey,
            newTitle,
            newBody,
            timestamp
        )
    }

    override suspend fun searchNote(
        query: String,
        filterAndOrder: String,
        page: Int
    ): List<Note> {
        return noteDaoService.returnOrderedQuery(
            query, filterAndOrder, page
        )
    }

    override suspend fun getAllNote(): List<Note> {
        return noteDaoService.getAllNotes()
    }

    override suspend fun searchNoteById(id: String): Note? {
        return noteDaoService.searchNoteById(id)
    }

    override suspend fun getNumNote(): Int {
        return noteDaoService.getNumNotes()
    }

    override suspend fun insertNoteList(notes: List<Note>): LongArray{
        return noteDaoService.insertNotes(notes)
    }
}