package co.edu.udea.compumovil.comunication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import co.edu.udea.compumovil.comunication.FragmentA.OnFragmentButtonListener
import co.edu.udea.compumovil.comunication.FragmentB.Companion.FRAGMENT_B_TAG



class MainActivity : AppCompatActivity(), OnFragmentButtonListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FragmentA.newInstance()

        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.add(R.id.fragment_container, fragmentA, FRAG_A_TAG)
        ft.commit()
    }

    override fun onFragmentClickButton(name: String) {
        Log.d(TAG, "onClick, your name is: $name")

        var fragmentB = supportFragmentManager.findFragmentByTag(FRAGMENT_B_TAG) as FragmentB?

        if (fragmentB != null) {
            fragmentB.setName(name)
        } else {
            Log.d(TAG, "Crear Fragment B")
            fragmentB = FragmentB.newInstance2(name)
        }

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, fragmentB, FRAGMENT_B_TAG)
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun createFragmentB(name: String): FragmentB {
        val bundle = Bundle()
        bundle.putString("ARG_NAME", name)
        bundle.putInt("ARG_AGE", 33)

        val fragment = FragmentB()
        fragment.arguments = bundle

        return fragment
    }

    companion object {
        private const val TAG = "MainActivity"
        private const val FRAG_A_TAG = "FRAGMENT_A_TAG"
    }
}
