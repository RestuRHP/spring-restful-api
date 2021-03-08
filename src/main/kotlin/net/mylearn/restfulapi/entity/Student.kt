package net.mylearn.restfulapi.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_mahasiswa")
data class Student(
        @Id
        @Column(name = "id_student")
        val idStudent: String,

        @Column(name = "name")
        var name: String,

        @Column(name = "address")
        var address: String,

        @Column(name = "telephone")
        var telephone: Int,

        @Column(name = "created_at")
        var createdAt: Date,

        @Column(name = "updated_at")
        var updatedAt: Date?
)