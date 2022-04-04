package com.borisov.harrypotter.data.cache

import io.realm.Realm

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface RealmProvider {

    fun provide(): Realm

    class Base : RealmProvider {
        override fun provide(): Realm = Realm.getDefaultInstance()
    }
}