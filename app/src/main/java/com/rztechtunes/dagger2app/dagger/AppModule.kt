package com.rztechtunes.dagger2app.dagger

import android.app.Application
import com.google.gson.GsonBuilder
import com.hellohasan.weatherappmvvm.network.ApiInterface
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.rztechtunes.dagger2app.BuildConfig
import com.rztechtunes.dagger2app.database.AppDatabase
import com.rztechtunes.dagger2app.database.UserDao
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {
    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase):UserDao
    {
        return appDatabase.getUserDao()
    }

    @Singleton
    @Provides
    fun getRoomDbInstance():AppDatabase
    {
        return AppDatabase.getAppDatabaseInstance(application.applicationContext)
    }


    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): ApiInterface {
    return retrofit.create(ApiInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitClient() : Retrofit
    {
        var BASE_URL ="http://scm.brac.net/dcs/"
         var retrofit: Retrofit? = null
         val gson = GsonBuilder().setLenient().create()

            if (retrofit == null) {
                synchronized(Retrofit::class.java) {
                    if (retrofit == null) {

                        val httpClient = OkHttpClient.Builder()
//                                .addInterceptor(QueryParameterAddInterceptor())

                        // for pretty log of HTTP request-response
                        httpClient.addInterceptor(
                            LoggingInterceptor.Builder()
                                .loggable(BuildConfig.DEBUG)
                                .setLevel(Level.BASIC)
                                .log(Platform.INFO)
                                .request("LOG")
                                .response("LOG")
                                .executor(Executors.newSingleThreadExecutor())
                                .build())

                        val client = httpClient.build()

                        retrofit = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(client)
                            .build()
                    }
                }

            }
            return retrofit!!
        }



}