package com.vibs.ashapuriindustries.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseLogin(

	@field:SerializedName("refresh")
	val refresh: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("token")
	val token: String? = null,

	@field:SerializedName("password")
	val password: List<String>? = null,

	@field:SerializedName("username")
	val username: List<String>? = null

) : Parcelable

@Parcelize
data class User(

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val userName: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("pan_number")
	val panNumber: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("is_approved")
	val isApproved: Boolean? = null,

	@field:SerializedName("gst_number")
	val gstNumber: String? = null,

	@field:SerializedName("is_favourite")
	val isFavourite: Boolean? = null,

	@field:SerializedName("mobile_number")
	val mobileNumber: String? = null

	) : Parcelable
