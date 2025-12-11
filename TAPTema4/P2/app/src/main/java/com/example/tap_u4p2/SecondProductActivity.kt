package com.example.tap_u4p2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class SecondProductActivity : AppCompatActivity() {

    private lateinit var spinnerCantidad : Spinner
    private lateinit var btnComprar : Button
    private lateinit var btnOmitir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinnerCantidad = findViewById(R.id.spinnerCantidadProd2)
        btnComprar = findViewById(R.id.btnComprarProd2)
        btnOmitir = findViewById(R.id.btnOmitirProd2)

        val producto1 = intent.getStringExtra("producto")
        val precio1 = intent.getDoubleExtra("precio", 0.0)
        val cantidad1 = intent.getIntExtra("cantidad", 0)

        println("Producto 1: $producto1, Precio 1: $precio1, Cantidad 1: $cantidad1")


        val intent = Intent(this, ThirdProductActivity::class.java)


        btnComprar.setOnClickListener {
            val cantidad = spinnerCantidad.selectedItem.toString().toInt()

            intent.putExtra("producto1", producto1 )
            intent.putExtra("precio1", precio1 )
            intent.putExtra("cantidad1", cantidad1 )

            intent.putExtra("producto", "Bolsa de Piel")
            intent.putExtra("precio", 900.5)
            intent.putExtra("cantidad", cantidad)

            startActivity(intent)
            finish()
        }

        btnOmitir.setOnClickListener {
            intent.putExtra("producto1", producto1 )
            intent.putExtra("precio1", precio1 )
            intent.putExtra("cantidad1", cantidad1 )

            intent.putExtra("producto", "Bolsa de Piel")
            intent.putExtra("precio", 900.5)
            intent.putExtra("cantidad", 0)


            startActivity(intent)
            finish()

        }

    }
}