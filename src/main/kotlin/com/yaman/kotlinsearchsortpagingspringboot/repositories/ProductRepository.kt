package com.yaman.kotlinsearchsortpagingspringboot.repositories

import com.yaman.kotlinsearchsortpagingspringboot.models.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.util.Optionals
import java.util.Optional

interface ProductRepository : MongoRepository<Product, String> {

    @Query("{\$or: [{title: {\$regex: ?0 , \$options: 'i' }} , {description: {\$regex: ?0 , \$options: 'i' }}] }")
    fun search(s: String): List<Product>

    @Query(
        "{\$or: [{title: {\$regex: ?0 , \$options: 'i' }} , {description: {\$regex: ?0 , \$options: 'i' }}] }",
        count = true
    )
    fun totalProduct(s: String): Int

    @Query("Select * from Product")
    fun search(s: String, sort: Sort): List<Product>


    @Query("Select * from Product")
    fun search(s: String, pageable: Pageable): List<Product>


    fun findProductByTitle(title: String): Optional<Product>
}
