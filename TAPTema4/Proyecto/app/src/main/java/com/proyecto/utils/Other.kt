package com.proyecto.utils

import com.proyecto.enums.RecordType
import com.proyecto.enums.StateNames

object Other {

    fun stateNameToDisplay(state: StateNames): String {
        return when (state) {
            StateNames.Aguascalientes -> "Aguascalientes"
            StateNames.Baja_California -> "Baja California"
            StateNames.Baja_California_Sur -> "Baja California Sur"
            StateNames.Ciudad_de_Mexico -> "Ciudad de México"
            StateNames.Estado_de_Mexico -> "Estado de México"
            StateNames.Nuevo_Leon -> "Nuevo León"
            StateNames.Queretaro -> "Querétaro"
            StateNames.San_Luis_Potosi -> "San Luis Potosí"
            StateNames.Michoacan -> "Michoacán"
            StateNames.Yucatan -> "Yucatán"
            else -> state.name.replace("_", " ")
        }
    }



    fun recordTypeToDisplay(type: RecordType): String {
        return when (type) {
            RecordType.TRADICION -> "Tradición"
            RecordType.GASTRONOMIA -> "Gastronomía"
            RecordType.LUGAR -> "Lugar"
            RecordType.PALABRA -> "Expresión"
        }
    }



    fun stringToStateName(stateString: String): StateNames? {
        return try {
            StateNames.valueOf(stateString)
        } catch (e: IllegalArgumentException) {
            val normalized = stateString
                .replace(" ", "_")
                .replace("México", "Mexico")
                .replace("Michoacán", "Michoacan")
                .replace("Querétaro", "Queretaro")
                .replace("Potosí", "Potosi")
                .replace("Yucatán", "Yucatan")
                .replace("León", "Leon")
                .uppercase()

            try {
                StateNames.valueOf(normalized)
            } catch (e: Exception) {
                null
            }
        }
    }

    fun stringToRecordType(typeString: String): RecordType? {
        return try {
            when (typeString) {
                "Tradición" -> RecordType.TRADICION
                "Gastronomía" -> RecordType.GASTRONOMIA
                "Lugar" -> RecordType.LUGAR
                "Expresión" -> RecordType.PALABRA
                else -> RecordType.valueOf(typeString.uppercase())
            }
        } catch (e: Exception) {
            null
        }
    }
}