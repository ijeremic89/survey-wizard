package com.example.surveyWizard.controllers

import com.example.surveyWizard.dtos.*
import com.example.surveyWizard.services.UserService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val userService: UserService
) {

    @PostMapping("/login")
    fun login(@RequestBody loginDTO: LoginDTO): LoginResponseDTO {
        return userService.login(loginDTO)
    }

    @PostMapping("/register")
    fun register(@RequestBody registerDTO: RegisterDTO): UserDTO {
        return userService.register(registerDTO)
    }
}