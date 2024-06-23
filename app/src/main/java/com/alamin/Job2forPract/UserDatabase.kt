package com.alamin.Job2forPract

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao
    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null
        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(contex: android.content.Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instant= Room.databaseBuilder(
                    contex.applicationContext,
                    UserDatabase::class.java,
                    "user_profiledatabase"
                ) .build()
                INSTANCE = instant
                instant}

        }
    }
}