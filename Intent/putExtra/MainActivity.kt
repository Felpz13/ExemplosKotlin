package com.example.claro.putextra

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enviar.setOnClickListener()
        {
            val usuario = Usuario("Felipe", 30) //classe precisa implementar : Serializable
            val nome = nomeEntrada.text
            val idade = idadeEntrada.text
            val intent = Intent(applicationContext, SecondActivity::class.java)

            intent.putExtra("nome", nome)
            intent.putExtra("idade", idade)
            intent.putExtra("usuario", usuario)

            startActivity(intent)
        }
    }
}

class Usuario(val nome : String, val idade : Int) : Serializable