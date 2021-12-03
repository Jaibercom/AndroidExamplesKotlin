package co.edu.udea.compumovil.listdetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.udea.compumovil.listdetail.model.Contact
import java.util.ArrayList

class ContactViewModel : ViewModel() {

    private var contactList: MutableLiveData<List<Contact>> = MutableLiveData()

    private val itemSelected = MutableLiveData<Contact>()

    fun getContactList(): LiveData<List<Contact>> = contactList

    init {
        contactList.value = createMockContacts()
    }

    fun getNameSelected(): LiveData<String> {
        val contact = itemSelected.value

        val name = MutableLiveData("")
        name.value = "Su nombre es: \n${contact?.firstName} ${contact?.lastName}"
        return name
    }

    fun select(contact: Contact) {
        itemSelected.value = contact
    }

    private fun createMockContacts(): ArrayList<Contact> {
        return arrayListOf(
            Contact("Jose", "Perez", "jose@gmail.com"),
            Contact("Natalia", "Perez", "nata@gmail.com"),
            Contact("Pepito", "Perez", "pepito@gmail.com"),
            Contact("Juan", "Perez", "juan@gmail.com")
        )
    }
}
