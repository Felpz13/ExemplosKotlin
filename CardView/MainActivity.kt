package com.example.claro.cardview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewEx.layoutManager = LinearLayoutManager(this) //Horizontal altera modo de exebição, Gridlayout mostrar em colunas
        recyclerViewEx.adapter = CardAdapter()

    }
}
