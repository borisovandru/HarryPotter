package com.borisov.harrypotter.data.cache

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.data.PersonData
import com.borisov.harrypotter.data.ToPersonMapper

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ListPersonCacheMapper : Abstract.Mapper {

    fun map(persons: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData>

    class Base(private val mapper: ToPersonMapper) : ListPersonCacheMapper {
        override fun map(persons: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData> =
            persons.map { personDb ->
                personDb.map(mapper)
            }
    }
}