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

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this@MainActivity, item, Toast.LENGTH_SHORT).show()
    }

}