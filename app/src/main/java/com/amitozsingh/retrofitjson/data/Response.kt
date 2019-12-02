package com.amitozsingh.retrofitjson.data




data class Response(
    val docs: List<Doc>,
    val maxScore: Double,
    val numFound: Int,
    val start: Int
)