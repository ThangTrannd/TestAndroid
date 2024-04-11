package com.task.data.remote.service

import com.example.testapp.data.Country
import retrofit2.Response
import retrofit2.http.GET

interface NationService {
    @GET("v3.1/all?fields=name,flags")
    suspend fun fetchRecipes(): Response<List<Country>>
}
