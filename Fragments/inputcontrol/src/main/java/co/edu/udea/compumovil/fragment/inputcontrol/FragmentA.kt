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
class FragmentA : Fragment(), View.OnClickListener {

    private lateinit var message: TextView
    private lateinit var btnCount: Button
    private lateinit var btnClear: Button
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        btnClear = view.findViewById(R.id.btn_clear)
        btnCount = view.findViewById(R.id.btn_count)
        btnClear.setOnClickListener(this)
        btnCount.setOnClickListener(this)

        message = view.findViewById(R.id.text_message)
        updateUI()

        return view
    }

    override fun onClick(view: View) {

        when (view.id) {

            R.id.btn_count -> {
                count++
            }

            R.id.btn_clear -> {
                count = 0
            }
        }
        updateUI()
    }

    private fun updateUI() {
        message.text = activity!!.getString(R.string.text_message, count)
    }
}
