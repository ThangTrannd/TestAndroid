package com.example.testapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.Country
import com.example.testapp.data.repository.local.DatabaseRepository
import com.example.testapp.data.repository.local.DatabaseRepositoryImpl
import com.example.testapp.data.repository.remote.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val dataRepository: DataRepository,val databaseRepository: DatabaseRepository) : ViewModel(){

    private var _nationalState = MutableStateFlow<List<Country>>(listOf())
    val nationalState = _nationalState.asStateFlow()

    fun fetchData(){
        viewModelScope.launch {
            dataRepository.fetchItem().collect { items ->
                _nationalState.value = items
                items.let {
                    databaseRepository.saveData(it)
                }
            }
        }
    }
}