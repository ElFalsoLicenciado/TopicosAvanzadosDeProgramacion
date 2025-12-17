package com.proyecto.services

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.proyecto.models.Record

class RecordServices(private val context: Context) {

    companion object {
        private const val BASE_URL = "http://192.168.1.71/TAP_2025/Proyecto/"
        private const val TAG = "RecordServices"

        private var instance: RecordServices? = null



        fun getInstance(context: Context): RecordServices {
            return instance ?: synchronized(this) {
                instance ?: RecordServices(context.applicationContext).also { instance = it }
            }
        }
    }

    private val requestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    interface RecordCallback {
        fun onSuccess(record: Record)
        fun onError(error: String)
    }

    interface RecordsCallback {
        fun onSuccess(records: List<Record>)
        fun onError(error: String)
    }



    fun getApprovedRecords(callback: RecordsCallback) {
        val url = "${BASE_URL}end_point_records.php"

        val request = object : StringRequest(
            Request.Method.POST,
            url,
            { response ->
                Log.d(TAG, "Raw response: $response")
                try {
                    val records = parseRecordsFromResponse(response)
                    if (records.isEmpty()) {
                        callback.onError("No se encontraron registros")
                    } else {
                        callback.onSuccess(records)
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Error parsing response", e)
                    callback.onError("Error al procesar: ${e.message}")
                }
            },
            { error ->
                Log.e(TAG, "Volley error: ${error.message}", error)
                callback.onError("Error de conexión: ${error.message}")
            }
        ) {
            override fun getParams(): Map<String, String> {
                return hashMapOf(
                    "operation" to "approvedRecords"
                )
            }

            override fun getBodyContentType(): String {
                return "application/x-www-form-urlencoded; charset=UTF-8"
            }
        }

        requestQueue.add(request)
    }



    fun getRecord(id_record: String, record_number: Int, callback: RecordCallback) {
        val url = "${BASE_URL}end_point_records.php"

        val request = object : StringRequest(
            Request.Method.POST,
            url,
            { response ->
                try {
                    val records = parseRecordsFromResponse(response)
                    if (records.isNotEmpty()) {
                        callback.onSuccess(records.first())
                    } else {
                        callback.onError("No se encontró el registro")
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Error parsing response", e)
                    callback.onError("Error al procesar: ${e.message}")
                }
            },
            { error ->
                Log.e(TAG, "Volley error", error)
                callback.onError("Error de conexión: ${error.message}")
            }
        ) {
            override fun getParams(): Map<String, String> {
                return hashMapOf(
                    "operation" to "getRecord",
                    "id_record" to id_record,
                    "record_number" to record_number.toString()
                )
            }
        }

        requestQueue.add(request)
    }

    private fun parseRecordsFromResponse(jsonString: String): List<Record> {
        return try {
            Log.d(TAG, "Parsing JSON: ${if (jsonString.length > 200) "${jsonString.substring(0, 200)}..." else jsonString}")

            if (jsonString.contains("Unexpected value") ||
                jsonString.contains("error") ||
                !jsonString.trim().startsWith("[")) {
                Log.e(TAG, "Invalid response: $jsonString")
                return emptyList()
            }

            val type = object : TypeToken<List<Record>>() {}.type
            val records = gson.fromJson<List<Record>>(jsonString, type) ?: emptyList()
            Log.d(TAG, "Successfully parsed ${records.size} records")


            records
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing JSON: ${e.message}")
            Log.e(TAG, "JSON that caused error: $jsonString")
            emptyList()
        }
    }
}

