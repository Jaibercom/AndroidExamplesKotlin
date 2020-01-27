package co.edu.udea.compumovil.comunication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), FragmentA.OnFragmentButtonListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FragmentA.newInstance()

        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.add(R.id.fragment_container, fragmentA, FRAG_A_TAG)
        ft.commit()
    }

    override fun onFragmentClickButton(name: String?) {
        Log.d(TAG, "onClick, your name is: $name")
    }

    companion object {
        private const val TAG = "MainActivity"
        private const val FRAG_A_TAG = "FRAGMENT_A_TAG"
    }
}
