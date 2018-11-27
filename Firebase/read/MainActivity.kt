package com.example.claro.iflix.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.claro.iflix.model.Series
import com.example.claro.iflix.R
import com.example.claro.iflix.adapter.SeriesAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{
    val dir = FirebaseDatabase.getInstance().getReference().child("/series")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaSeries : MutableList<Series> = mutableListOf()

        dir.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(p0: DataSnapshot)
            {
                if (p0.exists())
                {
                    for(i in 0 .. p0.childrenCount - 1)
                    {

                        val serieLocal = Series(
                            p0.child("$i").child("CENSURA").value.toString(),
                            p0.child("$i").child("CODIGO").value.toString(),
                            p0.child("$i").child("DESCRICAO").value.toString(),
                            p0.child("$i").child("FOTO").value.toString(),
                            p0.child("$i").child("GENERO").value.toString(),
                            p0.child("$i").child("NOME").value.toString(),
                            p0.child("$i").child("TEMPORADAS").value.toString(),
                            p0.child("$i").child("TRAILER").value.toString()
                        )


                        listaSeries.add(serieLocal)
                    }
                }
            }

            override fun onCancelled(p0: DatabaseError)
            {
                Log.e("TESTE", "erro!!!")
            }
        })

        RecyclerSeries.layoutManager = LinearLayoutManager(this)
        RecyclerSeries.adapter = SeriesAdapter(listaSeries,applicationContext)
    }
}
