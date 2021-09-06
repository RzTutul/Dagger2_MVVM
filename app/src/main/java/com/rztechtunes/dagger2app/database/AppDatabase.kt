package com.rztechtunes.dagger2app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rztechtunes.dagger2app.database.model.UserEntity

@Database(entities = [UserEntity::class],version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao():UserDao

    // companion object is singleton objects whose properties and functions are tied to a class but not to the instance of that class —
    companion object{
        private var db_instance:AppDatabase? = null

        fun getAppDatabaseInstance(context: Context):AppDatabase{
            if (db_instance==null)
            {
                db_instance = Room.databaseBuilder(
                    context.applicationContext,AppDatabase::class.java,"my_db"
                ).allowMainThreadQueries().build()
            }

            return db_instance!!
        }
    }


}