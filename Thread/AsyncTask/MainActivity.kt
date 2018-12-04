package com.example.claro.threads

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val task = AuxAsyncTask()

        task.execute(10)
    }

    inner class AuxAsyncTask : AsyncTask<Int, Int, String>() {

        override fun doInBackground(vararg params: Int?): String {

            val numero = params[0] as Int

            for (i in 0..numero) {
                Thread.sleep(1000)
                publishProgress(i)
            }

            return "Concluido";
        }

        override fun onPreExecute() {
            super.onPreExecute()

            progressBar.visibility = View.VISIBLE
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            progressBar.progress = values[0] as Int
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            progressBar.visibility = View.GONE
            progressBar.progress = 0
            textExemplo.text = result
        }
    }
}
