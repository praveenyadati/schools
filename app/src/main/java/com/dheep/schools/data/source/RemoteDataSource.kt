package com.dheep.schools.data.source

import com.dheep.schools.data.api.SchoolsApi
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: SchoolsApi) {

    suspend fun fetchSchools() = api.fetchSchools()
}