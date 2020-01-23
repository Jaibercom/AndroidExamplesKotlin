package co.edu.udea.compumovil.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")
    }

    public override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    public override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    public override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    public override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    public override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
