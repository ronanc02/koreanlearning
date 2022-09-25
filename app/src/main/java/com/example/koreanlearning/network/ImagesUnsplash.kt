package com.example.koreanlearning.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class ImagesUnsplash(
    val id: String,
    val width: Int,
    val height: Int,
    val description: String?,
    val urls: @RawValue ImagesUrls,
) : Parcelable