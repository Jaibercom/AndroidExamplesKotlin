package co.edu.udea.compumovil.viewmodel.ui.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.edu.udea.compumovil.viewmodel.R

class CounterFragment : Fragment() {

    private lateinit var counterViewModel: CounterViewModel
    private lateinit var addButton: Button
    private lateinit var clearButton: Button
    private lateinit var messageView: TextView
//    private val model: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.counter_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addButton = view.findViewById(R.id.add_button)
        clearButton = view.findViewById(R.id.clear_button)
        messageView = view.findViewById(R.id.message_view)

        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        setUpListeners()
        observeLiveData()
    }

    private fun setUpListeners() {
        addButton.setOnClickListener { onAdd() }
        clearButton.setOnClickListener { onClear() }
    }

    private fun observeLiveData() {
        counterViewModel.getCounter().observe(viewLifecycleOwner, { newCounter ->
            messageView.text = requireContext().getString(R.string.text_message, newCounter)
        })
    }

    private fun onAdd() {
        counterViewModel.onAdd()
    }

    private fun onClear() {
        counterViewModel.onClear()
    }
}
