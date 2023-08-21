package com.dheep.schools.presentation.state

import com.dheep.schools.data.dto.SchoolDto

sealed interface SchoolsUIState {

    class Success(val data: List<SchoolDto>) : SchoolsUIState

    class Error(val message: String) : SchoolsUIState

    object Empty : SchoolsUIState

    object Loading : SchoolsUIState
}