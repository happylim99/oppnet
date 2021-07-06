package com.sean.oppnet.business.data.cache.abstraction

import com.sean.oppnet.business.domain.model.Note

interface NoteCacheDataSource{

    suspend fun insertNote(note: Note): Long

    suspend fun deleteNote(primaryKey: String): Int

    suspend fun deleteNoteList(notes: List<Note>): Int

    suspend fun updateNote(
        primaryKey: String,
        newTitle: String,
        newBody: String?,
        timestamp: String?
    ): Int

    suspend fun searchNote(
        query: String,
        filterAndOrder: String,
        page: Int
    ): List<Note>

    suspend fun getAllNote(): List<Note>

    suspend fun searchNoteById(id: String): Note?

    suspend fun getNumNote(): Int

    suspend fun insertNoteList(notes: List<Note>): LongArray
}