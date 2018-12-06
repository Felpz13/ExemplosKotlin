package com.example.claro.requisicoes

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val task = TaskExemplo()
        val urlApi = "https://viacep.com.br/ws/07032000/json/"

        task.execute(urlApi)

    }

    //<uses-permission android:name="android.permission.INTERNET"/>

    inner class TaskExemplo : AsyncTask<String, Void, String>()
    {
        override fun onPreExecute()
        {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String
        {
            val stringUrl = params[0]

            val urlExemplo = URL(stringUrl)

            val conexao = urlExemplo.openConnection() as HttpURLConnection

            val inputStreamExemplo = conexao.inputStream //recupera em bytes

            val inputStreamReaderExemplo = InputStreamReader(inputStreamExemplo)

            val reader = BufferedReader(inputStreamReaderExemplo)

            val buffer = StringBuffer()

            var linha : String?

            do
            {
                linha = reader.readLine()
                buffer.append(linha)

            }while (linha != null)

            return  buffer.toString()
        }

        override fun onPostExecute(result: String?)
        {
            super.onPostExecute(result)

            val jsonObjectExemplo = JSONObject(result)

            val rua = jsonObjectExemplo.getString("logradouro")

            textoResultado.text = rua
        }
    }
}
