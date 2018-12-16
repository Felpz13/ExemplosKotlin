package com.example.claro.carteiradigital.auxiliares

import java.text.SimpleDateFormat
import java.util.*

class DataConfig
{
    companion object
    {
        fun dataAtual() : String
        {
            val formatoData = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

            return formatoData.format(System.currentTimeMillis())
        }
    }
}