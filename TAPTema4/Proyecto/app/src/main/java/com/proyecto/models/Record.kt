package com.proyecto.models

import com.proyecto.enums.RecordType
import com.proyecto.enums.StateNames
import java.io.Serializable

data class Record(
    var id_record: String = "",
    var record_number: Int = 0,
    var id_author: String = "",
    var state_name: StateNames = StateNames.entries.first(),
    var record_type: RecordType = RecordType.entries.first(),
    var title: String = "",
    var description: String = "",
    var image: String? = null,
    var image_name: String = "",
    var is_hidden: Int = 0,
    var is_public: Int = 0,
    var author: User? = null
) : Serializable {
}