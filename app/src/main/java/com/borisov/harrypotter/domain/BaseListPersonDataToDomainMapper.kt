package com.borisov.harrypotter.domain

import com.borisov.harrypotter.data.ListPersonDataToDomainMapper
import com.borisov.harrypotter.data.PersonData
import com.borisov.harrypotter.data.PersonDataToDomainMapper

/**
 * @author Borisov Andrey on 04.04.2022
 **/
class BaseListPersonDataToDomainMapper(private val personMapper: PersonDataToDomainMapper) :
    ListPersonDataToDomainMapper {
    override fun map(persons: List<PersonData>) = ListPersonDomain.Success(persons, personMapper)
    override fun map(e: Exception): ListPersonDomain = ListPersonDomain.Fail(e)
}