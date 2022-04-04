package com.borisov.harrypotter.data.cache

import com.borisov.harrypotter.data.PersonData

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ListPersonCacheDataSourse {

    fun fetchListPerson(): List<PersonDb>

    fun saveListPerson(persons: List<PersonData>)

    class Base(
        private val realmProvider : RealmProvider,
        private val mapper: PersonDataToDbMapper
    ) : ListPersonCacheDataSourse{
        override fun fetchListPerson(): List<PersonDb> {
            TODO("Not yet implemented")
        }

        override fun saveListPerson(persons: List<PersonData>) {
            TODO("Not yet implemented")
        }
    }

}