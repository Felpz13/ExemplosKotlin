package com.example.claro.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomes : ArrayList<String> = ArrayList()

        nomes.add("TESTE1")
        nomes.add("TESTE2")
        nomes.add("TESTE3")
        nomes.add("TESTE4")
        nomes.add("TESTE5")

        //adapter.notifyDataSetChanged()  **firebase atualizar adapter
        
        recyclerFilmes.layoutManager = LinearLayoutManager(this)
        recyclerFilmes.hasFixedSize()
        recyclerFilmes.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        recyclerFilmes.adapter = adapter(nomes)



    }
}
