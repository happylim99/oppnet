package com.sean.oppnet.business.data

import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.sean.oppnet.business.domain.model.Note


class NoteDataFactory(
    private val testClassLoader: ClassLoader
) {

    fun produceListOfNotes(): List<Note>{
        val notes: List<Note> = Gson()
            .fromJson(
                getNotesFromFile("noteList.json"),
                object: TypeToken<List<Note>>() {}.type
            )
        return notes
    }

    fun produceHashMapOfNotes(noteList: List<Note>): HashMap<String, Note>{
        val map = HashMap<String, Note>()
        for(note in noteList){
            map.put(note.id, note)
        }
        return map
    }

    fun produceEmptyListOfNotes(): List<Note>{
        return ArrayList()
    }

    fun getNotesFromFile(fileName: String): String {
        return testClassLoader.getResource(fileName).readText()
    }

}