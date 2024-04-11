package com.example.testapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.testapp.data.entity.NationEntity

@Dao
interface CountryDao {

    @Upsert
    suspend fun insertAll(country: List<NationEntity?>)

    @Query("SELECT * FROM nation_entity")
    fun getData(): List<NationEntity>

    @Query("DELETE FROM nation_entity")
    suspend fun clearAll()
}