package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.data.cache.DbWrapper
import com.borisov.harrypotter.data.cache.PersonDataToDbMapper
import com.borisov.harrypotter.data.cache.PersonDb
import com.borisov.harrypotter.domain.PersonDomain

/**
 * @author Borisov Andrey on 04.04.2022
 **/
data class PersonData(private val name: String, private val image: String) :
    ToPersonDb<PersonDb, PersonDataToDbMapper>,
    Abstract.Object<PersonDomain, PersonDataToDomainMapper> {
    override fun map(mapper: PersonDataToDomainMapper): PersonDomain = mapper.map(name, image)
    override fun mapTo(mapper: PersonDataToDbMapper, db: DbWrapper) =
        mapper.mapToDb(name, image, db)
}

//todo make it better later
interface ToPersonDb<T, M : Abstract.Mapper> {

    fun mapTo(mapper: M, db: DbWrapper): T
}
