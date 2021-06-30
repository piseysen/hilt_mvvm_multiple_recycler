package com.pisey.hiltmvvmexample.di

import com.pisey.hiltmvvmexample.data.network.Api
import com.pisey.hiltmvvmexample.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTargetApi(remoteDataSource: RemoteDataSource): Api {
        return remoteDataSource.buildApi(Api::class.java)
    }

}