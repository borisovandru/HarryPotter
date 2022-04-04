package com.borisov.harrypotter.domain

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.presentation.PersonUi

/**
 * @author Borisov Andrey on 04.04.2022
 **/
class PersonDomain(private val name: String, private val image: String) :
    Abstract.Object<PersonUi, PersonDomainToUiMapper> {

    override fun map(mapper: PersonDomainToUiMapper) = mapper.map(name, image)
}