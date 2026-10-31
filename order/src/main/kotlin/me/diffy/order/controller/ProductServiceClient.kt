package me.diffy.order.controller

import me.diffy.order.model.Product
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(name = "product")
interface ProductServiceClient {
    @GetMapping("/products/{id}")
    fun getProductById(@PathVariable id: String?): Product?
}