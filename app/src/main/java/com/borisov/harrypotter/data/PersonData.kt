package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.domain.PersonDomain

/**
 * @author Borisov Andrey on 04.04.2022
 **/
data class PersonData(private val name: String, private val image: String) :
    Abstract.Object<PersonDomain, PersonDataToDomainMapper> {
    override fun map(mapper: PersonDataToDomainMapper): PersonDomain = mapper.map(name, image)
// TODO: 04.04.2022 ToPersonDb<T, M : Abstract.Mapper>
}
