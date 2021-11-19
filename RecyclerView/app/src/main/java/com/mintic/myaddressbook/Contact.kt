package com.mintic.myaddressbook

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    val firstName: String,
    val lastName: String,
    var email: String?,
    var imageUrl: String
) :Parcelable
