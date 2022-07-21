package com.acs.ahadumonitor.di

import android.app.Application
import androidx.room.Room
import com.acs.ahadumonitor.feature_users.data.repository.UserRepositoryImpl
import com.acs.ahadumonitor.feature_users.data.source.local.UserDatabase
import com.acs.ahadumonitor.feature_users.domain.repository.UserRepository
import com.androidperu.peopleapp.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application) = Room.databaseBuilder(
        app,
        UserDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao)
    }
}