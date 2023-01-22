package com.yaman.kotlinsearchsortpagingspringboot.seeders

import com.yaman.kotlinsearchsortpagingspringboot.models.Product
import com.yaman.kotlinsearchsortpagingspringboot.repositories.ProductRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.random.Random


//@Component
class DataSeeder(private val productRepository: ProductRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
//        for (i in 1..50) {
//
//            val product = Product(
//                title = "Title # $i",
//                description = "Description #${i + 1}",
//                image = "https://picsum.photos/200/300?" + Random.nextInt(10000),
//                price = "${Random.nextInt(10, 100)}"
//            )
//
//            this.productRepository.save(product)
//        }
    }
}