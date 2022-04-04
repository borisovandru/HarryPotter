package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.domain.PersonDomain

/**
 * @author Borisov Andrey on 03.04.2022
 **/
interface PersonDataToDomainMapper : Abstract.Mapper {
    fun map(name: String, image: String): PersonDomain
}