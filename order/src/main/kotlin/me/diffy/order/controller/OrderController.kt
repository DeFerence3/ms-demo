package me.diffy.order.controller

import me.diffy.order.model.OrderCreateDTO
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/orders")
class OrderController(private val productServiceClient: ProductServiceClient) {
    @GetMapping("/{productId}")
    fun createOrder(@PathVariable productId: String?): ResponseEntity<OrderCreateDTO> {
        val product = productServiceClient.getProductById(productId)

        val responseDto = OrderCreateDTO(
            product = product!!,
            message = "Order created for product: " + product?.name + " with price: $" + product?.price,
            orderId = (1..100).random()
        )
        return ResponseEntity(
            responseDto,
            HttpStatus.CREATED
        )
    }
}