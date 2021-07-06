package com.sean.oppnet.framework.presentation.notedetail.state

import android.os.Parcelable
import com.sean.oppnet.business.domain.model.Note
import com.sean.oppnet.business.domain.state.ViewState
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NoteDetailViewState(

    var note: Note? = null,

    var isUpdatePending: Boolean? = null

) : Parcelable, ViewState