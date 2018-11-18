package com.example.claro.forms

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.RadioGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSwitch()

        btCheckBox()

        btRadio()

        btSeekBar()

        btProgressBar()

    }

    fun btSwitch()
    {
        modoNoturno.setOnClickListener()
        {
            if(modoNoturno.isChecked)
            {
                fundo.setBackgroundResource(R.color.preto)
                modoNoturno.setTextColor(ContextCompat.getColor(this, R.color.branco))
            }
            else
            {
                fundo.setBackgroundResource(R.color.branco)
                modoNoturno.setTextColor(ContextCompat.getColor(this, R.color.preto))
            }
        }
    }

    fun btCheckBox()
    {
        cbNegrito.setOnClickListener()
        {
            if (cbNegrito.isChecked) nomeRes.setTypeface(null, Typeface.BOLD)
            else nomeRes.setTypeface(null, Typeface.NORMAL)
        }

    }

    fun btRadio()
    {
        cor1.isChecked = true
        tela.setBackgroundResource(R.color.vermelho)

        cor.setOnCheckedChangeListener() { radioGroup: RadioGroup, i: Int ->
            when (cor.checkedRadioButtonId)
            {
                cor1.id -> tela.setBackgroundResource(R.color.vermelho)
                cor2.id -> tela.setBackgroundResource(R.color.azul)
                cor3.id -> tela.setBackgroundResource(R.color.amarelo)
            }

        }
    }

    fun btProgressBar()
    {
        var texto = nomeRes.text.toString()
        var progresso : Int =  texto.toInt()


        progressBar.progress = progresso * 10
    }

    fun btSeekBar()
    {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener
        {

            override fun onStartTrackingTouch(seekBar: SeekBar?)
            {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?)
            {

            }

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean)
            {

                nomeRes.text = i.toString()
            }
        })
    }
}