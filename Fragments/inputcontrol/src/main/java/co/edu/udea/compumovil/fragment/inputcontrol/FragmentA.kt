package co.edu.udea.compumovil.fragment.inputcontrol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class FragmentA : Fragment() {

    private lateinit var message: TextView
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            count = it.getInt(ARG_COUNT, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_clear).setOnClickListener { clear() }
        view.findViewById<Button>(R.id.btn_count).setOnClickListener { add() }

        message = view.findViewById(R.id.text_message)
        updateUI()

    }

    private fun add() {
        count++
        updateUI()
    }

    private fun clear() {
        count = 0
        updateUI()
    }

    private fun updateUI() {
        message.text = requireContext().getString(R.string.text_message, count)
    }

    companion object {
        const val ARG_COUNT = "count"

        fun newInstance(count: Int): FragmentA =
            FragmentA().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COUNT, count)
                }
            }
    }
}
