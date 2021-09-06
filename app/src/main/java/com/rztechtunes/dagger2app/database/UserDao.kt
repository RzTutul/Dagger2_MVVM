package com.rztechtunes.dagger2app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rztechtunes.dagger2app.database.model.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertData(userEntity: UserEntity)

    @Query("select * from user_info")
    fun getAllUserList(): List<UserEntity>
}