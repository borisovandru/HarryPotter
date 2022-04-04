package com.borisov.harrypotter.presentation

import com.borisov.harrypotter.R
import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.data.ErrorType
import com.borisov.harrypotter.domain.PersonDomain
import com.borisov.harrypotter.domain.PersonDomainToUiMapper

/**
 * @author Borisov Andrey on 04.04.2022
 **/
sealed class ListPersonUi : Abstract.Object<Unit, PersonListCommunication> {

    class Success(
        private val listPerson: List<PersonDomain>,
        private val personMapper: PersonDomainToUiMapper,
    ) : ListPersonUi() {
        override fun map(mapper: PersonListCommunication) {
            val personsUi = listPerson.map {
                it.map(personMapper)
            }
            mapper.map(personsUi)
        }
    }

    class Fail(
        private val errorType: ErrorType,
        private val resourceProvider: ResourceProvider,
    ) : ListPersonUi() {
        override fun map(mapper: PersonListCommunication) {
            val messageId = when (errorType) {
                ErrorType.NO_CONNECTION -> R.string.no_connection_message
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable_message
                else -> R.string.something_went_wrong
            }
            val message = resourceProvider.getString(messageId)
            mapper.map(listOf(PersonUi.Fail(message)))
        }
    }
}