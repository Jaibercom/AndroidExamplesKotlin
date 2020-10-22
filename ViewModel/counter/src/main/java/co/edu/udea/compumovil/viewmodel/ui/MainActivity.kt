package co.edu.udea.compumovil.viewmodel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.udea.compumovil.viewmodel.R
import co.edu.udea.compumovil.viewmodel.ui.counter.CounterFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
