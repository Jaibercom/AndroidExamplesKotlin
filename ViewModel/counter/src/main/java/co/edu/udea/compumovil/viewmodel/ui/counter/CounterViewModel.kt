package co.edu.udea.compumovil.viewmodel.ui.counter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val counterLiveData = MutableLiveData<Int>()

    init {
        Log.d(TAG, "CounterViewModel created!")
        counterLiveData.value = 0
    }

    fun getCounter(): LiveData<Int> = counterLiveData

    fun onAdd() {
        Log.d(TAG, "on add value")
        counterLiveData.value = counterLiveData.value?.plus(1)
    }

    fun onClear() {
        Log.d(TAG, "on clear value")
        counterLiveData.value = 0
    }

    override fun onCleared() {
        Log.d(TAG, "CounterViewModel onCleared")
        super.onCleared()
    }

    companion object {
        private const val TAG = "Counter ViewModel"
    }
}
