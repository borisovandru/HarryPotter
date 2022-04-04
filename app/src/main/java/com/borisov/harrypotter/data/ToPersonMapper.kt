package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract

/**
 * @author Borisov Andrey on 03.04.2022
 **/

interface ToPersonMapper : Abstract.Mapper {

    fun map(name: String, image: String): PersonData

    class Base : ToPersonMapper {
        override fun map(name: String, image: String) = PersonData(name, image)
    }
}