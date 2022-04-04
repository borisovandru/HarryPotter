package com.borisov.harrypotter.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.borisov.harrypotter.core.Abstract

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface PersonListCommunication : Abstract.Mapper {
    fun map(listPerson: List<PersonUi>)
    fun observe(owner: LifecycleOwner, observer: Observer<List<PersonUi>>)

    class Base : PersonListCommunication {
        private val listLiveData = MutableLiveData<List<PersonUi>>()
        override fun observe(owner: LifecycleOwner, observer: Observer<List<PersonUi>>) {
            listLiveData.observe(owner, observer)
        }

        override fun map(listPerson: List<PersonUi>) {
            listLiveData.value = listPerson
        }
    }
}