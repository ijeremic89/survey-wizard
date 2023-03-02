package com.example.surveyWizard.controllers

import com.example.surveyWizard.dtos.UserDTO
import com.example.surveyWizard.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Int): UserDTO? {
        return userService.findById(id)
    }

    @GetMapping("/{email}")
    fun findByEmail(@PathVariable("email") email: String) : UserDTO? {
        return userService.findByEmail(email)
    }

    @GetMapping("/getAllUsers")
    fun getAllUsers() : List<UserDTO> {
        return userService.getAllUsers()
    }
}