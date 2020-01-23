package co.edu.udea.compumovil.fragment.inputcontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create new fragment and transaction
        val fragmentA = FragmentA()
        val transaction = supportFragmentManager.beginTransaction()

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.add(R.id.fragment_container, fragmentA)
        // Commit the transaction
        transaction.commit()
    }
}
