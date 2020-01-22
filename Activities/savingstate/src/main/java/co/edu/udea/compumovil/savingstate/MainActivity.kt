package co.edu.udea.compumovil.savingstate

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //variables for each of the TextViews
    private lateinit var mTvCreate: TextView
    private lateinit var mTvRestart: TextView
    private lateinit var mTvStart: TextView
    private lateinit var mTvResume: TextView

    //Counters variables
    private var cntOnCreate = 0
    private var cntOnRestart = 0
    private var cntOnStart = 0
    private var cntOnResume = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Assign the appropriate TextViews to the TextView variables
        mTvCreate = findViewById(R.id.text_create)
        mTvRestart = findViewById(R.id.text_restart)
        mTvStart = findViewById(R.id.text_start)
        mTvResume = findViewById(R.id.text_resume)

        // Has previous state been saved?
        if (savedInstanceState != null) {
            Log.d(TAG, "in onCreate - Restoring from save bundle")
            loadState(savedInstanceState)
        }
        cntOnCreate++
        updateUI()
        Log.d(TAG, "onCreate: $cntOnCreate")
    }

    override fun onStart() {
        super.onStart()
        // Emit LogCat message
        cntOnStart++
        updateUI()
        Log.d(TAG, "onStart: $cntOnStart")
    }

    override fun onRestart() {
        super.onRestart()
        cntOnRestart++
        updateUI()
        Log.d(TAG, "onRestart: $cntOnRestart")
    }

    override fun onResume() {
        super.onResume()
        cntOnResume++
        updateUI()
        Log.d(TAG, "onResume: $cntOnResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onPause")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) { // Saving counter state information with a collection of key-value pairs
        Log.d(TAG, "onSaveInstanceState")

        saveState(savedInstanceState)

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState)
    }

    private fun loadState(savedInstanceState: Bundle) {
        // Restore value of counters from saved state
        cntOnCreate = savedInstanceState.getInt(CREATE_KEY)
        cntOnRestart = savedInstanceState.getInt(RESTART_KEY)
        cntOnResume = savedInstanceState.getInt(RESUME_KEY)
        cntOnStart = savedInstanceState.getInt(START_KEY)
    }

    private fun saveState(savedInstanceState: Bundle) {
        // Save value of counters in saved state
        savedInstanceState.putInt(CREATE_KEY, cntOnCreate)
        savedInstanceState.putInt(RESUME_KEY, cntOnResume)
        savedInstanceState.putInt(RESTART_KEY, cntOnRestart)
        savedInstanceState.putInt(START_KEY, cntOnStart)
    }

    private fun updateUI() {
        mTvCreate.text = getString(R.string.message, "onCreate()", cntOnCreate) //"onCreate() calls: $cntOnCreate"
        mTvStart.text = getString(R.string.message, "onStart()", cntOnStart) //"onStart() calls: $cntOnStart"
        mTvResume.text = "onResume() calls: $cntOnResume"
        mTvRestart.text = "onRestart() calls: $cntOnRestart"
    }

    companion object {
        //// Use these as keys when you're saving state between reconfigurations
        private const val RESTART_KEY = "restart"
        private const val RESUME_KEY = "resume"
        private const val START_KEY = "start"
        private const val CREATE_KEY = "create"

        //String for LogCat
        private const val TAG = "LifeCycle"
    }
}
