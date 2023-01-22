package com.yaman.kotlinsearchsortpagingspringboot.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Product(@Id
                   val id: String? = null,
                   var title: String = "",
                   var description: String = "",
                   var image: String = "",
                   var price: String = "")