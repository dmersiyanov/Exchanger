package com.dmersiyanov.exchanger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportActionBar) {
            val titleText: String = title.toString()
            title = Html.fromHtml("<font color='#000000'>" + titleText + "</font>")
        }

    }
}
