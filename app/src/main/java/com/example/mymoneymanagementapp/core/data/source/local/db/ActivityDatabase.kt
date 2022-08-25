package com.example.mymoneymanagementapp.core.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mymoneymanagementapp.core.data.source.local.entities.ActivityEntity
import com.example.mymoneymanagementapp.core.data.source.local.entities.UserEntity

@Database(
    entities = [ActivityEntity::class, UserEntity::class],
    version = 1
)
abstract class ActivityDatabase: RoomDatabase() {
    abstract fun activityDao(): ActivityDao
    abstract fun userDao(): UserDao
}