package co.edu.udea.compumovil.fragment.inputcontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchFragment()
    }

    private fun launchFragment() {
        // Create new fragment and transaction
        val fragmentA = FragmentA.newInstance(45)
        val transaction = supportFragmentManager.beginTransaction()

        transaction.apply {
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            replace(R.id.fragment_container, fragmentA, TAG)
            // Commit the transaction
            commit()
        }

        // Getting fragment dynamically
//         val fragment = supportFragmentManager.findFragmentByTag(TAG)
    }

    companion object {
        const val TAG = "TAG_FRAGMENT_A"
    }
}
