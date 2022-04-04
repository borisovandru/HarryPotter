package com.borisov.harrypotter.core

/**
 * @author Borisov Andrey on 03.04.2022
 **/
abstract class Abstract {

    interface Object<T, M : Mapper> {

        fun map(mapper: M): T
    }

    interface Mapper {
        class Empty : Mapper
    }
}