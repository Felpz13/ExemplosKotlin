package com.example.claro.threads

import android.util.Log

class AuxRunnable : Runnable
{
    var texto : String = "ERRO!"

    override fun run()
    {
        texto = "Novo Texto"

        Log.d("TESTE", "NOVA THREAD - $texto")
    }

    fun resultadoThread() : String
    {
        return texto
    }

}