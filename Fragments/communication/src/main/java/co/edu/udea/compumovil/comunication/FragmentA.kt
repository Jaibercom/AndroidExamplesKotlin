package co.edu.udea.compumovil.comunication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentA.OnFragmentAButtonListener] interface
 * to handle interaction events.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment() {

    private var listener: OnFragmentAButtonListener? = null
    private lateinit var editText: EditText

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentAButtonListener {
        fun onClickButton(name: String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        editText = view.findViewById(R.id.text_name)
        val sendButton = view.findViewById<FloatingActionButton>(R.id.btn_floating)
        sendButton.setOnClickListener { onClick() }

        return view
    }

    private fun onClick() {
        val name = editText.text.toString()
        Log.d(TAG, "onClick, your name is: $name")

        listener?.let {
            it.onClickButton(name)
            editText.setText("")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentAButtonListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {

        private const val TAG = "FragmentA"
        const val FRAGMENT_A_TAG = "FragmentA_TAG"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment FragmentA.
         */
        @JvmStatic
        fun newInstance() = FragmentA()
    }
}
