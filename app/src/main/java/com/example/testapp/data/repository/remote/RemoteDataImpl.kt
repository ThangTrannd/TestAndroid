package com.example.testapp.data.repository.remote

import com.example.testapp.data.Country

interface RemoteDataImpl {
    suspend fun fetchNation() : List<Country>
}