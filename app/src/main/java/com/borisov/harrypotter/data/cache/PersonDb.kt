package com.borisov.harrypotter.data.cache

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.data.PersonData
import com.borisov.harrypotter.data.ToPersonMapper
import io.realm.RealmObject

/**
 * @author Borisov Andrey on 04.04.2022
 **/
open class PersonDb : RealmObject(), Abstract.Object<PersonData, ToPersonMapper> {
    var name: String = ""
    var image: String = ""

    override fun map(mapper: ToPersonMapper) = PersonData(name, image)
}