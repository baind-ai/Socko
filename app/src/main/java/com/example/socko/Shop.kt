package com.example.socko

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.laden.*

class Shop : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.laden)

        val socken = listOf(
            Socke("Socko", 10, R.drawable.icon),
            Socke("Ringelsocko", 250, R.drawable.sock_0),
            Socke("Skisocko", 1000, R.drawable.sock_2),
            Socke("Delux Socko", 2500, R.drawable.sock_4)
        )

        val int_number = getMoney(this)
        textViewStatus.setText(int_number.toString())

        recylerViewLaden.apply {
            layoutManager = LinearLayoutManager(this@Shop)
            adapter = SockenAdapter(socken){
                if(int_number >= it){
                    setMoney(this@Shop, (int_number-it))
                    startActivity(Intent(this@Shop, StageTwo::class.java))
                }else{
                    Toast.makeText(this.context, "Nicht genug Geld", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}