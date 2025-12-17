package com.proyecto.services

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.proyecto.models.User

class UserServices(private val context: Context) {

    companion object {
        private const val BASE_URL = "http://192.168.1.71/TAP_2025/Proyecto/"
        private const val TAG = "UserServices"

        private var instance: UserServices? = null

        fun getInstance(context: Context): UserServices {
            return instance ?: synchronized(this) {
                instance ?: UserServices(context.applicationContext).also { instance = it }
            }
        }
    }

    private val requestQueue = Volley.newRequestQueue(context)
    private val gson = Gson()

    interface UserCallback {
        fun onSuccess(user: User?)
        fun onError(error: String)
    }

    fun testUserConnection(callback: (String) -> Unit) {
        val testUrl = "${BASE_URL}end_point_users.php?operation=getById&id_user=3cc426c4-d318-11f0-a756-e88088c48b50"

        val testRequest = StringRequest(
            Request.Method.POST,
            testUrl,
            { response ->
                Log.d(TAG, "User test response: $response")
                callback("Success: ${response.take(100)}...")
            },
            { error ->
                Log.e(TAG, "User test error", error)
                callback("Error: ${error.message}")
            }
        )

        requestQueue.add(testRequest)
    }

    fun getUser(id_user: String, callback: UserCallback) {
        val url = "${BASE_URL}end_point_users.php"

        Log.d(TAG, "Getting user with ID: $id_user")

        val request = object : StringRequest(
            Request.Method.POST,
            url,
            { response ->
                Log.d(TAG, "Raw user response: $response")
                try {
                    val users = parseUsersFromResponse(response)
                    if (users.isNotEmpty()) {
                        Log.d(TAG, "User found: ${users.first().username}")
                        callback.onSuccess(users.first())
                    } else {
                        Log.d(TAG, "No user found for ID: $id_user")
                        callback.onSuccess(null)
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Error parsing user response", e)
                    callback.onError("Error al procesar: ${e.message}")
                }
            },
            { error ->
                Log.e(TAG, "Volley error getting user", error)
                callback.onError("Error de conexión: ${error.message}")
            }
        ) {
            override fun getParams(): Map<String, String> {
                return hashMapOf(
                    "operation" to "getById",
                    "id_user" to id_user
                )
            }

            override fun getBodyContentType(): String {
                return "application/x-www-form-urlencoded; charset=UTF-8"
            }
        }

        requestQueue.add(request)
    }

    fun getUserByCredentials(username: String, password: String, callback: UserCallback) {
        val url = "${BASE_URL}end_point_users.php"

        val request = object : StringRequest(
            Request.Method.POST,
            url,
            { response ->
                try {
                    val users = parseUsersFromResponse(response)
                    callback.onSuccess(users.firstOrNull())
                } catch (e: Exception) {
                    Log.e(TAG, "Error parsing user response", e)
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
                    "operation" to "getByCredentials",
                    "username" to username,
                    "password" to password
                )
            }
        }

        requestQueue.add(request)
    }

    private fun parseUsersFromResponse(jsonString: String): List<User> {
        return try {
            Log.d(TAG, "Parsing user JSON: ${if (jsonString.length > 200) "${jsonString.substring(0, 200)}..." else jsonString}")

            if (jsonString.trim() == "[]" || jsonString.trim().isEmpty()) {
                Log.d(TAG, "Empty user array or empty response")
                return emptyList()
            }

            if (!jsonString.trim().startsWith("[")) {
                Log.e(TAG, "User response is not a JSON array: $jsonString")
                return emptyList()
            }

            val type = object : TypeToken<List<User>>() {}.type
            val users = gson.fromJson<List<User>>(jsonString, type) ?: emptyList()
            Log.d(TAG, "Successfully parsed ${users.size} users")
            users
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing user JSON: ${e.message}")
            Log.e(TAG, "JSON that caused error: $jsonString")
            emptyList()
        }
    }
}