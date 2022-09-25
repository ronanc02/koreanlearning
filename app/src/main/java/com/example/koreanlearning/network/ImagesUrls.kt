package com.example.koreanlearning.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImagesUrls(
    val thumb: String?,
    val small: String,
    val regular: String?,
    val full: String?,
    val raw: String?
) : Parcelable