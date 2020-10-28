package co.edu.udea.compumovil.room.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.udea.compumovil.room.R
import co.edu.udea.compumovil.room.db.WordRoomDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WordRoomDatabase.getDatabase(context = applicationContext)
    }
}