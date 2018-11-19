package com.example.claro.snackbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener()
        {
            Snackbar.make(it , "TESTE!!!", Snackbar.LENGTH_LONG)
                .setAction("CONFIRMAR!")
                {
                    textResultado.text = "Confirmado!"
                }
                .show()
        }
    }
}

//implementation 'com.android.support:design:XX.XX.XX'
