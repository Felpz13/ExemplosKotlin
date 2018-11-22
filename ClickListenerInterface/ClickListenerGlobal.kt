package com.example.claro.abas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_click_listener_global.view.*

class ClickListenerGlobal : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_click_listener_global, container, false)

        view.button1.setOnClickListener(this)
        view.button2.setOnClickListener(this)
        view.button3.setOnClickListener(this)
        view.button4.setOnClickListener(this)
        view.button5.setOnClickListener(this)
        view.button6.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {

        when (v!!.id)
        {
            R.id.button1 -> {
                Log.d("NUMERO", "UM")
            }
            R.id.button2 -> Log.d("NUMERO", "DOIS")
            R.id.button3 -> Log.d("NUMERO", "TRES")
            R.id.button4 -> Log.d("NUMERO", "QUATRO")
            R.id.button5 -> Log.d("NUMERO", "CINCO")
            R.id.button6 -> Log.d("NUMERO", "SEIS")
        }

    }


}
