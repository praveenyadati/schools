package com.dheep.schools.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dheep.schools.core.common.Resource
import com.dheep.schools.domain.repository.SchoolsRepository
import com.dheep.schools.presentation.state.SchoolsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolsViewModel @Inject constructor(
    private val repository: SchoolsRepository
) : ViewModel() {

    private val _schoolsData = MutableLiveData<SchoolsUIState>()
    val schoolsData: LiveData<SchoolsUIState> = _schoolsData

    init {
        fetchSchoolsData()
    }

    private fun fetchSchoolsData() {
        _schoolsData.postValue(SchoolsUIState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.fetchSchools()) {
                is Resource.Success -> {
                    result.data?.let {
                        if (it.isNotEmpty()) {
                            _schoolsData.postValue(SchoolsUIState.Success(it))
                        } else {
                            _schoolsData.postValue(SchoolsUIState.Empty)
                        }
                    }
                }

                is Resource.Error -> {
                    result.error?.let {
                        _schoolsData.postValue(SchoolsUIState.Error(it))
                    }
                }
            }
        }
    }

}