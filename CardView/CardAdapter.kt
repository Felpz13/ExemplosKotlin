package com.example.claro.cardview




import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class CardAdapter : RecyclerView.Adapter<CardAdapter.ItemVisualizacao>() //passar lista de objetos pelo construtor.
{

    inner class ItemVisualizacao (itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var imagem : ImageView
        var titulo : TextView
        var postagem : TextView

        init
        {
            imagem = itemView.findViewById(R.id.imagemPostagem)
            titulo = itemView.findViewById(R.id.textNome)
            postagem = itemView.findViewById(R.id.textPostagem)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemVisualizacao
    {
        val viewCard = LayoutInflater.from(p0.context).inflate(R.layout.postagem_item, p0, false)

        return ItemVisualizacao(viewCard)
    }

    override fun onBindViewHolder(p0: ItemVisualizacao, p1: Int) //usar p1 como indice da lista.
    {
        p0.titulo.text = "TESTE"
        p0.postagem.text = "POST POST POST POST"
        p0.imagem.setImageResource(R.drawable.imagem1)
    }

    override fun getItemCount(): Int
    {
        return 4 //tamanho do arquivo a ser exibido.
    }
}