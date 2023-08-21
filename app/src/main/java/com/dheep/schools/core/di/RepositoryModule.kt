package com.dheep.schools.core.di

import com.dheep.schools.data.repository.SchoolsRepositoryImpl
import com.dheep.schools.data.source.RemoteDataSource
import com.dheep.schools.domain.repository.SchoolsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(source: RemoteDataSource): SchoolsRepository {
        return SchoolsRepositoryImpl(source)
    }
}