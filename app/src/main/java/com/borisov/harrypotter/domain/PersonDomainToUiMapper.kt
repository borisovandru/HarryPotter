package com.borisov.harrypotter.domain

import com.borisov.harrypotter.core.Abstract
import com.borisov.harrypotter.presentation.PersonUi

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface PersonDomainToUiMapper : Abstract.Mapper {

    fun map(name:String, image:String) : PersonUi
}