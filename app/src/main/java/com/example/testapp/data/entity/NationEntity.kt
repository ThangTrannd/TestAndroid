package com.example.testapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "nation_entity")
data class NationEntity(
    @ColumnInfo(name = "flags")
    val flags: String = "",

    @PrimaryKey
    @ColumnInfo(name = "common")
    val common: String = "",

    @ColumnInfo(name = "official")
    val official: String = ""
)
