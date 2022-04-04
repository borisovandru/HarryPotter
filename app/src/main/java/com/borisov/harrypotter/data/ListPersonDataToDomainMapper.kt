package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.domain.ListPersonDomain

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ListPersonDataToDomainMapper : Abstract.Mapper {

    fun map(persons: List<PersonData>): ListPersonDomain
    fun map(e: Exception): ListPersonDomain
}