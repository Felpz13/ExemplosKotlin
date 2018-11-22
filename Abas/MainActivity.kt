package com.example.claro.abas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* https://github.com/ogaclejapan/SmartTabLayout (implementations):
            implementation 'com.ogaclejapan.smarttablayout:library:1.6.1@aar'
            implementation 'com.ogaclejapan.smarttablayout:utils-v4:1.6.1@aar'
        */

        supportActionBar!!.elevation = 0.0F
        supportActionBar!!.title = "Abas!!!"

        val adapter = FragmentPagerItemAdapter(supportFragmentManager, FragmentPagerItems.with(this)
            .add("Tab1", Tab1Fragment::class.java) //criar fragmentos para conteudo de cada aba
            .add("Tab2", Tab2Fragment::class.java)
            .create())

        viewPager.adapter = adapter
        viewPagerTab.setViewPager(viewPager)
    }
}
