package com.borisov.harrypotter.domain

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.data.ErrorType
import com.borisov.harrypotter.data.PersonData
import com.borisov.harrypotter.data.PersonDataToDomainMapper
import com.borisov.harrypotter.presentation.ListPersonUi
import retrofit2.HttpException
import java.net.UnknownHostException

/**
 * @author Borisov Andrey on 04.04.2022
 **/
sealed class ListPersonDomain : Abstract.Object<ListPersonUi, ListPersonDomainToUiMapper> {

    class Success(
        private val persons: List<PersonData>,
        private val personMapper: PersonDataToDomainMapper,
    ) : ListPersonDomain() {
        override fun map(mapper: ListPersonDomainToUiMapper): ListPersonUi =
            mapper.map(persons.map {
                it.map(personMapper)
            })
    }

    class Fail(private val e: Exception) : ListPersonDomain() {
        override fun map(mapper: ListPersonDomainToUiMapper): ListPersonUi = mapper.map(
            when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_ERROR
            }
        )
    }
}