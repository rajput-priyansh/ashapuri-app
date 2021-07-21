package com.shreejipackaging.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseProductSize(

	@field:SerializedName("data")
	val data: List<ProductSizeItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
) : Parcelable

@Parcelize
data class ProductSizeItem(

	@field:SerializedName("size")
	val size: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable
