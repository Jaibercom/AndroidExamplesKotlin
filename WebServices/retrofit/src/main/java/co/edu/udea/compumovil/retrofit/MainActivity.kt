package co.edu.udea.compumovil.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.udea.compumovil.retrofit.ui.post.PostFragment

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
