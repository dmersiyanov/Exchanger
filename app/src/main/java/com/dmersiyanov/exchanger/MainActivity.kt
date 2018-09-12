package com.dmersiyanov.exchanger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.widget.AutoCompleteTextView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportActionBar) {
            val titleText: String = title.toString()
            title = Html.fromHtml("<font color='#000000'>" + titleText + "</font>")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES)
        convert_from.setAdapter(adapter)



    }


    private val COUNTRIES = arrayOf("Belgium", "France", "Italy", "Germany", "Spain")
}
