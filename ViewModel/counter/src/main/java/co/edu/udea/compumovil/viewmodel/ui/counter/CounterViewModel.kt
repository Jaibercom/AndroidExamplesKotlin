package co.edu.udea.compumovil.viewmodel.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val counterLiveData = MutableLiveData<Int>()

    init {
        counterLiveData.value = 0
    }

    fun getCounter(): LiveData<Int> = counterLiveData

    fun onAdd() {
        counterLiveData.value = counterLiveData.value?.plus(1)
    }

    fun onClear() {
        counterLiveData.value = 0
    }
}
