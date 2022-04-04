package com.borisov.harrypotter.domain

import com.borisov.harrypotter.data.PersonDataToDomainMapper

/**
 * @author Borisov Andrey on 04.04.2022
 **/
class BasePersonDataToDomainMapper : PersonDataToDomainMapper {
    override fun map(name: String, image: String) = PersonDomain(name, image)
}