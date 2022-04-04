package com.borisov.harrypotter.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borisov.harrypotter.domain.ListPersonDomainToUiMapper
import com.borisov.harrypotter.domain.ListPersonInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Borisov Andrey on 04.04.2022
 **/
class MainViewModel(
    private val personsInteractor: ListPersonInteractor,
    private val mapper: ListPersonDomainToUiMapper,
    private val communication: PersonListCommunication,
) : ViewModel() {//todo interface

    fun fetchPerson() {
        communication.map(listOf(PersonUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = personsInteractor.fetchListPerson()
            val resultUi = resultDomain.map(mapper)
            withContext(Dispatchers.Main) {
                resultUi.map(communication)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<PersonUi>>) {
        communication.observe(owner, observer)
    }
}