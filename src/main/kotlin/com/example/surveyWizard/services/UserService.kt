package com.example.surveyWizard.services

import com.example.surveyWizard.auth.HashService
import com.example.surveyWizard.auth.TokenService
import com.example.surveyWizard.dtos.*
import com.example.surveyWizard.entities.UserEntity
import com.example.surveyWizard.enums.UserRole
import com.example.surveyWizard.exceptions.RoleNotFoundRegisterException
import com.example.surveyWizard.exceptions.UsedUsernameException
import com.example.surveyWizard.repositories.UserRepository
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
    private val tokenService: TokenService,
    private val hashService: HashService
) {

    fun login(loginDTO: LoginDTO): LoginResponseDTO {
        if (repository.findByEmail(loginDTO.email).isPresent) {
            return LoginResponseDTO(tokenService.createToken(loginDTO))
        } else {
            throw BadCredentialsException("Invalid username/password supplied")
        }
    }

    fun register(registerDTO: RegisterDTO): UserDTO {
        try {
            UserRole.valueOf(registerDTO.role)
        } catch (e: NullPointerException) {
            throw RoleNotFoundRegisterException("Role ${registerDTO.role} not found.")
        }

        if (repository.findByEmail(registerDTO.email).isEmpty) {
            val user = UserEntity(
                username = registerDTO.email.split('@')[0],
                email = registerDTO.email,
                password = hashService.hashBcrypt(registerDTO.password),
                roles = registerDTO.role
            )
            return save(user)
        }

        throw UsedUsernameException("Username already exists!")
    }

    fun save(userEntity: UserEntity): UserDTO {
        return repository.save(userEntity).toDto()
    }

    fun findById(id: Int): UserDTO? =
        repository.findById(id).map { it.toDto() }.orElseThrow {
            Exception("User with ID:$id not found")
        }

    fun findByEmail(email: String): UserDTO? =
        repository.findByEmail(email).map { it.toDto() }.orElseThrow {
            Exception("User with ID:$email not found")
        }

    fun getAllUsers(): List<UserDTO> =
        repository.findAll().map { it.toDto() }
}
