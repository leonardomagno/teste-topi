package com.example.testetopi.ui.repositorieslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testetopi.models.RepositoryVO
import com.example.testetopi.models.ViewData
import com.example.testetopi.models.enums.ViewStatus
import com.example.testetopi.repository.Repository

class RepositoriesListViewModel : ViewModel() {

    val liveDataRepository = MutableLiveData<ViewData<List<RepositoryVO>>>()

    val repository = Repository

    fun repositoriesList(q: String, sort: String, page: String) {

        liveDataRepository.value = ViewData(viewStatus = ViewStatus.LOADING)
        repository.getRepositorieslList(q, sort, page,
            onSucess = {
                liveDataRepository.value = ViewData(data = it, viewStatus = ViewStatus.SUCCESS)
            },
            onError = {
                liveDataRepository.value = ViewData(viewStatus = ViewStatus.ERROR)
            }
        )
    }
}