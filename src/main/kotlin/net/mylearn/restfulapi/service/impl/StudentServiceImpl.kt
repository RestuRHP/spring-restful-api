package net.mylearn.restfulapi.service.impl

import net.mylearn.restfulapi.entity.Student
import net.mylearn.restfulapi.error.NotFoundException
import net.mylearn.restfulapi.model.CreateStudentRequest
import net.mylearn.restfulapi.model.ListStudentRequest
import net.mylearn.restfulapi.model.StudentResponse
import net.mylearn.restfulapi.model.UpdateStudentRequest
import net.mylearn.restfulapi.repository.StudentRepository
import net.mylearn.restfulapi.service.StudentService
import net.mylearn.restfulapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class StudentServiceImpl(
        val studentRepository: StudentRepository,
        val validationUtil: ValidationUtil
) : StudentService {
    override fun create(createMahasiswaRequest: CreateStudentRequest): StudentResponse {
        validationUtil.validate(createMahasiswaRequest)

        val student = Student(
                idStudent = createMahasiswaRequest.idStudent!!,
                name = createMahasiswaRequest.name!!,
                address = createMahasiswaRequest.address!!,
                telephone = createMahasiswaRequest.telephone!!,
                createdAt = Date(),
                updatedAt = null
        )
        studentRepository.save(student)

        return convertStudentToStudentResponse(student)
    }

    override fun getStudent(id: String): StudentResponse {
        val student = findIdStudent(id)

        return convertStudentToStudentResponse(student)
    }

    override fun updateStudent(id: String, updateStudentRequest: UpdateStudentRequest): StudentResponse {
        val student = findIdStudent(id)

        validationUtil.validate(updateStudentRequest)

        student.apply {
            name = updateStudentRequest.name!!
            address = updateStudentRequest.address!!
            telephone = updateStudentRequest.telephone!!
            updatedAt = Date()
        }


        studentRepository.save(student)

        return convertStudentToStudentResponse(student)
    }

    override fun deleteStudent(id: String) {
        val student = findIdStudent(id)
        studentRepository.delete(student)
    }

    override fun list(listStudentRequest: ListStudentRequest): List<StudentResponse> {
        val page = studentRepository.findAll(PageRequest.of(listStudentRequest.page, listStudentRequest.size))
        val student: List<Student> = page.get().collect(Collectors.toList())

        return student.map { convertStudentToStudentResponse(it) }
    }

    private fun findIdStudent(id: String): Student {
        val student = studentRepository.findByIdOrNull(id)
        if (student == null) {
            throw NotFoundException()
        } else {
            return student
        }
    }

    private fun convertStudentToStudentResponse(student: Student): StudentResponse {
        return StudentResponse(
                idStudent = student.idStudent,
                name = student.name,
                address = student.address,
                telephone = student.telephone,
                createdAt = student.createdAt,
                updatedAt = student.updatedAt
        )
    }
}