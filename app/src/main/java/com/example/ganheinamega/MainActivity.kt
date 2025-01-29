package com.example.ganheinamega

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText = findViewById<EditText>(R.id.edit_number)
        val txtResult = findViewById<TextView>(R.id.txt_result)
        val btnGenerated = findViewById<Button>(R.id.btn_generate)

        prefs = getSharedPreferences("db",Context.MODE_PRIVATE)
        val result = prefs.getString("result",null)

        result.let{
            txtResult.text = "Ultima aposta $it"
        }

        btnGenerated.setOnClickListener {

            numberGenerator(editText.text.toString(), txtResult)
        }

    }


    private fun numberGenerator(text: String, txtResult: TextView) {

        if (text.isEmpty()) {
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        val qtd = text.toInt()

        if (qtd < 6 || qtd > 15) {
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (true) {

            val number = 1 + random.nextInt(60)
            numbers.add(number)

            if (numbers.size == qtd) {
                break
            }
        }

        val numbersSort = numbers.sorted()

        txtResult.text = numbersSort.joinToString(" - ")

        val editor = prefs.edit()
        editor.putString("result",txtResult.text.toString())
        editor.apply()

    }


}