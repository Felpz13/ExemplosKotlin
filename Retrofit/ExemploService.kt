package com.example.claro.requisicoes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ExemploService
{
    @GET("{variavelNoEndereco}/json/") //continuacao do endereco base

    fun metodoExemplo(@Path("variavelNoEndereco") variavelNoEndereco : String) : Call<ModelExemplo>  //retorna Call - retrofit2

    fun listaExemplo() : Call<List<ModelExemplo>>
}