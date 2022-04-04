package com.borisov.harrypotter.data.cache

import com.borisov.harrypotter.data.PersonData

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ListPersonCacheDataSource {

    fun fetchListPerson(): List<PersonDb>

    fun saveListPerson(persons: List<PersonData>)

    class Base(
        private val realmProvider: RealmProvider,
        private val mapper: PersonDataToDbMapper,
    ) : ListPersonCacheDataSource {
        override fun fetchListPerson(): List<PersonDb> {
            realmProvider.provide().use { realm ->
                val personsDb = realm.where(PersonDb::class.java).findAll() ?: emptyList()
                return realm.copyFromRealm(personsDb)
            }
        }

        override fun saveListPerson(persons: List<PersonData>) =
            realmProvider.provide().use { realm ->
                realm.executeTransaction {
                    persons.forEach { person ->
                        person.mapTo(mapper, DbWrapper.Base(it))
                    }
                }
            }
    }
}