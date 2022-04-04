package com.borisov.harrypotter.data.cache

import io.realm.Realm

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface DbWrapper {
    fun createObject(): PersonDb

    class Base(private val realm: Realm) : DbWrapper{
        override fun createObject(): PersonDb {
            return realm.createObject(PersonDb::class.java)
        }
    }
}