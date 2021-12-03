package co.edu.udea.compumovil.listdetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.edu.udea.compumovil.listdetail.R
import co.edu.udea.compumovil.listdetail.viewmodel.ContactViewModel

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    private lateinit var model: ContactViewModel
    private lateinit var nameView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameView = view.findViewById(R.id.name_text)
        model = ViewModelProvider(requireActivity()).get(ContactViewModel::class.java)
        observeLiveData()
    }

    private fun observeLiveData() {
        model.getNameSelected().observe(viewLifecycleOwner, { fullName ->
            nameView.text = fullName
        })
    }
}
