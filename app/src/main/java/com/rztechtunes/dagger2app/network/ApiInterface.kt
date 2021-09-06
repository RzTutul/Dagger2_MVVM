package com.hellohasan.weatherappmvvm.network

import com.rztechtunes.dagger2app.model.AdmissionResponse
import com.rztechtunes.dagger2app.model.NidResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiInterface {
    @POST("NIDVerification")
    fun nidverify(@Query("appid") appID: String,
                     @Query("apikey") apikey: String,
                     @Query("nid") NidNumber: String): Call<NidResponse>

 @POST("BmAdmissionDataSync")
    fun getAdmissionData(@Query("branchcode") branchcode: String): Call<AdmissionResponse>


}