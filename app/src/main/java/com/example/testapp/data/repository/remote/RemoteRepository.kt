package com.example.testapp.data.repository.remote

import com.example.testapp.data.Country
import com.example.testapp.data.dao.CountryDao
import com.example.testapp.data.repository.NetworkingService
import com.example.testapp.utils.convertToNationEntities
import com.task.data.remote.service.NationService
import retrofit2.Response
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val networkingService: NetworkingService) : RemoteDataImpl {
    override suspend fun fetchNation(): List<Country> {
        val nationalService = networkingService.createService(NationService::class.java)
        return nationalService.fetchRecipes().body() ?: listOf()
    }
}