package com.borisov.harrypotter.domain

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.data.ErrorType
import com.borisov.harrypotter.presentation.ListPersonUi

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ListPersonDomainToUiMapper : Abstract.Mapper {
    fun map(persons: List<PersonDomain>): ListPersonUi
    fun map(errorType: ErrorType) : ListPersonUi
}