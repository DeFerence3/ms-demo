package me.diffy.order.model

data class OrderCreateDTO(
    val product: Product,
    val message: String,
    val orderId: Int
)
