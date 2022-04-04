package com.borisov.harrypotter.core

import android.app.Application
import com.borisov.harrypotter.data.PersonRepository
import com.borisov.harrypotter.data.ToPersonMapper
import com.borisov.harrypotter.data.cache.ListPersonCacheDataSource
import com.borisov.harrypotter.data.cache.ListPersonCacheMapper
import com.borisov.harrypotter.data.cache.PersonDataToDbMapper
import com.borisov.harrypotter.data.cache.RealmProvider
import com.borisov.harrypotter.data.net.ListPersonCloudDataSource
import com.borisov.harrypotter.data.net.ListPersonCloudMapper
import com.borisov.harrypotter.data.net.PersonsService
import com.borisov.harrypotter.domain.BaseListPersonDataToDomainMapper
import com.borisov.harrypotter.domain.BasePersonDataToDomainMapper
import com.borisov.harrypotter.domain.ListPersonInteractor
import com.borisov.harrypotter.presentation.*
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Borisov Andrey on 03.04.2022
 **/
class PotterApp : Application() {
    private companion object {
        const val BASE_URL = "http://hp-api.herokuapp.com/api/"
    }

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PersonsService::class.java)
        val cloudDataSource = ListPersonCloudDataSource.Base(service)
        val cacheDataSource =
            ListPersonCacheDataSource.Base(RealmProvider.Base(), PersonDataToDbMapper.Base())
        val toPersonMapper = ToPersonMapper.Base()
        val booksCloudMapper = ListPersonCloudMapper.Base(toPersonMapper)
        val booksCacheMapper = ListPersonCacheMapper.Base(toPersonMapper)
        val personRepository = PersonRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
        val personsInteractor = ListPersonInteractor.Base(
            personRepository,
            BaseListPersonDataToDomainMapper(BasePersonDataToDomainMapper())
        )
        val communication = PersonListCommunication.Base()
        mainViewModel = MainViewModel(
            personsInteractor,
            BaseListPersonDomainToUiMapper(ResourceProvider.Base(this),
                BasePersonDomainToUiMapper()),
            communication
        )
    }
}