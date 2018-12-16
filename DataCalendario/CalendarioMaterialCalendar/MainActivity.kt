package com.felipe.claro.calendario

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        //https://github.com/prolificinteractive/material-calendarview

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendarExemplo.state().edit()
            .setMinimumDate(CalendarDay.from(2018,1,1))
            .setMaximumDate(CalendarDay.from(2019,12,30))
            .commit()

        val mes = arrayOf("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro")
        calendarExemplo.setTitleMonths(mes)

        val diaListener = OnDateSelectedListener {
                materialCalendarView, calendarDay, b ->
            Log.i("TESTE", "valor: $calendarDay")
        }

        val mesListener = OnMonthChangedListener{
                materialCalendarView, calendarDay ->
            Log.i("TESTE", "valor: ${calendarDay.month + 1} / ${calendarDay.year}")
        }

        calendarExemplo.setOnDateChangedListener(diaListener)
        calendarExemplo.setOnMonthChangedListener(mesListener)
    }
}
