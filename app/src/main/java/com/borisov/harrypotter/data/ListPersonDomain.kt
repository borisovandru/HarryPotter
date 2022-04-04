package com.borisov.harrypotter.data

import com.borisov.harrypotter.core.Abstract

/**
 * @author Borisov Andrey on 04.04.2022
 **/
sealed class ListPersonDomain : Abstract.Object<ListPersonUi, ListPersonDomainToUiMapper> {

    class Success() : ListPersonDomain() {}

    class Fail(private val e: Exception) : ListPersonDomain()
}