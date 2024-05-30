package com.monosoft.ecommercebenja.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.monosoft.ecommercebenja.data.dataSource.local.datastore.AuthDatastore
import com.monosoft.ecommercebenja.core.Config.AUTH_PREFERENCE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Este objeto nos provee el la instancia del data store y le pasa mos el nombre del datastore
 * para poder inyectarlo eb  cualquier parte de la aplicación
 */

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

     //shared prwferences
     //se provee la instancia de data store
     @Provides
     @Singleton//se agrega cuando viene de una dependencia externa
    fun providePreferenceDataStore(@ApplicationContext context : Context) : DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
          produceFile = {
                 context.preferencesDataStoreFile(AUTH_PREFERENCE)
          }
        )

    //se provee el AuthDatastore para poder inyectarla y le pasamos el datastore
    @Provides
    @Singleton
    fun provideAuthDatastore(dataStore: DataStore<Preferences>) = AuthDatastore(dataStore)


}