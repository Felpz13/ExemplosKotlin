package com.example.claro.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception


class DB (context: Context) : SQLiteOpenHelper(context, "dbExemplo", null, 3)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        val query = "CREATE TABLE IF NOT EXISTS tabelaExemplo(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(30), idade INTEGER(3))"

        try
        {
            db?.execSQL(query)
        }
        catch (e : Exception)
        {
            Log.i("TESTE", "Erro ao Criar Tabela" + e.message)
        }
    }

    fun inserirExemplo (nome : String, idade : Int)
    {
        val db : SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put("nome", nome)
        values.put("idade", idade)

        db.insert("tabelaExemplo", null, values) // nullCollumnHack -> define coluna a receber null caso n exista dados

        db.close()
    }

    fun modificarExemplo(id : Int, nome : String, idade: Int)
    {
        val db : SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put("nome", nome)
        values.put("idade", idade)

        db.update("tabelaExemplo", values, "id == $id", null)

        db.close()
    }

    fun deletarExemplo (id : Int)
    {
        val db : SQLiteDatabase = writableDatabase

        db.delete("tabelaExemplo", "id == $id", null)

        db.close()
    }

    fun listarExemplo() : ArrayList<ClasseExemplo>
    {
        val db : SQLiteDatabase = readableDatabase
        val lista : ArrayList<ClasseExemplo> = ArrayList()

        val query = "SELECT * FROM tabelaExemplo"
        val cursor = db.rawQuery(query,null)

        val indiceNome = cursor.getColumnIndex("nome")
        val indiceIdade = cursor.getColumnIndex("idade")
        val indiceId = cursor.getColumnIndex("id")

        if(cursor.moveToFirst())
        {
            do {
                val localExemplo = ClasseExemplo(
                    cursor.getInt(indiceId),
                    cursor.getString(indiceNome),
                    cursor.getInt(indiceIdade))

                lista.add(localExemplo)

            }while (cursor.moveToNext())
        }
        cursor.close()
        db.close()

        return lista
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        onCreate(db)
    }
}

data class ClasseExemplo (val id : Int, val nome: String, val idade: Int)


/*

    QUERYS:

    "SELECT nome, idade" + //SELECT * = todas colunas
    "FROM tabelaExemplo" +
    "WHERE nome = 'Heloisa' AND idade = 2"

    "SELECT nome, idade" +
    "FROM tabelaExemplo" +
    "WHERE idade >= 30 OR idade = 2"

    "SELECT nome, idade" +
    "FROM tabelaExemplo" +
    "WHERE idade IN ('Heloisa','Felipe')"

    "SELECT nome, idade" +
    "FROM tabelaExemplo" +
    "WHERE idade BETWEEN 2 AND 31"

    "SELECT nome, idade" +
    "FROM tabelaExemplo" +
    "WHERE nome LIKE '%Felipe%'" //qualquer nome que contem Felipe

    "SELECT nome, idade" +
    "FROM tabelaExemplo" +
    "WHERE idade >= 2 ORDER BY ASC" //ASC = crescente; DESC = decrescente


    SQL:

    bd.execSQL("DELETE FROM tabelaExemplo") //Exlui todas entradas
    bd.execSQL("DROP TABLE tabelaExemplo") //Exclui tabela
    bd.execSQL("ALTER TABE tabelaExemplo ADD COLUMN novaColuna VARCHAR(10)
 */
