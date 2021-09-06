package com.rztechtunes.dagger2app.dagger

import com.rztechtunes.dagger2app.viewmodel.AdmissionViewModel
import com.rztechtunes.dagger2app.viewmodel.UserViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(userViewModel: UserViewModel)
    fun inject(admissionViewModel: AdmissionViewModel)

}