package com.borisov.harrypotter.data.net

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.data.PersonData
import com.borisov.harrypotter.data.ToPersonMapper

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ListPersonCloudMapper : Abstract.Mapper {

    fun map(cloudList: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData>

    class Base(private val personMapper: ToPersonMapper) : ListPersonCloudMapper {
        override fun map(cloudList: List<Abstract.Object<PersonData, ToPersonMapper>>): List<PersonData> =
            cloudList.map { personCloud ->
                personCloud.map(personMapper)
            }
    }
}