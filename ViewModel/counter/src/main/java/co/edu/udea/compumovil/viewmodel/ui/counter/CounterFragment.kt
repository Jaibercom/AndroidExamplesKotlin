package co.edu.udea.compumovil.viewmodel.ui.counter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.edu.udea.compumovil.viewmodel.R
import co.edu.udea.compumovil.viewmodel.databinding.CounterFragmentBinding

class CounterFragment : Fragment() {

    private lateinit var binding: CounterFragmentBinding
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.counter_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "Called ViewModelProvider.get")
        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        setUpListeners()
        observeLiveData()
    }

    private fun setUpListeners() {
        binding.addButton.setOnClickListener { onAdd() }
        binding.clearButton.setOnClickListener { onClear() }
    }

    private fun observeLiveData() {
        counterViewModel.getCounter().observe(viewLifecycleOwner, { newCounter ->
            binding.messageView.text = requireContext().getString(R.string.text_message, newCounter)
        })
    }

    private fun onAdd() {
        counterViewModel.onAdd()
    }

    private fun onClear() {
        counterViewModel.onClear()
    }

    companion object {
        private const val TAG = "Counter Fragment"
    }
}
