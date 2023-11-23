package com.example.gatestdemol.tabbar

data class CityResponse(
    val code: String,
    val message: String,
    val data: CityDataInfo
)

data class  CityDataInfo(
    val page: Int,
    var pageSize: Int,
    var totalPages: Int,
    var totalItems: Int,
    val data: List<CityModel>
)

data class CityModel(
    val id: Int,
    val name: String,
    val code: String
)

data class PageRequest(
    val page: Int,
    val pageSize: Int
)