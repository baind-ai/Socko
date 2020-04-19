package com.example.socko

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.socko_tag.*

class StageThree : AppCompatActivity() {
    private val state = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.socko_tag)

        imageView3.setOnClickListener{
            deathSocko()
        }

        videoView.setOnClickListener{
            finish()
            setState(this, state)
            startActivity(Intent(this, StageOne::class.java))
            videoView.visibility = VideoView.INVISIBLE
        }
    }

    override fun onBackPressed() {}

    override fun onStart() {
        when(getImage()) {
            1 -> {
                imageView3.setImageResource(R.drawable.char_0)
                textViewStageThree.text = "Socko ist auf dem Weg zur Arbeit"
            }
            2 ->{
                imageView3.setImageResource(R.drawable.char_1)
                textViewStageThree.text = "Socko ist beim Sightseeing"
            }
            3 -> {
                imageView3.setImageResource(R.drawable.char_2)
                textViewStageThree.text = "Socko ist im Garten"
            }
            4 -> {
                imageView3.setImageResource(R.drawable.char_3)
                textViewStageThree.text = "Socko ist beim Sport"
            }
            5 -> {
                imageView3.setImageResource(R.drawable.char_4)
                textViewStageThree.text = "Socko spielt Indiana Jones"
            }
        }
        super.onStart()
    }

    private fun getImage(): Int{
       return (1..5).shuffled().first()
    }

    fun deathSocko(){
        videoView.visibility = VideoView.VISIBLE
        videoView.setMediaController(MediaController(this))
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName +"/" + R.raw.sockos_tod))
        videoView.requestFocus()
        videoView.start()
    }
}