package com.example.asjlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        setFragment(firstFragment)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)

        btn1.setOnClickListener {
            setFragment(firstFragment)
        }

        btn2.setOnClickListener {
            setFragment(secondFragment)
        }
    }

    private fun setFragment(fragment: Fragment) = supportFragmentManager
        .beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
}