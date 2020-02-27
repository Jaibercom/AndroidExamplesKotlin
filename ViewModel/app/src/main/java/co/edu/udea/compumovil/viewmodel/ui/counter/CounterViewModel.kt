package co.edu.udea.compumovil.viewmodel.ui.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    val counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }

    fun onAdd(){
        counter.value = counter.value?.plus(1)
    }

    fun onClear(){
        counter.value = 0
    }
}
