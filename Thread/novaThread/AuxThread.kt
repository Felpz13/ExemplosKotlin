package com.example.claro.threads

import android.util.Log

class AuxRunnable : Runnable
{
    override fun run()
    {
        Log.d("TESTE", "NOVA THREAD")
    }
}