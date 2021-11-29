package com.tooru.majordome.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tooru.domain.interactor.EventsInteractor
import com.tooru.domain.model.Event
import com.tooru.majordome.Resource
import com.tooru.majordome.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateEventViewModel @Inject constructor(private val eventsInteractor: EventsInteractor) :
    ViewModel() {

    private val _eventCreatingStatus = MutableLiveData<Resource<Unit>>()

    val eventCreatingStatus = _eventCreatingStatus.asLiveData()

    fun createEvent(event: Event) {
        Log.d("CreateEventViewModel", "createEvent $event")

        viewModelScope.launch {
            _eventCreatingStatus.postValue(Resource.loading(null))
            try {
                eventsInteractor.createEvent(event)
                _eventCreatingStatus.postValue(Resource.success(null))

                Log.d("EventRepositoryImpl", "success")
            } catch (e: Exception) {
                _eventCreatingStatus.postValue(Resource.error("Something Went Wrong", null))
                Log.d("EventRepositoryImpl", "Something Went Wrong $e")

            }
        }


    }


}