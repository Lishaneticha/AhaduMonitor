package com.acs.ahadumonitor.di

import android.app.Application
import android.content.Context
import com.acs.ahadumonitor.UserApp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ContextBindingModule {

    @Binds
    abstract fun context(userApp: UserApp): Context
}