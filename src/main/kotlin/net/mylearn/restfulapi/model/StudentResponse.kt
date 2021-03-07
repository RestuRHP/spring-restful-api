package net.mylearn.restfulapi.model

import java.util.*

data class StudentResponse(

        val idStudent: String,

        var name: String,

        var address: String,

        var telephone: Int,

        var createdAt: Date,

        var updatedAt: Date?

)