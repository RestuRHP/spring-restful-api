package net.mylearn.restfulapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import net.mylearn.restfulapi.model.CreateStudentRequest
import net.mylearn.restfulapi.model.StudentResponse
import net.mylearn.restfulapi.model.WebResponse
import net.mylearn.restfulapi.repository.StudentRepository
import net.mylearn.restfulapi.service.StudentService
import net.mylearn.restfulapi.service.impl.StudentServiceImpl
import net.mylearn.restfulapi.validation.ValidationUtil
import org.junit.jupiter.api.*
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class StudentControllerTest @Autowired constructor(
        val mockMvc: MockMvc,
        val objectMapper: ObjectMapper
) {

    val baseUrl = "/api/student"

    @Nested
    @DisplayName("POST /api/student")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class PostStudent {

        @Test
        fun `should add new student`() {
            //given
            val newStudent = CreateStudentRequest("A0001", "Restu Hayat Pradana", "Cikampek", 14045)

            //when
            val performPost = mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                accept = MediaType.APPLICATION_JSON
                header(name = "X-Api-Key", "SECRET")
                content = objectMapper.writeValueAsString(newStudent)
            }

            //then
            performPost
                    .andDo { print() }
                    .andExpect {
                        content {
                            contentType(MediaType.APPLICATION_JSON)
                            json(objectMapper.writeValueAsString(WebResponse(200, "OK", newStudent)))
                        }
                    }
        }

    }

    @Nested
    @DisplayName("GET /api/student/{idStudent}")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class GetStudent {


    }

}