package com.example.testapp.data.repository.remote

import com.example.testapp.data.Country
import com.example.testapp.data.repository.NetworkingService
import com.example.testapp.data.repository.local.DatabaseRepository
import com.task.data.remote.service.NationService
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val networkingService: NetworkingService,val databaseRepository: DatabaseRepository) : RemoteDataImpl {
    override suspend fun fetchNation(): List<Country> {
        val nationalService = networkingService.createService(NationService::class.java)
        val data = try {
            nationalService.fetchCountry().body()
        }catch (e : Exception){
            databaseRepository.readData()
        }
        return data?: listOf()
    }
}