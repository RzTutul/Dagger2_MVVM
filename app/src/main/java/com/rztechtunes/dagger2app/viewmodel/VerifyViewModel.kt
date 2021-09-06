package com.rztechtunes.dagger2app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rztechtunes.dagger2app.model.NidResponse
import com.rztechtunes.dagger2app.repository.DataRepository

class VerifyViewModel() : ViewModel() {
    val dataRepository: DataRepository
    init {
      dataRepository = DataRepository()
    }

    fun getVerifyData() : MutableLiveData<NidResponse>
    {
       return dataRepository.getNidVerify()
    }

}