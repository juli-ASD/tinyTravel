package com.juliasd.tinytravel

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.juliasd.tinytravel.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    var tinyHouses = listOf<TinyHouse>(
            TinyHouse("https://picsum.photos/150/150", "Tiny_Mountain", "Consaca - Nariño", "Vista de un hermoso cañon", "$40 USD", "$250 USD"),
            TinyHouse("https://picsum.photos/150/150", "Tiny_Lake", "La Cocha - Nariño", "Vista espectacular a la Laguna", "$60 USD", "$380 USD"),
            TinyHouse("https://picsum.photos/150/150", "Tiny_Beach", "Manta - Ecuador", "Vista a un cristalino y maravilloso Mar", "$75 USD", "$550 USD")
    )

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
        initRecycler()

        binding.buttonBuscar.setOnClickListener() {
            startActivity(Intent(this, googlemaps::class.java))
        }

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

    fun initRecycler() {

        binding.rvTinyHouse.layoutManager = LinearLayoutManager(this)
        val adapter = TinyAdapter(tinyHouses)
        binding.rvTinyHouse.adapter = adapter
    }

}