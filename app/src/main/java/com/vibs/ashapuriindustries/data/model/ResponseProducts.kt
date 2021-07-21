package com.shreejipackaging.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseProducts(

	@field:SerializedName("data")
	val data: List<ProductItem?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
) : Parcelable

@Parcelize
data class ProductItem(

	@field:SerializedName("product_type")
	val productType: String? = null,

	@field:SerializedName("hsn_number")
	val hsnNumber: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("product_name")
	val productName: String? = null
) : Parcelable
