package com.amitozsingh.retrofitjson.data


import com.google.gson.annotations.SerializedName

data class Doc(
    val `abstract`: List<String>,
    @SerializedName("article_type")
    val articleType: String,
    @SerializedName("author_display")
    val authorDisplay: List<String>,
    val eissn: String,
    val id: String,
    val journal: String,
    @SerializedName("publication_date")
    val publicationDate: String,
    val score: Double,
    @SerializedName("title_display")
    val titleDisplay: String
)