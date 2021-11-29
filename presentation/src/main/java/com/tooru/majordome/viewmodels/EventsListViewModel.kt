package com.tooru.majordome.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tooru.domain.interactor.EventsInteractor
import com.tooru.domain.model.Event
import com.tooru.majordome.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EventsListViewModel @Inject constructor(private val eventsInteractor: EventsInteractor) :
    ViewModel() {

    private val _events = MutableLiveData<List<Event>>()

    val events = _events.asLiveData()

   fun getEvents() {
       viewModelScope.launch(Dispatchers.IO) {
           try {
               _events.postValue(eventsInteractor.getEvents())

               Log.d("EventRepositoryImpl", "success")
           } catch (e: Exception) {
               Log.d("EventRepositoryImpl", "Something Went Wrong $e")

           }
       }
   }


}