package com.example.rickandmortyapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.api.Repository
import com.example.rickandmortyapp.api.ResultModel
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repository: Repository):ViewModel(){

    private val _charactersLiveData = MutableLiveData<List<ResultModel>>()

    private val TAG = MainViewModel::class.java.simpleName
     val charactersLiveData: LiveData<List<ResultModel>>
     get() = _charactersLiveData

    init {
        getCharacters()
    }


    private fun getCharacters(){
        viewModelScope.launch {

            try {
                _charactersLiveData.value =    repository.getCharactersInpage("1").results
                Log.d(TAG, "${_charactersLiveData.value}")
            }catch (e:Exception){
                Log.e(TAG, e.message.toString())
            }

        }

    }
}