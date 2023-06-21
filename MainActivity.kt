package com.example.mycagnotte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Passage à la page de transaction lorsque l'utilisateur clique sur le bouton
        val button = findViewById<Button>(R.id.open_button)
        //mettre des actions : comme changer le texte ou autres
        button.setOnClickListener {
            finish()
            startActivity(Intent(applicationContext, TransactionActivity::class.java))
        }

    }
}