package com.example.claro.putextra

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val dados : Bundle = intent.extras!!
        val nome = dados["nome"]!!.toString()
        val idade = dados["idade"]!!.toString()
        val usuario = dados["usuario"] as Usuario

        Log.d ("HEAL", "Recebeu")

        if(nome.isEmpty() || idade.isEmpty())
        {
            nomeResultado.text = usuario.nome
            idadeResultado.text = usuario.idade.toString()
        }

        else
        {
            nomeResultado.text = nome
            idadeResultado.text = idade
        }


    }
}
