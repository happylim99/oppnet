package com.sean.oppnet.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val id: String,
    val title: String,
    val body: String,
    val created_at: String,
    val updated_at: String
): Parcelable
