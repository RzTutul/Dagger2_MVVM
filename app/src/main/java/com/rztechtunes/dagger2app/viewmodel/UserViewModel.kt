package com.rztechtunes.dagger2app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rztechtunes.dagger2app.MyApp
import com.rztechtunes.dagger2app.database.UserDao
import com.rztechtunes.dagger2app.database.model.UserEntity
import javax.inject.Inject

class UserViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var userDao: UserDao
     var alluserInfo:MutableLiveData<List<UserEntity>>

    init {
        (application as MyApp).getAppComponent().inject(this)
        alluserInfo = MutableLiveData()

    }

    fun getAllUserList():MutableLiveData<List<UserEntity>>
    {
        val list = userDao.getAllUserList()
        alluserInfo.postValue(list)
        return alluserInfo
    }

    fun insertUser(userEntity: UserEntity)
    {
        userDao.InsertData(userEntity)
        getAllUserList()
    }

}