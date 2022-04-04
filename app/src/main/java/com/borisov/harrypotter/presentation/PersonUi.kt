package com.borisov.harrypotter.presentation

import com.borisov.harrypotter.core.Abstract

/**
 * @author Borisov Andrey on 04.04.2022
 **/
sealed class PersonUi : Abstract.Object<Unit, PersonUi.StringMapper> {
    override fun map(mapper: StringMapper) = Unit

    object Progress : PersonUi()

    class Base(
        private val name: String,
        private val image: String,
    ) : PersonUi() {
        override fun map(mapper: StringMapper) = mapper.map(name)
    }

    class Fail(
        private val message: String,
    ) : PersonUi() {
        override fun map(mapper: StringMapper) = mapper.map(message)
    }

    interface StringMapper : Abstract.Mapper {
        fun map(text: String)
    }
}