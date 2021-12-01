package com.juliasd.tinytravel

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment2(val listener: (day2:Int, month2:Int, year2:Int) -> Unit): DialogFragment(), DatePickerDialog.OnDateSetListener {


    override fun onDateSet(view: DatePicker?, year2: Int, month2: Int, dayOfMonth2: Int) {
        listener(dayOfMonth2, month2, year2)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c2 = Calendar.getInstance()
        val day2 = c2.get(Calendar.DAY_OF_MONTH)
        val month2 = c2.get(Calendar.MONTH)
        val year2 = c2.get(Calendar.YEAR)

        val picker2 = DatePickerDialog(activity as Context, this, year2, month2, day2)
        picker2.datePicker.minDate = c2.timeInMillis
        c2.add(Calendar.MONTH, +2)
        picker2.datePicker.maxDate = c2.timeInMillis
        return picker2

    }
}