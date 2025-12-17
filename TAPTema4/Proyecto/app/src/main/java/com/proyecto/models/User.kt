package com.proyecto.models

import com.proyecto.enums.UserType
import java.io.Serializable

data class User(
    var id_user: String = "",
    var user_type: UserType = UserType.GUEST,
    var username: String = "",
    var password: String = ""
) : Serializable {


}