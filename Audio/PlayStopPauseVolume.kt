package com.example.claro.curriculo.fragment

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.claro.curriculo.R


class HomeFragment : Fragment()
{
    private var audio : MediaPlayer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val fgView = inflater.inflate(R.layout.fragment_home, container, false)

        audio = MediaPlayer.create(context, R.raw.bach)

        audio!!.start()

        if (audio!!.isPlaying)
        {
            audio!!.pause()
            audio!!.stop() //destroi a referencia do val audio
            //onCompletion audio!!.release()
        }

        val audioManager : AudioManager = context!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager//getSystemService(Context.AUDIO_SERVICE) as AudioManager

        val volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC) //recuperar volume maximo do sistema

        var volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC) //recuperar volume atual do sistema

        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volumeAtual, 0) // int "volume" define novo valor. obs: Parametro flag-> AudioManager.FLAG

        return fgView
    }

    override fun onDestroy()
    {
        super.onDestroy()

        if(audio != null || audio!!.isPlaying)
        {
            audio!!.stop()
            audio!!.release()
            audio = null
        }
    }


}
