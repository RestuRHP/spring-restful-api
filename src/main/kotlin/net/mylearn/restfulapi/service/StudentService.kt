package net.mylearn.restfulapi.service

import net.mylearn.restfulapi.model.CreateStudentRequest
import net.mylearn.restfulapi.model.ListStudentRequest
import net.mylearn.restfulapi.model.StudentResponse
import net.mylearn.restfulapi.model.UpdateStudentRequest

interface StudentService {

    fun create(createMahasiswaRequest: CreateStudentRequest): StudentResponse

    fun getStudent(id: String): StudentResponse

    fun updateStudent(id:String, updateStudentRequest: UpdateStudentRequest):StudentResponse

    fun deleteStudent(id:String)

    fun list(listStudentRequest: ListStudentRequest):List<StudentResponse>

}