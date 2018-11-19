package com.example.claro.fragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener()
        {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameConteudo, UmFragment())
                .commit()
        }

        button2.setOnClickListener()
        {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameConteudo, DoisFragment())
                .commit()
        }
    }
}
