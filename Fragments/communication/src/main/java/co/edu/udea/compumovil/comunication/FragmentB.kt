package co.edu.udea.compumovil.comunication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "name"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentB : Fragment() {

    private lateinit var message: TextView
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        message = view.findViewById(R.id.text_message)

        return view
    }

    override fun onStart() {
        super.onStart()
        readBundle(arguments)
        updateDisplay()
    }

    private fun readBundle(bundle: Bundle?) {
        if (bundle != null) {
            name = bundle.getString("name")!!
        }
    }

    fun setName(name: String) {
        this.name = name
        updateDisplay()
    }

    private fun updateDisplay() {
        message.text = activity!!.getString(R.string.message_name, name)
    }

    companion object {

        const val FRAGMENT_B_TAG = "FragmentB"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param name Parameter 1.
         * @return A new instance of fragment FragmentB.
         */
        @JvmStatic
        fun newInstance(name: String) =
            FragmentB().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                }
            }
    }
}
