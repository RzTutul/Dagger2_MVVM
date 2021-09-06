package com.rztechtunes.dagger2app

import android.app.Application
import com.rztechtunes.dagger2app.dagger.AppComponent
import com.rztechtunes.dagger2app.dagger.AppModule
import com.rztechtunes.dagger2app.dagger.DaggerAppComponent

class MyApp : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    fun getAppComponent(): AppComponent{
        return appComponent
    }
}