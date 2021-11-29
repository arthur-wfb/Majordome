package com.tooru.data.di

import android.content.Context
import androidx.room.Room
import com.tooru.data.interactor.EventsInteractorImpl
import com.tooru.data.local.db.AppDatabase
import com.tooru.data.repository.EventRepositoryImpl
import com.tooru.domain.interactor.EventsInteractor
import com.tooru.domain.repository.EventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "majordomeDB").fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providerEventRepository(repository: EventRepositoryImpl): EventRepository {
        return repository
    }

    @Provides
    @Singleton
    fun providerEventsInteractor(interactor: EventsInteractorImpl): EventsInteractor {
        return interactor
    }
}