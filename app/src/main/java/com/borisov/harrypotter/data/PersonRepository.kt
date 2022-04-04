package com.borisov.harrypotter.data

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface PersonRepository {

    suspend fun fetchListPerson(): ListPersonData

    class Base() : PersonRepository {
        override suspend fun fetchListPerson(): ListPersonData {
            TODO("Not yet implemented")
        }
    }
}