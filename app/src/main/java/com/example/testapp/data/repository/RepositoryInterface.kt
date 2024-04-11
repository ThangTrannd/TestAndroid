package com.example.testapp.data.repository

import com.example.testapp.data.Country
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface RepositoryInterface {

    suspend fun fetchItem() : Flow<List<Country>>
}