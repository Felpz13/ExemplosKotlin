package com.example.claro.preferencias

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val save = SavePreferences(this)

        buttonSave.setOnClickListener()
        {
            save.salvar(textEntrada.text.toString())
        }

        textExemplo.text = save.carregar()


    }
}
