package com.example.tap_u4p2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdProductActivity : AppCompatActivity() {

    private lateinit var spinnerCantidad : Spinner
    private lateinit var btnComprar : Button
    private lateinit var btnOmitir : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        spinnerCantidad = findViewById(R.id.spinnerCantidadProd3)
        btnComprar = findViewById(R.id.btnComprarProd3)
        btnOmitir = findViewById(R.id.btnOmitirProd3)

        val producto1 = this@ThirdProductActivity.intent.getStringExtra("producto1")
        val precio1 = this@ThirdProductActivity.intent.getDoubleExtra("precio1", 0.0)
        val cantidad1 = this@ThirdProductActivity.intent.getIntExtra("cantidad1", 0)

        val producto2 = this@ThirdProductActivity.intent.getStringExtra("producto")
        val precio2 = this@ThirdProductActivity.intent.getDoubleExtra("precio", 0.0)
        val cantidad2 = this@ThirdProductActivity.intent.getIntExtra("cantidad", 0)

        println("Producto 1: $producto1, Precio 1: $precio1, Cantidad 1: $cantidad1")
        println("Producto 2: $producto2, Precio 2: $precio2, Cantidad 2: $cantidad2")


        val intent = Intent(this, TicketActivity::class.java)


        btnComprar.setOnClickListener {
            val cantidad = spinnerCantidad.selectedItem.toString().toInt()

            intent.putExtra("producto1", producto1 )
            intent.putExtra("precio1", precio1 )
            intent.putExtra("cantidad1", cantidad1 )

            intent.putExtra("producto2", producto2 )
            intent.putExtra("precio2", precio2 )
            intent.putExtra("cantidad2", cantidad2 )

            intent.putExtra("producto3", "Bolsa Luis Guason" )
            intent.putExtra("precio3", 630.5 )
            intent.putExtra("cantidad3", cantidad )

            startActivity(intent)
            finish()
        }

        btnOmitir.setOnClickListener {
            intent.putExtra("producto1", producto1 )
            intent.putExtra("precio1", precio1 )
            intent.putExtra("cantidad1", cantidad1 )

            intent.putExtra("producto2", producto2 )
            intent.putExtra("precio2", precio2 )
            intent.putExtra("cantidad2", cantidad2 )

            intent.putExtra("producto3", "Bolsa Luis Guason" )
            intent.putExtra("precio3", 630.5 )
            intent.putExtra("cantidad3", 0 )

            startActivity(intent)
            finish()

        }

    }
}