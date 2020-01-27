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
 * [FragmentA.OnFragmentButtonListener] interface
 * to handle interaction events.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment(), View.OnClickListener {

    private lateinit var sendButton: FloatingActionButton
    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        editText = view.findViewById(R.id.text_name)
        sendButton = view.findViewById(R.id.btn_floating)
        sendButton.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View?) {

        val name = editText.text.toString()
        Log.d(TAG, "onClick, your name is: $name")

    }

    companion object {

        private const val TAG = "FragmentA"

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
