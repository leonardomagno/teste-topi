package com.example.testetopi.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepositoryVO(
    @SerializedName("id") val repositorieId: Int? = null,
    @SerializedName("name") val repositorieName: String? = null,
    @SerializedName("description") val repositorieDescription: String? = null,
    @SerializedName("stargazers_count") val repositorieStargazersCount: Int? = null,
    @SerializedName("forks_count") val repositorieForksCount: Int? = null,
    @SerializedName("owner") val repositorieOwner: OwnerVO
): Parcelable