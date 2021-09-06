package com.rztechtunes.dagger2app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rztechtunes.dagger2app.model.AdmissionResponse
import com.rztechtunes.dagger2app.repository.DataRepository

class AdmissionViewModel : ViewModel() {
    val dataRepository: DataRepository

    init {
        dataRepository = DataRepository()
    }

    fun getAdmissionData(): MutableLiveData<AdmissionResponse> {
        return dataRepository.getAdmissionData();
    }


}