package com.proyecto

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.models.Record
import com.proyecto.models.User
import com.proyecto.services.RecordServices
import com.proyecto.services.UserServices
import com.proyecto.utils.NetworkHelper
import com.proyecto.utils.Other
import com.google.gson.Gson


class SelectorActivity : AppCompatActivity() {

    private lateinit var recordPanelList: RecyclerView
    private lateinit var txtSearch: EditText
    private lateinit var typeChoice: Spinner
    private lateinit var stateChoice: Spinner
    private lateinit var btnReset: Button

    private lateinit var recordServices: RecordServices
    private lateinit var userServices: UserServices
    private var records: List<com.proyecto.models.Record> = emptyList()
    private lateinit var adapter: RecordAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selector)

        initViews()
        initServices()
        prepareRecyclerView()
        setupSpinners()
        loadRecords()
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

        txtSearch.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: android.text.Editable?) {
                filterRecords()
            }
        })
    }

    private fun initServices() {
        recordServices = RecordServices.getInstance(this)
        userServices = UserServices.getInstance(this)
    }

    private fun resetSearch() {
        loadRecords()
        txtSearch.setText("")
        typeChoice.setSelection(0)
        stateChoice.setSelection(0)
        adapter.updateRecords(records)
    }

    private fun setupSpinners() {
        val statesArray = resources.getStringArray(R.array.states)
        val stateAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, statesArray)
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        stateChoice.adapter = stateAdapter

        val typesArray = resources.getStringArray(R.array.types)
        val typeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, typesArray)
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        typeChoice.adapter = typeAdapter

        stateChoice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) {
                    filterRecords()
                }
                else {
                    resetSearch()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        typeChoice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) {
                    filterRecords()
                } else {
                    resetSearch()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun prepareRecyclerView() {
        recordPanelList.layoutManager = LinearLayoutManager(this)
        adapter = RecordAdapter(emptyList()) { record ->
            startLecture(record)
        }
        recordPanelList.adapter = adapter
    }

    private fun loadRecords() {
        if (!NetworkHelper.isNetworkAvailable(this)) {
            println("No hay conexión a internet")
            Toast.makeText(this, "No hay conexión a internet", Toast.LENGTH_SHORT).show()
            return
        }


        recordServices.getApprovedRecords(
            object : RecordServices.RecordsCallback {
                override fun onSuccess(records: List<Record>) {
                    runOnUiThread {
                        this@SelectorActivity.records = records

                        if (records.isNotEmpty()) {
                            adapter.updateRecords(records)
                            loadAuthorsForRecords(records)
                        } else {
                            Toast.makeText(this@SelectorActivity, "No hay registros disponibles", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onError(error: String) {
                    runOnUiThread {
                        println("Error: $error")
                        Toast.makeText(this@SelectorActivity, "Error: $error", Toast.LENGTH_LONG).show()
                    }
                }
            }
        )
    }

    private fun loadAuthorsForRecords(records: List<Record>) {
        Log.d("UserLoad", "Loading authors for ${records.size} records")

        records.forEachIndexed { index, record ->
            if (record.id_author.isNotEmpty()) {
                userServices.getUser(record.id_author,
                    object : UserServices.UserCallback {
                        override fun onSuccess(user: User?) {
                            record.author = user
                            Log.d("UserLoad", "Author loaded for record $index: ${user?.username ?: "null"}")

                            runOnUiThread {
                                adapter.notifyItemChanged(index)
                            }
                        }

                        override fun onError(error: String) {
                            Log.e("UserLoad", "Error loading user for record ${record.id_record}: $error")
                            record.author = null
                        }
                    }
                )
            } else {
                Log.d("UserLoad", "Record $index has empty author ID")
                record.author = null
            }
        }
    }

    private fun filterRecords() {
        val searchText = txtSearch.text.toString().lowercase()
        val selectedState = stateChoice.selectedItem.toString().trim('"')
        val selectedType = typeChoice.selectedItem.toString().trim('"')

        val isStateSelected = stateChoice.selectedItemPosition > 0
        val isTypeSelected = typeChoice.selectedItemPosition > 0

        val filtered = records.filter { record ->
            val matchesSearch = searchText.isEmpty() ||
                    record.title.lowercase().contains(searchText) ||
                    record.description.lowercase().contains(searchText) ||
                    record.author?.username?.lowercase()?.contains(searchText) == true

            val matchesState = !isStateSelected ||
                    Other.stateNameToDisplay(record.state_name) == selectedState

            val matchesType = !isTypeSelected ||
                    Other.recordTypeToDisplay(record.record_type) == selectedType

            matchesSearch && matchesState && matchesType
        }

        adapter.updateRecords(filtered)
    }



    fun startLecture(record: Record) {
        val gson = Gson()
        val recordJson = gson.toJson(record)

        val intent = Intent(this, LectureActivity::class.java).apply {
            putExtra("record_json", recordJson)
        }
        startActivity(intent)
    }
}

class RecordAdapter(
    private var records: List<Record>,
    private val onItemClick: (Record) -> Unit
) : RecyclerView.Adapter<RecordAdapter.ViewHolder>() {

    class ViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {
        val labelTitulo: TextView = view.findViewById(R.id.labelTitulo)
        val labelUsuario: TextView = view.findViewById(R.id.labelUsuario)
        val labelEstadoYCategoria: TextView = view.findViewById(R.id.labelEstadoYCategoria)
        val panelImage: ImageView = view.findViewById(R.id.panelImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem, parent, false)
        return ViewHolder(view)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val record = records[position]

        holder.labelTitulo.text = record.title
        holder.labelUsuario.text = record.author?.username ?: "Sin autor"

        val stateName = Other.stateNameToDisplay(record.state_name)
        val typeName = Other.recordTypeToDisplay(record.record_type)

        holder.labelEstadoYCategoria.text = "${stateName} - ${typeName}"


        record.image?.let { imageBase64 ->
            try {
                val decodedBytes = java.util.Base64.getDecoder().decode(imageBase64)
                val bitmap = android.graphics.BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
                holder.panelImage.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
                holder.panelImage.setImageResource(R.mipmap.imgnotfound)
            }
        } ?: run {
            holder.panelImage.setImageResource(R.mipmap.imgnotfound)
        }

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