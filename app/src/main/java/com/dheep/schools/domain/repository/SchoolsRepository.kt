package com.dheep.schools.domain.repository

import com.dheep.schools.core.common.Resource
import com.dheep.schools.data.dto.SchoolDto

interface SchoolsRepository {

    suspend fun fetchSchools(): Resource<List<SchoolDto>>
}