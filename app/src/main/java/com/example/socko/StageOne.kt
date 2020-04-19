package com.example.socko

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_phase_one.*

class StageOne : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phase_one)

        textViewStatus.text = getMoney(this).toString()

        buttonLadenGeld.setOnClickListener {
            startActivity(Intent(this, CookieClicker::class.java))
        }

        buttonLadenShoppen.setOnClickListener {
            startActivity(Intent(this, Shop::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        textViewStatus.text = getMoney(this).toString()
    }
}