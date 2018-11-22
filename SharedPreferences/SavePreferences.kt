package com.example.claro.preferencias

import android.content.Context

class SavePreferences (val context: Context)
{

    private val ARQUIVO_PREFERENCIA = "ArquivoPreferencia"
    private val CHAVE_NOME = "nome"

    val preferences = context.getSharedPreferences(ARQUIVO_PREFERENCIA, 0) //mode 0 = só para o uso do proprio app

    val editor = preferences.edit()

    fun salvar(string: String)
    {
        val editor = preferences.edit()
        editor.putString(CHAVE_NOME, string)
        editor.apply()
    }

    fun carregar() : String
    {
        if(preferences.contains("nome"))
        {
            return preferences.getString("nome", "SEM NOME") as String
        }

        return "Não foi possivel carregar dados"
    }
}