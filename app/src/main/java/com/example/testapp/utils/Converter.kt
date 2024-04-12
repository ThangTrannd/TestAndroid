package com.example.testapp.utils

import com.example.testapp.data.Country
import com.example.testapp.data.Flags
import com.example.testapp.data.Language
import com.example.testapp.data.Name
import com.example.testapp.data.NativeName
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

fun convertToCountry(nationEntity: NationEntity): Country {
    val flags = Flags(nationEntity.flags, "", "")
    val language = Language(nationEntity.official, nationEntity.common)
    val nativeName = NativeName(language, language)
    val name = Name(nationEntity.common, nationEntity.official, nativeName)
    return Country(flags, name)
}

fun convertToCountryList(nationEntities: List<NationEntity>): List<Country> {
    return nationEntities.map { convertToCountry(it) }
}