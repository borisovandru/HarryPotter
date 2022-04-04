package com.borisov.harrypotter.presentation

import com.borisov.harrypotter.data.ErrorType
import com.borisov.harrypotter.domain.ListPersonDomainToUiMapper
import com.borisov.harrypotter.domain.PersonDomain
import com.borisov.harrypotter.domain.PersonDomainToUiMapper

/**
 * @author Borisov Andrey on 04.04.2022
 **/
class BaseListPersonDomainToUiMapper(
    private val resourceProvider: ResourceProvider,
    private val personMapper: PersonDomainToUiMapper,
) : ListPersonDomainToUiMapper {
    override fun map(persons: List<PersonDomain>) = ListPersonUi.Success(persons, personMapper)
    override fun map(errorType: ErrorType) = ListPersonUi.Fail(errorType, resourceProvider)
}