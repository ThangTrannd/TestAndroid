package com.example.testapp.data.repository.local

import com.example.testapp.data.AppDatabase
import com.example.testapp.data.Country
import com.example.testapp.data.dao.CountryDao
import com.example.testapp.utils.convertToCountryList
import com.example.testapp.utils.convertToNationEntities
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(private val app: AppDatabase) : DatabaseRepository {
    override suspend fun saveData(list: List<Country>) {
        app.countryDao.insertAll(convertToNationEntities(list))
    }

    override fun readData(): List<Country> {
        return convertToCountryList(app.countryDao.getData())
    }
}