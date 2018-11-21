package com.example.claro.video

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video_view.*


class VideoViewActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        //no manifest: android:screenOrientation="landscape"  <uses-permission android:name="android.permission.INTERNET" />

        supportActionBar!!.hide() //esconde action bar

        val uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN // |View.SYSTEM... (adcionar mais opcoes)

        val decorView = window.decorView
        decorView.systemUiVisibility = uiOpcoes

        val uriPath = "endereço do video" //https://you-link.herokuapp.com/?url=https://www.youtube.com/watch?v=3V_dvSziCV8 para pegar url de youtube
        val uri : Uri =  Uri.parse(uriPath)
        videoView.setMediaController(MediaController(this))
        videoView.setVideoURI(uri) //setVideoPath("android.resource://"nomeArquivo)
        videoView.start()
    }
}
