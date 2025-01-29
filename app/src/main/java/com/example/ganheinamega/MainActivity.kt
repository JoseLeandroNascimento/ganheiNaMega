package com.example.ganheinamega

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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

        btnGenerated.setOnClickListener{
            Log.i("Teste","Botão clicado!!!(3)")
        }

    }

    val buttonClickListener = object : View.OnClickListener{
        override fun onClick(v: View?) {
            Log.i("Teste","Botão clicado!!! (2)")
        }
    }

    fun generatedClicked(view:View){
        Log.i("Teste","Botão clicado!!! (1)")
    }
}