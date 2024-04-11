package com.example.testapp.data.repository.local

import com.example.testapp.data.Country
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {
    suspend fun saveData(list : List<Country>)

    fun readData() : Flow<List<Country>>
}