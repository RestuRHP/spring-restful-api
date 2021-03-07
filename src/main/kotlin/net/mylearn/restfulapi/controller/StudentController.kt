package net.mylearn.restfulapi.controller

import net.mylearn.restfulapi.model.*
import net.mylearn.restfulapi.service.StudentService
import org.springframework.web.bind.annotation.*

@RestController
class StudentController(val studentService: StudentService) {

    @PostMapping(
            value = ["/api/student"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createMahasiswa(@RequestBody body: CreateStudentRequest): WebResponse<StudentResponse> {
        val mahasiswaResponse = studentService.create(body)

        return WebResponse(
                code = 200,
                status = "OK",
                data = mahasiswaResponse
        )
    }

    @GetMapping(
            value = ["/api/student/{idStudent}"],
            produces = ["application/json"]
    )
    fun getStudent(@PathVariable("idStudent") id: String): WebResponse<StudentResponse> {
        val studentResponse = studentService.getStudent(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = studentResponse
        )
    }

    @PutMapping(
            value = ["api/student/{idStudent}"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun updateStudent(
            @PathVariable("idStudent") id: String,
            @RequestBody updateStudentRequest: UpdateStudentRequest): WebResponse<StudentResponse> {
        val studentResponse = studentService.updateStudent(id, updateStudentRequest)
        return WebResponse(
                code = 200,
                status = "OK",
                data = studentResponse
        )
    }

    @DeleteMapping(
            value = ["api/student/{idStudent}"],
            produces = ["application/json"]
    )
    fun deleteStudent(@PathVariable("idStudent") id: String): WebResponse<String> {
        studentService.deleteStudent(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = "Student With ID : $id Deleted"
        )
    }

    @GetMapping(
            value = ["api/student"],
            produces = ["application/json"]
    )
    fun listStudent(
            @RequestParam(value = "size", defaultValue = "10") size: Int,
            @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<StudentResponse>> {
        val request = ListStudentRequest(page = page, size = size)
        val response = studentService.list(request)
        return WebResponse(
                code = 200,
                status = "OK",
                data = response
        )
    }

}