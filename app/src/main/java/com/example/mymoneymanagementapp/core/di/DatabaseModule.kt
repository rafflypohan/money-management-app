package com.example.mymoneymanagementapp.core.di

import android.content.Context
import androidx.room.Room
import com.example.mymoneymanagementapp.core.data.source.local.db.ActivityDao
import com.example.mymoneymanagementapp.core.data.source.local.db.ActivityDatabase
import com.example.mymoneymanagementapp.core.data.source.local.db.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideActivityDao(activityDatabase: ActivityDatabase): ActivityDao {
        return activityDatabase.activityDao()
    }

    @Provides
    fun provideUserDao(activityDatabase: ActivityDatabase): UserDao{
        return activityDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext appContext: Context): ActivityDatabase {
        return Room.databaseBuilder(
            appContext,
            ActivityDatabase::class.java, "MoneyManager.db"
        ).fallbackToDestructiveMigration().build()
    }
}