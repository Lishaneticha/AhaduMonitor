package com.acs.ahadumonitor.di

import com.acs.ahadumonitor.feature_users.network.HostPingService
import com.acs.ahadumonitor.feature_users.network.model.HostNetworkMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHostNetworkMapper(): HostNetworkMapper {
        return HostNetworkMapper()
    }

    @Singleton
    @Provides
    fun provideHostPingService(): HostPingService {
        return Retrofit.Builder()
            .baseUrl("http://192.168.8.101:1994")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(HostPingService::class.java)
    }

}