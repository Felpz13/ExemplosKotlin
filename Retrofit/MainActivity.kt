package com.example.claro.requisicoes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity()
{
    //<uses-permission android:name="android.permission.INTERNET"/>
    //implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    //implementation 'com.squareup.retrofit2:converter-gson:2.5.0'

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                        .baseUrl("https://viacep.com.br/ws/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

        val exemploService = retrofit.create(ExemploService::class.java)
        val callExemplo = exemploService.metodoExemplo("07032000")

        callExemplo.enqueue(object : Callback<ModelExemplo>
        {
            override fun onFailure(call: Call<ModelExemplo>, t: Throwable)
            {
                textoResultado.text = "ERRO EXEMPLO"
            }

            override fun onResponse(call: Call<ModelExemplo>, response: Response<ModelExemplo>)
            {
                if(response.isSuccessful)
                {
                    val respostaExemplo = response.body()

                    textoResultado.text = respostaExemplo!!.logradouro + " " + respostaExemplo.cep
                }
            }
        })
    }
}
