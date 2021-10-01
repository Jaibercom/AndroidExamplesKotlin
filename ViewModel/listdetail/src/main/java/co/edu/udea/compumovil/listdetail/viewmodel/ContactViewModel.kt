package co.edu.udea.compumovil.listdetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.udea.compumovil.listdetail.model.Contact

class ContactViewModel : ViewModel() {
    val selected = MutableLiveData<Contact>()

    fun select(contact: Contact) {
        selected.value = contact
    }
}