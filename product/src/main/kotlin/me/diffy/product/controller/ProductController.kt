package me.diffy.product.controller

import me.diffy.product.model.Product
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class ProductController {
    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: String?): Product {
        return Product(id, "Feign Product", 99.99)
    }

    @GetMapping
    fun getProducts(): List<Product> {
        return listOf(Product("1", "Sample Product", 99.99),Product("2", "Sample Product2", 37.25))
    }

    @GetMapping("message")
    fun getMessage(): String {
        return "hello"
    }
}