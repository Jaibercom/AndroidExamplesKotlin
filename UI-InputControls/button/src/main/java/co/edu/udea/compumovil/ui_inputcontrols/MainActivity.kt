package co.edu.udea.compumovil.ui_inputcontrols

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var message: TextView
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        message = findViewById(R.id.text_message)
        updateUI()
    }

    fun onClick(view: View) {

        when (view.id) {

            R.id.btn_count -> {
                count++
            }

            R.id.btn_clear -> {
                count = 0
            }
        }
        updateUI()
    }

    private fun updateUI() {
        message.text = this.getString(R.string.text_message, count)
    }
}
