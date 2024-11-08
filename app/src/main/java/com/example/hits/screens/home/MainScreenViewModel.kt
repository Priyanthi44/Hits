package com.example.hits.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.hits.HitsApplication
import com.example.hits.data.DataOrException
import com.example.hits.model.AllHits
import com.example.hits.repository.HitsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
class MainScreenViewModel (
    private val repository: HitsRepository

) : ViewModel() {

    val data: MutableState<DataOrException<AllHits, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        getAllHits();
    }

    private fun getAllHits() {
        viewModelScope.launch {
            data.value.loading = true;
            data.value = repository.getHits();
            if (data.value.data.toString().isNotEmpty()) data.value.loading = false;
        }
        println(data.value.data.toString());
    }


}
