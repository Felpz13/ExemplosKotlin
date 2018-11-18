package com.example.claro.recyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter_lista.view.*

class adapter (val items : ArrayList<String>) : RecyclerView.Adapter<ViewHolder>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder
    {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.adapter_lista, p0, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int
    {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int)
    {
        val varLocal = items[p1]
        p0.titulo.text = varLocal

        p0.itemView.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?)
            {
                Log.d("Holder", "Click - $varLocal")
            }
        })

        p0.itemView.setOnLongClickListener(object : View.OnLongClickListener{

            override fun onLongClick(v: View?): Boolean
            {
                Log.d("Holder", "Long Click - $varLocal")

                return true
            }
        })
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view)
{
    val titulo = itemView.textTitulo
}