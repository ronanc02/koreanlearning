package com.example.koreanlearning.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Section(
//    @StringRes val stringResourceId: Int,
    val stringResourceId: String,
    @DrawableRes val imageResourceId: Int) {
}