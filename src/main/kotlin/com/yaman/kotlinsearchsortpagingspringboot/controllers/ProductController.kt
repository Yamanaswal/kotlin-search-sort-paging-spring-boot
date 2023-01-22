package com.yaman.kotlinsearchsortpagingspringboot.controllers

import com.yaman.kotlinsearchsortpagingspringboot.dtos.PaginationResponse
import com.yaman.kotlinsearchsortpagingspringboot.models.Product
import com.yaman.kotlinsearchsortpagingspringboot.repositories.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class ProductController(private val productRepository: ProductRepository) {

    @GetMapping("/products/frontend")
    fun frontend(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(this.productRepository.findAll())
    }

    @GetMapping("/products/backend")
    fun backend(
        @RequestParam("s", defaultValue = "") s: String,
        @RequestParam("sort", defaultValue = "") sort: String,
        @RequestParam("page", defaultValue = "1") page: Int
    ): ResponseEntity<Any> {

        var sortBy = Sort.unsorted()

        if (sort == "asc") {
            sortBy = Sort.by(Sort.Direction.ASC, "price")
        } else if (sort == "desc") {
            sortBy = Sort.by(Sort.Direction.DESC, "price")
        }

        val perPage = 10
        val totalPages = this.productRepository.totalProduct(s)

        return ResponseEntity.ok(
            PaginationResponse(
                data = this.productRepository.search(s, PageRequest.of(page - 1, perPage, sortBy)),
                total = totalPages,
                page = perPage,
                last_page = (totalPages / perPage) + 1
            )
        )
    }


}