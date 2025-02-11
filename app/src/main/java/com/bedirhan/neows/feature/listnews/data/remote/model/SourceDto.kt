package com.bedirhan.neows.feature.listnews.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SourceDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
) : Parcelable
