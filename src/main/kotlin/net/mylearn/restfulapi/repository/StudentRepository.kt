package net.mylearn.restfulapi.repository

import net.mylearn.restfulapi.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, String> {
}