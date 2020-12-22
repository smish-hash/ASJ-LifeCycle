package com.example.asjlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var num = 0
    val TAG = "Activity"
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val btnPos = findViewById<Button>(R.id.btnPos)
        val btnNeg = findViewById<Button>(R.id.btnNeg)

        textView.text = num.toString()

        btnPos.setOnClickListener {
            num++
            textView.text = num.toString()
        }

        btnNeg.setOnClickListener {
            num--
            textView.text = num.toString()
        }

        Log.d(TAG, "onCreate: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("SavedNumber", num)
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val temp_num = savedInstanceState.getInt("SavedNumber")
        num = temp_num
        textView.text = temp_num.toString()

        Log.d(TAG, "onRestoreInstanceState: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId)  {
            R.id.action_fragment -> {
                Intent(this, FragmentActivity::class.java).also {
                    startActivity(it)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}