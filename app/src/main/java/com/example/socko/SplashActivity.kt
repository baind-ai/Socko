package com.example.socko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val delay = 3000

        val state = getState(this)
        Handler().postDelayed({
            when (state){
                0 -> startActivity(Intent(this, StageOne::class.java))
                1 -> startActivity(Intent(this, StageTwo::class.java))
                2 -> startActivity(Intent(this, StageThree::class.java))
            }
        }, delay.toLong())
    }
}
