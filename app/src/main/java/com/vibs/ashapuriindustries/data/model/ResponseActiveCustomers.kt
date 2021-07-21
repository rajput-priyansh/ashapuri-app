package com.shreejipackaging.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.vibs.ashapuriindustries.data.model.User
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseActiveCustomers(

    @field:SerializedName("data")
	val data: List<User?>? = null,

    @field:SerializedName("status")
	val status: Int? = null
) : Parcelable
