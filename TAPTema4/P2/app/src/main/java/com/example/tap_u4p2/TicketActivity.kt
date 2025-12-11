package com.example.tap_u4p2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TicketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ticket)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val producto1 = intent.getStringExtra("producto1")
        val precio1 = intent.getDoubleExtra("precio1", 0.0)
        val cantidad1 = intent.getIntExtra("cantidad1", 0)

        val producto2 = intent.getStringExtra("producto2")
        val precio2 = intent.getDoubleExtra("precio2", 0.0)
        val cantidad2 = intent.getIntExtra("cantidad2", 0)

        val producto3 = intent.getStringExtra("producto3")
        val precio3 = intent.getDoubleExtra("precio3", 0.0)
        val cantidad3 = intent.getIntExtra("cantidad3", 0)


        var textoTicket = ""

        if (cantidad1 != 0 ) textoTicket += "$producto1 a: $$precio1 c/u, Piezas: $cantidad1 Total: $"+(precio1*cantidad1)+"\n"
        if (cantidad2 != 0 ) textoTicket += "$producto2 a: $$precio2 c/u, Piezas: $cantidad2 Total: $"+(precio2*cantidad2)+"\n"
        if (cantidad3 != 0 ) textoTicket += "$producto3 a: $$precio3 c/u, Piezas: $cantidad3 Total: $"+(precio3*cantidad3)+"\n"

        if (textoTicket.isEmpty()) {
            textoTicket = "No se compró ningun producto"
        }
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = textoTicket

    }
}