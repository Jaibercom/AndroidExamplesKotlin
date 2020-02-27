package co.edu.udea.compumovil.viewmodel.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>()
    val counter : LiveData<Int>
            get() = _counter

    init {
        _counter.value = 0
    }

    fun onAdd(){
        _counter.value = _counter.value?.plus(1)
    }

    fun onClear(){
        _counter.value = 0
    }
}
