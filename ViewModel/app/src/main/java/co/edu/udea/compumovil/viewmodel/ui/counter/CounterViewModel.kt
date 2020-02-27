package co.edu.udea.compumovil.viewmodel.ui.counter

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var counter = 0

    fun onAdd(){
        counter++
    }

    fun onClear(){
        counter = 0
    }
}
