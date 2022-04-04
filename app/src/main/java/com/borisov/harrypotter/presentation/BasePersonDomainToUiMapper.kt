package com.borisov.harrypotter.presentation

import com.borisov.harrypotter.domain.PersonDomainToUiMapper

/**
 * @author Borisov Andrey on 04.04.2022
 **/
class BasePersonDomainToUiMapper : PersonDomainToUiMapper {
    override fun map(name: String, image: String) = PersonUi.Base(name, image)
}