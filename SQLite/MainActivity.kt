package com.example.claro.sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DB(applicationContext)

        val lista : ArrayList<ClasseExemplo> = db.listarExemplo()

        val novoExemplo : ClasseExemplo = lista[0]

        //db.inserirExemplo("Mayra", 30)

        //db.modificarExemplo(novoExemplo.id, "novoNome", 0)

        //db.deletarExemplo(3)

        Log.d("TESTE", db.listarExemplo().toString())

    }
}
