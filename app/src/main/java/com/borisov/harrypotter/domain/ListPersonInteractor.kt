package com.borisov.harrypotter.domain

import com.borisov.harrypotter.data.ListPersonDataToDomainMapper
import com.borisov.harrypotter.data.PersonRepository

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ListPersonInteractor {

    suspend fun fetchListPerson(): ListPersonDomain

    class Base(
        private val personRepository: PersonRepository,
        private val mapper: ListPersonDataToDomainMapper
    ) : ListPersonInteractor{
        override suspend fun fetchListPerson(): ListPersonDomain = personRepository.fetchListPerson().map(mapper)
    }
}