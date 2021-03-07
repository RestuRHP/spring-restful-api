package net.mylearn.restfulapi.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateStudentRequest (

        @field:NotBlank
        val name:String?,

        @field:NotBlank
        val address:String?,

        @field:NotNull
        @field:Min(1)
        val telephone:Int?
)