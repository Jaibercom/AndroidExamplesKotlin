package co.edu.udea.compumovil.viewmodel.ui.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.edu.udea.compumovil.viewmodel.R
import kotlinx.android.synthetic.main.counter_fragment.btnClear
import kotlinx.android.synthetic.main.counter_fragment.btnAdd
import kotlinx.android.synthetic.main.counter_fragment.textMessage

class CounterFragment : Fragment(), View.OnClickListener {

    private var count = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.counter_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnAdd.setOnClickListener(this)
        btnClear.setOnClickListener(this)

        updateUI()
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.btnAdd -> count++

            R.id.btnClear -> count = 0
        }
        updateUI()
    }

    private fun updateUI() {
        textMessage.text = activity!!.getString(R.string.text_message, count)
    }

    companion object {
        fun newInstance() = CounterFragment()
    }
}
