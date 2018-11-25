package com.example.claro.menu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu_exemplo, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean
    {
        when(item!!.itemId)
        {
            R.id.itemExemplo1 ->
            {
                Log.d("TESTE", "BOTAO UM")
            }

            R.id.itemExemplo2 ->
            {
                Log.d("TESTE", "BOTAO DOIS")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
