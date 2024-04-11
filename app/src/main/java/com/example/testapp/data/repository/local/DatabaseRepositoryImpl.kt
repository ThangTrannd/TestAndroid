package com.example.testapp.data.repository.local

import com.example.testapp.data.AppDatabase
import com.example.testapp.data.Country
import com.example.testapp.data.dao.CountryDao
import com.example.testapp.utils.convertToNationEntities
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(private val app: AppDatabase) : DatabaseRepository {
    override suspend fun saveData(list: List<Country>) {
        println("Thắng check 2")
        app.countryDao.insertAll(convertToNationEntities(list))
    }

    override fun readData(): Flow<List<Country>> {
        TODO("Not yet implemented")
    }

}