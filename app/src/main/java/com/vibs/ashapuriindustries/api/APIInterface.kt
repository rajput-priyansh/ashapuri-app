package com.vibs.ashapuriindustries.api

import com.shreejipackaging.data.model.*
import com.vibs.ashapuriindustries.data.model.ResponseLogin
import com.vibs.ashapuriindustries.data.model.User
import retrofit2.http.*


interface APIInterface {

    @POST("accounts/signin/")
    suspend fun userLogin(@Body request: User): ResponseLogin

    @GET("order/customer-mobile-orders/")
    suspend fun getAllOrder(): ResponseOrder

    @GET("accounts/active-customers-mobile/")
    suspend fun getAllActiveCustomers(): ResponseActiveCustomers

    @GET("order/products-mobile/")
    suspend fun getProducts(): ResponseProducts

    @GET("order/product-sizes-mobile/")
    suspend fun getProductSizes(): ResponseProductSize

    @GET("order/units-mobile/")
    suspend fun getProductsUnits(): ResponseUnits

    @POST("order/customer-order/")
    suspend fun createCustomerOrder(@Body request: RequestData): ResponseOrder
}
