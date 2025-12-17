package com.proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SelectorActivity : AppCompatActivity() {

    private lateinit var recordPanelList: RecyclerView
    private lateinit var txtSearch: EditText
    private lateinit var typeChoice: Spinner
    private lateinit var stateChoice: Spinner
    private lateinit var btnReset: Button

    private var records: List<com.proyecto.models.Record> = emptyList()
    private lateinit var adapter: RecordAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.selector)

        initViews()
        prepareRecyclerView()
        loadRecords()
    }

    private fun initViews() {
        recordPanelList = findViewById(R.id.panelRecordList)
        txtSearch = findViewById(R.id.textBusqueda)
        typeChoice = findViewById(R.id.spinnerTipo)
        stateChoice = findViewById(R.id.spinnerEstado)
        btnReset = findViewById(R.id.btnReset)

        btnReset.setOnClickListener {
            resetSearch()
        }
    }

    private fun resetSearch() {
        txtSearch.setText("")
        typeChoice.setSelection(0)
        stateChoice.setSelection(0)
    }

    private fun prepareRecyclerView() {
        recordPanelList.layoutManager = LinearLayoutManager(this)
    }

    private fun loadRecords() {
        try {

        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun showRecords() {
        adapter.updateRecords(records)
    }

    fun startLecture(record: Record) {

    }
}

class RecordAdapter(
    private var records: List<com.proyecto.models.Record>,
    private val onItemClick: (com.proyecto.models.Record) -> Unit
) : RecyclerView.Adapter<RecordAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Si usas un layout personalizado, aquí inicializas las vistas
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val record = records[position]
        holder.itemView.findViewById<TextView>(R.id.labelTitulo).text = record.title
        holder.itemView.findViewById<TextView>(R.id.labelUsuario).text = record.author
        holder.itemView.findViewById<TextView>(R.id.labelEstadoYCategoria).text = "${record.state_name} - ${record.record_type}"
        holder.itemView.setOnClickListener {
            onItemClick(record)
        }
    }

    override fun getItemCount(): Int = records.size

    fun updateRecords(newRecords: List<com.proyecto.models.Record>) {
        records = newRecords
        notifyDataSetChanged()
    }
}