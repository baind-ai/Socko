package com.example.socko

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.geld.*


class CookieClicker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.geld)

        textViewStatus.setText(getMoney(this).toString())

        buttonGeldPlus.setOnClickListener {
            setMoney(this, (textViewStatus.text.toString().toInt()+1))
            textViewStatus.setText(getMoney(this).toString())
            playSound()
        }
    }

    fun playSound(){
        val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.sound_click)
        mediaPlayer.start()
    }
}