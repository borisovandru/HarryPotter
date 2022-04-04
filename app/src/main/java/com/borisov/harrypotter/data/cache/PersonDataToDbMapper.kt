package com.borisov.harrypotter.data.cache

import com.borisov.harrypotter.core.Abstract

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface PersonDataToDbMapper : Abstract.Mapper {
    fun mapToDb(name: String, image: String, db: DbWrapper): PersonDb

    class Base : PersonDataToDbMapper {
        override fun mapToDb(name: String, image: String, db: DbWrapper): PersonDb {
            val personDb = db.createObject()
            personDb.name = name
            personDb.image = image
            return personDb
        }
    }
}