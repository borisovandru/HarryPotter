package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract

/**
 * @author Borisov Andrey on 04.04.2022
 **/
sealed class ListPersonData : Abstract.Object<ListPersonDomain, ListPersonDataToDomainMapper> {

    data class Success(private val listPerson: List<PersonData>) : ListPersonData() {
        override fun map(mapper: ListPersonDataToDomainMapper): ListPersonDomain =
            mapper.map(listPerson)
    }

    data class Fail(private val e: Exception) : ListPersonData() {
        override fun map(mapper: ListPersonDataToDomainMapper): ListPersonDomain = mapper.map(e)
    }
}