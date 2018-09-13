package com.dmersiyanov.exchanger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.widget.ArrayAdapter
import android.widget.Toast
import com.dmersiyanov.exchanger.Models.Results
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Field


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportActionBar) {
            val titleText: String = title.toString()
            title = Html.fromHtml("<font color='#000000'>" + titleText + "</font>")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, getAllCurrencies(Results().javaClass))
        convert_from.setAdapter(adapter)

        val converterRepo = ConverterRepo()

        converterRepo.getRate("USD_PHP")
                .subscribe({

                    Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()

                }, {

                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
                })




    }

    private fun getAllCurrencies(aClass: Class<*>): List<String> {
        val fields = mutableListOf<Field>()
            fields.addAll(aClass.declaredFields)
        val currencies = mutableListOf<String>()

        for (item in fields) {
            currencies.add(item.type.simpleName)
        }

        return currencies
    }
}
