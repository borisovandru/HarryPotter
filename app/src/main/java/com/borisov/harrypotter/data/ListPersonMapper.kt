package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ListPersonMapper : Abstract.Mapper {

    fun map(cloudList: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData>

    class Base(private val personMapper: ToPersonMapper) : ListPersonMapper {
        override fun map(cloudList: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData> =
            cloudList.map { personCloud ->
                personCloud.map(personMapper)
            }
    }
}