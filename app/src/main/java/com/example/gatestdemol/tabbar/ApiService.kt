package com.example.gatestdemol.tabbar

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/cityList.php")
    fun getCities(@Body request: PageRequest): Call<CityResponse>
}