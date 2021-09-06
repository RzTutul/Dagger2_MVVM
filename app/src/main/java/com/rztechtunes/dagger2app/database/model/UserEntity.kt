package com.rztechtunes.dagger2app.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val firstName: String?,
    val lastName: String?
)

