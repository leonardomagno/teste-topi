package com.example.testetopi.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataResponse (
    @SerializedName("items") val repositoriesList: List<RepositoryVO>
): Parcelable