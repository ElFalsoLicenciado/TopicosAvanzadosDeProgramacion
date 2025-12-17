package com.proyecto


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.proyecto.models.Record
import com.proyecto.utils.Other
import java.util.Base64
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.Gson

class LectureActivity : AppCompatActivity() {

    private lateinit var labelTituloRead: TextView
    private lateinit var labelUsuarioRead: TextView
    private lateinit var labelEstadoRead: TextView
    private lateinit var labelCategoriaRead: TextView
    private lateinit var labelDescripcionRead: TextView
    private lateinit var panelImageRead: ImageView


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lecture)

        initViews()
        loadRecordData()
    }

    private fun initViews() {
        labelTituloRead = findViewById(R.id.labelTituloRead)
        labelUsuarioRead = findViewById(R.id.labelUsuarioRead)
        labelEstadoRead = findViewById(R.id.labelEstadoRead)
        labelCategoriaRead = findViewById(R.id.labelCategoriaRead)
        labelDescripcionRead = findViewById(R.id.labelDescripcionRead)
        panelImageRead = findViewById(R.id.panelImageRead)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun loadRecordData() {
        val recordJson = intent.getStringExtra("record_json")
        val gson = Gson()
        val record = gson.fromJson(recordJson, Record::class.java)

        record?.let { record ->
            labelTituloRead.text = record.title

            val authorName = record.author?.username ?: "Sin autor"
            labelUsuarioRead.text = "Autor: $authorName"

            val stateName = Other.stateNameToDisplay(record.state_name)
            val typeName = Other.recordTypeToDisplay(record.record_type)

            labelEstadoRead.text = "Estado: $stateName"
            labelCategoriaRead.text = "Categoría: $typeName"
            labelDescripcionRead.text = record.description


            record.image?.let { imageBase64 ->
                try {
                    val decodedBytes = Base64.getDecoder().decode(imageBase64)
                    val bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
                    panelImageRead.setImageBitmap(bitmap)
                } catch (e: Exception) {
                    e.printStackTrace()
                    panelImageRead.setImageResource(R.mipmap.imgnotfound)
                }
            } ?: run {
                panelImageRead.setImageResource(R.mipmap.imgnotfound)
            }
        } ?: run {
            finish()
        }
    }


}