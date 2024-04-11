package com.example.testapp.data

data class Country(
    val flags: Flags,
    val name: Name
)

data class Flags(
    val png: String,
    val svg: String,
    val alt: String
)

data class Name(
    val common: String,
    val official: String,
    val nativeName: NativeName
)

data class NativeName(
    val ell: Language,
    val tur: Language
)

data class Language(
    val official: String,
    val common: String
)

