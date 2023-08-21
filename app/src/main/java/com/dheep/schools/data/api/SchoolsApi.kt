package com.dheep.schools.data.api

import com.dheep.schools.data.dto.SchoolDto
import retrofit2.http.GET

interface SchoolsApi {

    @GET("/resource/s3k6-pzi2.json")
    suspend fun fetchSchools(): List<SchoolDto>


    companion object {
        const val BASE_URL = "https://data.cityofnewyork.us"
    }

}