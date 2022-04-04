package com.borisov.harrypotter.data

import com.borisov.harrypotter.data.cache.ListPersonCacheDataSource
import com.borisov.harrypotter.data.cache.ListPersonCacheMapper
import com.borisov.harrypotter.data.net.ListPersonCloudDataSource
import com.borisov.harrypotter.data.net.ListPersonCloudMapper

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface PersonRepository {

    suspend fun fetchListPerson(): ListPersonData

    class Base(
        private val cloudDataSource: ListPersonCloudDataSource,
        private val cacheDataSource: ListPersonCacheDataSource,
        private val listPersonCloudMapper: ListPersonCloudMapper,
        private val listPersonCacheMapper: ListPersonCacheMapper,
    ) : PersonRepository {
        override suspend fun fetchListPerson(): ListPersonData = try {
            val listPersonCache = cacheDataSource.fetchListPerson()
            if (listPersonCache.isEmpty()) {
                val listPersonCloud = cloudDataSource.fetchListPerson()
                val personList = listPersonCloudMapper.map(listPersonCloud)
                cacheDataSource.saveListPerson(personList)
                ListPersonData.Success(personList)
            } else {
                ListPersonData.Success(listPersonCacheMapper.map(listPersonCache))
            }
        } catch (e: Exception) {
            ListPersonData.Fail(e)
        }
    }
}