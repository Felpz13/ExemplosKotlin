package com.felipe.claro.calendario

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CalendarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarListener = CalendarView.OnDateChangeListener{
                view, year, month, dayOfMonth ->
            Log.i("TESTE", "valor:" + dayOfMonth + "/" + month + "/" + year)
        }

        calendarExemplo.setOnDateChangeListener(calendarListener)
    }
}
