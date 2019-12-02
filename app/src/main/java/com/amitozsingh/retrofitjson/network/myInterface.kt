package com.amitozsingh.retrofitjson.network

import com.amitozsingh.retrofitjson.data.currentResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//http://api.plos.org/search?q=title:DNA
interface myInterface {

    @GET("search")
    fun getData(
        @Query("q") key : String
    ) : Call<currentResponse>
}