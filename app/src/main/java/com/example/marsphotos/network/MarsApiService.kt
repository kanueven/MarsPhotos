package com.example.marsphotos.network


import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/**
 * Retrofit service object for creating api calls
 */
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): String
}


object MarsApi{
    val retrofitService by lazy{
        retrofit.create(MarsApiService::class.java)
    }
}