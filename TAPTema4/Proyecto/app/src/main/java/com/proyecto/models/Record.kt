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
    var author: String = ""
) : Serializable {


    constructor(
        id_record: String,
        record_number: Int,
        id_author: String,
        state_name: StateNames,
        record_type: RecordType,
        title: String,
        description: String,
        image: String?,
        image_name: String,
        is_hidden: Int,
        is_public: Int,
    ) : this(id_record, record_number, id_author, state_name, record_type,
        title, description, image, image_name, is_hidden, is_public, "")

    val isPublicBoolean: Boolean
        get() = is_public == 1

    val isHiddenBoolean: Boolean
        get() = is_hidden == 1

    fun Is_public(): Boolean = is_public == 1

    fun is_hidden(): Int = is_hidden

    fun setIs_public(isPublic: Int) {
        this.is_public = isPublic
    }

    fun setIs_hidden(isHidden: Int) {
        this.is_hidden = isHidden
    }
}