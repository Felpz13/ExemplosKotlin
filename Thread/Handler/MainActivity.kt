package com.example.claro.threads

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handlerExemplo = Handler()

        val auxRunnable = AuxRunnable()

        Thread(auxRunnable).start()

        handlerExemplo.post {
            kotlin.run {
                textExemplo.text = auxRunnable.resultadoThread()
            }
        }

    }
}
