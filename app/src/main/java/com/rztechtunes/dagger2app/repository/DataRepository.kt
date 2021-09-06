package com.rztechtunes.dagger2app.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hellohasan.weatherappmvvm.network.ApiInterface
import com.hellohasan.weatherappmvvm.network.RetrofitClient
import com.rztechtunes.dagger2app.model.AdmissionResponse
import com.rztechtunes.dagger2app.model.NidResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class DataRepository {

    val myResponse: MutableLiveData<NidResponse> = MutableLiveData()
    val admissionResponse: MutableLiveData<AdmissionResponse> = MutableLiveData()

    @Inject
    lateinit var apiInterface: ApiInterface


    fun getNidVerify():MutableLiveData<NidResponse>
    {

        val apiInterface: ApiInterface = RetrofitClient.client.create(ApiInterface::class.java)

        val call: Call<NidResponse> = apiInterface.nidverify("BMSM","fdsa","12345678910112")

        call.enqueue(object : Callback<NidResponse> {

            // if retrofit network call success, this method will be triggered
            override fun onResponse(call: Call<NidResponse>, response: Response<NidResponse>) {
                if (response.body() != null)
                {
                    myResponse.postValue(response.body())

                }
             //let presenter know the weather information data

                  //  callback.onRequestFailed(response.message()) //let presenter know about failure
            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<NidResponse>, t: Throwable) {
                Log.i(TAG, "onFailure: "+t.localizedMessage)
            }
        })

        return myResponse

    }

    fun getAdmissionData():MutableLiveData<AdmissionResponse>
    {
        val call: Call<AdmissionResponse> = apiInterface.getAdmissionData("0605")

        call.enqueue(object : Callback<AdmissionResponse> {

            // if retrofit network call success, this method will be triggered
            override fun onResponse(call: Call<AdmissionResponse>, response: Response<AdmissionResponse>) {
                if (response.body() != null)
                {
                    admissionResponse.postValue(response.body())
                }
             //let presenter know the weather information data

                  //  callback.onRequestFailed(response.message()) //let presenter know about failure
            }

            // this method will be triggered if network call failed
            override fun onFailure(call: Call<AdmissionResponse>, t: Throwable) {
                Log.i(TAG, "onFailure: "+t.localizedMessage)
            }
        })

        return admissionResponse

    }



}