package com.amitozsingh.retrofitjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amitozsingh.retrofitjson.data.currentResponse
import com.amitozsingh.retrofitjson.network.myInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.data_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val retrofit= Retrofit.Builder().baseUrl("https://api.plos.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service=retrofit.create(myInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start()


    }
    fun start(){
        service.getData("title:DNA").enqueue(object : Callback<currentResponse> {


            override fun onFailure(call: Call<currentResponse>, t: Throwable) {


            }



            override fun onResponse(call: Call<currentResponse>, response: Response<currentResponse>) {
Log.d("AMITOZ","I M HERE")

                val data=response.body()
                val data1= data?.response






                rView.layoutManager =
                    LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL,false)
                rView.adapter = data1?.let {
                    dataAdapter(
                        this@MainActivity,

                        it.docs
                    )
                }







            }
        })
    }
}
