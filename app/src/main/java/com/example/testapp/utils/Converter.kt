package com.example.testapp.utils

import com.example.testapp.data.Country
import com.example.testapp.data.entity.NationEntity

fun convertToNationEntity(country: Country): NationEntity {
    return NationEntity(
        flags = country.flags.png,
        common = country.name.common,
        official = country.name.official
    )
}

fun convertToNationEntities(countries: List<Country>): List<NationEntity> {
    return countries.map { convertToNationEntity(it) }
}