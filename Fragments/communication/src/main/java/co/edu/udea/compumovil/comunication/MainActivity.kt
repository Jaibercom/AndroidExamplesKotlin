package co.edu.udea.compumovil.comunication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import co.edu.udea.compumovil.comunication.FragmentA.Companion.FRAGMENT_A_TAG
import co.edu.udea.compumovil.comunication.FragmentA.OnFragmentAButtonListener
import co.edu.udea.compumovil.comunication.FragmentB.Companion.FRAGMENT_B_TAG


/**
 * A simple [Activity] subclass.
 *
 * author: Jaiber Yepes
 */
class MainActivity : AppCompatActivity(), OnFragmentAButtonListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FragmentA.newInstance()

        navigateTo(fragmentA, FRAGMENT_A_TAG)
    }

    override fun onClickListener(name: String) {
        Log.d(TAG, "onClick, your name is: $name")

        var fragmentB = supportFragmentManager.findFragmentByTag(FRAGMENT_B_TAG) as FragmentB?

        if (fragmentB != null) {
            Log.d(TAG, "Fragment B creado")
            fragmentB.setName(name)
        } else {
            Log.d(TAG, "Crear Fragment B")
            fragmentB = FragmentB.newInstance(name)
        }

        navigateTo(fragmentB, FRAGMENT_B_TAG, true)
    }

    private fun navigateTo(fragment: Fragment, tag: String, backStack: Boolean = false) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        ft.apply {
            replace(R.id.fragment_container, fragment, tag)
            if (backStack) {
                addToBackStack(null)
            }
            commit()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
