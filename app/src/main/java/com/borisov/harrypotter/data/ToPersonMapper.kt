package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract

/**
 * @author Borisov Andrey on 03.04.2022
 **/
// For cloud for one person TODO: 04.04.2022 remove
interface ToPersonMapper : Abstract.Mapper {
    fun map(name: String, image: String): PersonData

    class Base() : ToPersonMapper {
        override fun map(name: String, image: String) = PersonData(name, image)
    }
}