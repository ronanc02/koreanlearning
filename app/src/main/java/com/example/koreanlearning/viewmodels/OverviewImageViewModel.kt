package com.example.koreanlearning.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koreanlearning.network.ImageApi
import kotlinx.coroutines.launch

class OverviewImageViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
//    private val _status = MutableList<String>

    // The external immutable LiveData for the request status
 //   val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
//    init {
 //       getMarsPhotos()
 //   }

    private fun getImages() {
        viewModelScope.launch {
            try {
                val listResult = ImageApi.retrofitService.search("pool", 20, 1)
   //             _status.value = "Success: ${listResult.size} photos retrieved"
            } catch (e: Exception) {
     //           _status.value = "Failure: ${e.message}"
            }
        }
    }

//    }
}