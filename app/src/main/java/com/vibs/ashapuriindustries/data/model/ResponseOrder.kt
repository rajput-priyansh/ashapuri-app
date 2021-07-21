package com.shreejipackaging.data.model

import com.google.gson.annotations.SerializedName
import com.vibs.ashapuriindustries.data.model.User

data class ResponseOrder(
    @field:SerializedName("status")
    val status: Int? = null,

    @field:SerializedName("data")
    val list: List<Order>? = null,

    @field:SerializedName("result")
    val result: String? = null
)

data class Order(

    @field:SerializedName("str_status")
    val strStatus: String? = null,

    @field:SerializedName("order_number")
    val orderNumber: String? = null,

    @field:SerializedName("consignee_name")
    val consigneeName: String? = null,

    @field:SerializedName("setting_account")
    val settingAccount: SettingAccount? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("consignee_gst")
    val consigneeGst: String? = null,

    @field:SerializedName("products")
    val products: List<ProductsItem?>? = null,

    @field:SerializedName("str_creation_date")
    val strCreationDate: String? = null,

    @field:SerializedName("transportation_mode")
    val transportationMode: String? = null,

    @field:SerializedName("terms_conditions")
    val termsConditions: List<TermCondition>? = null,

    @field:SerializedName("host")
    val host: Host? = null,

    @field:SerializedName("invoice_type")
    val invoiceType: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("shipping_address")
    val shippingAddress: String? = null,

    @field:SerializedName("state")
    val state: String? = null,

    @field:SerializedName("str_delivery_date")
    val strDeliveryDate: String? = null,

    @field:SerializedName("consignee_pan")
    val consigneePan: String? = null,

    @field:SerializedName("consignee_address")
    val consigneeAddress: String? = null,

    @field:SerializedName("creation_date")
    val creationDate: String? = null,

    @field:SerializedName("delivery_date")
    val deliveryDate: String? = null,

    @field:SerializedName("str_invoice_date")
    val strInvoiceDate: String? = null,

    @field:SerializedName("vehicle_number")
    val vehicleNumber: String? = null,

    @field:SerializedName("order_total")
    val orderTotal: OrderTotal? = null,

    @field:SerializedName("state_code")
    val stateCode: String? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("status")
    val status: Int? = null
)

data class Unit(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

data class OrderTotal(

    @field:SerializedName("sgst")
    val sgst: String? = null,

    @field:SerializedName("total")
    val total: String? = null,

    @field:SerializedName("net_total")
    val netTotal: String? = null,

    @field:SerializedName("str_total_in_words")
    val strTotalInWords: String? = null,

    @field:SerializedName("discount")
    val discount: String? = null,

    @field:SerializedName("cgst")
    val cgst: String? = null,

    @field:SerializedName("grand_total")
    val grandTotal: String? = null,

    @field:SerializedName("total_tax")
    val totalTax: String? = null,

    @field:SerializedName("igst")
    val igst: String? = null
)

data class ProductsItem(

    @field:SerializedName("product")
    val product: Product? = null,

    @field:SerializedName("unit")
    val unit: Unit? = null,

    @field:SerializedName("amount")
    val amount: Double? = null,

    @field:SerializedName("rate")
    val rate: Double? = null,

    @field:SerializedName("weight")
    val weight: Double? = null,

    @field:SerializedName("product_size")
    val productSize: ProductSize? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

data class ProductSize(

    @field:SerializedName("size")
    val size: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

data class Product(

    @field:SerializedName("product_type")
    val productType: String? = null,

    @field:SerializedName("hsn_number")
    val hsnNumber: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("product_name")
    val productName: String? = null
)

data class SettingAccount(

    @field:SerializedName("account_number")
    val accountNumber: String? = null,

    @field:SerializedName("supply_address")
    val supplyAddress: String? = null,

    @field:SerializedName("bank_ifsc")
    val bankIfsc: String? = null,

    @field:SerializedName("setting_igst")
    val settingIgst: Double? = null,

    @field:SerializedName("bank_address")
    val bankAddress: String? = null,

    @field:SerializedName("discount")
    val discount: Double? = null,

    @field:SerializedName("setting_sgst")
    val settingSgst: Double? = null,

    @field:SerializedName("setting_cgst")
    val settingCgst: Double? = null,

    @field:SerializedName("pan_number")
    val panNumber: String? = null,

    @field:SerializedName("bank_name")
    val bankName: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("gst_number")
    val gstNumber: String? = null,

    @field:SerializedName("state")
    val state: String? = null,

    @field:SerializedName("mobile_number")
    val mobileNumber: String? = null,

    @field:SerializedName("state_code")
    val stateCode: String? = null
)

data class Host(

    @field:SerializedName("last_name")
    val lastName: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("first_name")
    val firstName: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)

data class TermCondition(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("term_condition")
    val termCondition: String? = null
)

data class OrderProduct(

    @field:SerializedName("product")
    var product: Int? = null,

    @field:SerializedName("product_name")
    var productName: String? = null,

    @field:SerializedName("size")
    var size: Int? = null,

    @field:SerializedName("size_name")
    var sizeName: String? = null,

    @field:SerializedName("unit")
    var unit: Int? = null,

    @field:SerializedName("unit_name")
    var unitName: String? = null,

    @field:SerializedName("weight")
    var weight: Double? = null,

    @field:SerializedName("rate")
    var rate: Double? = null
)

data class RequestOrder(

    @field:SerializedName("consignee_name")
    var consigneeName: String? = null,

    @field:SerializedName("description")
    var description: String? = null,

    @field:SerializedName("consignee_gst")
    var consigneeGst: String? = null,

    @field:SerializedName("transportation_mode")
    var transportationMode: String? = null,

    @field:SerializedName("invoice_type")
    var invoiceType: Int? = null,

    @field:SerializedName("shipping_address")
    var shippingAddress: String? = null,

    @field:SerializedName("state")
    var state: String? = null,

    @field:SerializedName("consignee_pan")
    var consigneePan: String? = null,

    @field:SerializedName("consignee_address")
    var consigneeAddress: String? = null,

    @field:SerializedName("delivery_date")
    var deliveryDate: String? = null,

    @field:SerializedName("invoice_date")
    var invoiceDate: String? = null,

    @field:SerializedName("vehicle_number")
    var vehicleNumber: String? = null,

    @field:SerializedName("state_code")
    var stateCode: String? = null,

    @field:SerializedName("user")
    var user: Int? = null,

    @field:SerializedName("order_number")
    var orderNumber: String? = null
)

data class RequestData(
    @field:SerializedName("order")
    val order: RequestOrder? = null,

    @field:SerializedName("products")
    val products: List<OrderProduct>? = null
)