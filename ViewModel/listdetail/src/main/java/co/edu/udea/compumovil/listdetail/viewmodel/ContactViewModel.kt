package co.edu.udea.compumovil.listdetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.udea.compumovil.listdetail.model.Contact

class ContactViewModel : ViewModel() {

    private val selected = MutableLiveData<Contact>()

    fun getSelected() : LiveData<Contact> = selected

    fun select(contact: Contact) {
        selected.value = contact
    }
}