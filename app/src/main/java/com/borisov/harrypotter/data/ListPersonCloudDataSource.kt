package com.borisov.harrypotter.data

import com.borisov.harrypotter.data.net.PersonCloud
import com.borisov.harrypotter.data.net.PersonsService

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ListPersonCloudDataSource {
    suspend fun fetchListPerson(): List<PersonCloud>

    class Base(private val service: PersonsService) : ListPersonCloudDataSource {
        override suspend fun fetchListPerson(): List<PersonCloud> = service.fetchBooks()
    }
}