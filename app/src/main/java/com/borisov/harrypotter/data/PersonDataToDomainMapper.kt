package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract

/**
 * @author Borisov Andrey on 03.04.2022
 **/
interface PersonDataToDomainMapper:Abstract.Mapper {
    fun map(name:String, image:String): PersonDomain
}