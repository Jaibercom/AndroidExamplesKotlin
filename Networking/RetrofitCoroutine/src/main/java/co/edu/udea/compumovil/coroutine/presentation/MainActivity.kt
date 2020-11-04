package co.edu.udea.compumovil.coroutine.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.udea.compumovil.coroutine.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PostFragment.newInstance())
                .commitNow()
        }
    }
}
