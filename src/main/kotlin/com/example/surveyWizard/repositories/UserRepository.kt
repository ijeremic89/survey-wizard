package com.example.surveyWizard.repositories

import com.example.surveyWizard.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findById(id: Int): Optional<UserEntity>

    fun findByEmail(email: String): Optional<UserEntity>
}
