package com.example.dayvi_uas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResep(
    val img : Int,
    val title : String,
    val des : String,
): Parcelable
