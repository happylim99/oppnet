package com.sean.oppnet.business.data.network

import com.sean.oppnet.business.domain.model.Note
import com.sean.oppnet.framework.datasource.network.abstraction.NoteFirestoreService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteNetworkDataSourceImpl
@Inject
constructor(
    private val firestoreService: NoteFirestoreService
) {

    suspend fun insertOrUpdateNote(note: Note) {
        return firestoreService.insertOrUpdateNote(note)
    }

    suspend fun deleteNote(primaryKey: String) {
        return firestoreService.deleteNote(primaryKey)
    }

    suspend fun insertDeletedNote(note: Note) {
        return firestoreService.insertDeletedNote(note)
    }

    suspend fun insertDeletedNotes(notes: List<Note>) {
        return firestoreService.insertDeletedNotes(notes)
    }

    suspend fun deleteDeletedNote(note: Note) {
        return firestoreService.deleteDeletedNote(note)
    }

    suspend fun getDeletedNotes(): List<Note> {
        return firestoreService.getDeletedNotes()
    }

    suspend fun deleteAllNotes() {
        firestoreService.deleteAllNotes()
    }

    suspend fun searchNote(note: Note): Note? {
        return firestoreService.searchNote(note)
    }

    suspend fun getAllNotes(): List<Note> {
        return firestoreService.getAllNotes()
    }

    suspend fun insertOrUpdateNotes(notes: List<Note>) {
        return firestoreService.insertOrUpdateNotes(notes)
    }


}