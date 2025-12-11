package com.example.tap_u4p2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    /** <h1>Activity principal de la aplicación</h1>
     *
     * Esta activity es la principal de la aplicación y muestra los productos disponibles para comprar.
     */

    private lateinit var spinnerCantidad : Spinner
    private lateinit var btnComprar : Button
    private lateinit var btnOmitir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinnerCantidad = findViewById(R.id.spinnerCantidadProd1)
        btnComprar = findViewById(R.id.btnComprarProd1)
        btnOmitir = findViewById(R.id.btnOmitirProd1)


        val intent = Intent(this, SecondProductActivity::class.java)


        btnComprar.setOnClickListener {
            val cantidad = spinnerCantidad.selectedItem.toString().toInt()

            intent.putExtra("producto", "Bolsa Pony")
            intent.putExtra("precio", 120.0)
            intent.putExtra("cantidad", cantidad)

            startActivity(intent)
            finish()
        }


        btnOmitir.setOnClickListener {
            intent.putExtra("producto", "Bolsa Pony")
            intent.putExtra("precio", 120.0)
            intent.putExtra("cantidad", 0)

            startActivity(intent)
            finish()
        }


    }
}