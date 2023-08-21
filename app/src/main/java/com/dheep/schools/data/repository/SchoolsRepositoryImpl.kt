package com.dheep.schools.data.repository

import com.dheep.schools.core.common.Resource
import com.dheep.schools.data.dto.SchoolDto
import com.dheep.schools.data.source.RemoteDataSource
import com.dheep.schools.domain.repository.SchoolsRepository
import javax.inject.Inject

class SchoolsRepositoryImpl @Inject constructor(
    private val dataSource: RemoteDataSource
) : SchoolsRepository {
    override suspend fun fetchSchools(): Resource<List<SchoolDto>> {
        return try {
            val result = dataSource.fetchSchools()
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(error = e.message)
        }
    }
}