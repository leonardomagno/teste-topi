package com.example.testetopi.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OwnerVO(
    @SerializedName("id") val ownerId: Int? = null,
    @SerializedName("login") val ownwerName: String? = null,
    @SerializedName("avatar_url") val ownerAvatarUrl: String? = null
): Parcelable