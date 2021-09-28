package co.edu.udea.compumovil.viewmodel.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import co.edu.udea.compumovil.viewmodel.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Log.d(TAG, "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object{
        private const val TAG = "Counter Activity"
    }
}
