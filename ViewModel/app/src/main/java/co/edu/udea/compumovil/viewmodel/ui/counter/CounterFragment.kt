package co.edu.udea.compumovil.viewmodel.ui.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.edu.udea.compumovil.viewmodel.R
import kotlinx.android.synthetic.main.counter_fragment.btnClear
import kotlinx.android.synthetic.main.counter_fragment.btnAdd
import kotlinx.android.synthetic.main.counter_fragment.textMessage

class CounterFragment : Fragment(), View.OnClickListener {

    lateinit var counterViewModel: CounterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.counter_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        btnAdd.setOnClickListener(this)
        btnClear.setOnClickListener(this)

        counterViewModel.counter.observe(viewLifecycleOwner, Observer { newCounter ->
            textMessage.text = activity!!.getString(R.string.text_message, newCounter)
        })
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.btnAdd -> counterViewModel.onAdd()

            R.id.btnClear -> {
                counterViewModel.onClear()
//                counterViewModel.counter.value = 3
            }
        }
    }

    companion object {
        fun newInstance() = CounterFragment()
    }
}
