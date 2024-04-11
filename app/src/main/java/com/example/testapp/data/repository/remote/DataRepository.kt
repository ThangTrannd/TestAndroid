package com.example.testapp.data.repository.remote

import com.example.testapp.data.Country
import com.example.testapp.data.repository.RepositoryInterface
import com.example.testapp.data.repository.local.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(val remoteRepository: RemoteRepository, private val ioDispatcher: CoroutineContext):
    RepositoryInterface {
    override suspend fun fetchItem(): Flow<List<Country>> {
        return flow {
            emit(
                remoteRepository.fetchNation()
            )
        }.flowOn(ioDispatcher)
    }
}