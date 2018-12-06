package com.example.claro.slider

import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide

class MainActivity : IntroActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //https://github.com/heinrichreimer/material-intro

        setButtonBackVisible(false)
        setButtonNextVisible(false)

        //slide simples
        addSlide(SimpleSlide.Builder()
            .title("TituloExemplo")
            .description("DescriçãoExemplo")
            .image(R.drawable.abc_ab_share_pack_mtrl_alpha)
            .background(android.R.color.black)
            .build())

        //slide fragment
        addSlide(FragmentSlide.Builder()
            .background(android.R.color.white)
            .fragment(R.layout.activity_main)
            .build())
    }
}
