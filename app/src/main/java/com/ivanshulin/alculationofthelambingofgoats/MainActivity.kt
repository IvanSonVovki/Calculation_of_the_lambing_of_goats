package com.ivanshulin.alculationofthelambingofgoats

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getDatePicker: Button  =findViewById(R.id.confirm_select_date)
        getDatePicker.setOnClickListener{
            calculationDate()
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculationDate() {

        val dataPickerAction: DatePicker = findViewById(R.id.date_picker_actions)
        val outPutDate: TextView = findViewById(R.id.out_put_date)
        val year = dataPickerAction.year
        val month = dataPickerAction.month + 1
        val day = dataPickerAction.dayOfMonth
        val dateString = "$year-$month-$day"
        val dayOfLambing = LocalDate.of(year, month, day).plusDays(150L)
        outPutDate.text = dayOfLambing.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
    }
}
