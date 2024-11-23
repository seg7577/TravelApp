package com.example.travelapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

data class PlaceResponse(
    val documents: List<Place>
)

data class Place(
    val place_name: String,
    val x: String, // 경도
    val y: String  // 위도
)

interface KakaoMapApi {
    @GET("v2/local/search/keyword.json")
    fun searchPlaces(
        @Header("Authorization") apiKey: String,
        @Query("query") keyword: String
    ): Call<PlaceResponse>
}