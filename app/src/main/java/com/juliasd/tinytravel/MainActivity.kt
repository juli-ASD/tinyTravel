package com.juliasd.tinytravel

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import com.juliasd.tinytravel.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val departamentos = resources.getStringArray(R.array.Departamentos)
        val adapter = ArrayAdapter(
            this,
            R.layout.list_item,
            departamentos
        )

        with(binding.autoCompleteTextView) {
            setAdapter(adapter)
            onItemClickListener = this@MainActivity
        }

        binding.etDate.setOnClickListener{ showDatePickerDialog() }
        binding.edDate2.setOnClickListener{ showDatePickerDialog2() }
    }

    private fun showDatePickerDialog() {

        val datePicker = DatePickerFragment{day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun showDatePickerDialog2() {

        val datePicker2 = DatePickerFragment2{day, month, year -> onDateSelected2(day, month, year)}
        datePicker2.show(supportFragmentManager, "datePicker2")
    }

    fun onDateSelected(day:Int, month:Int, year: Int) {

        binding.etDate.setText("Ingresas a tu Tiny House el día $day / $month / $year")
    }

    fun onDateSelected2(day2:Int, month2:Int, year2: Int) {
        binding.edDate2.setText("Entregas tu Tiny House el día $day2 / $month2 / $year2")
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this@MainActivity, item, Toast.LENGTH_SHORT).show()
    }

}