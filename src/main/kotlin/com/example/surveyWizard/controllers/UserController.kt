package com.example.surveyWizard.controllers

import com.example.surveyWizard.dtos.UserDTO
import com.example.surveyWizard.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {
    @RequestMapping("/{id}", method = [RequestMethod.GET])
    fun findById(@PathVariable id: Int): UserDTO? {
        return userService.findById(id)
    }

    @RequestMapping(method = [RequestMethod.GET])
    fun findByEmail(@RequestParam email: String) : UserDTO? {
        return userService.findByEmail(email)
    }

    @GetMapping("/getAllUsers")
    fun getAllUsers() : List<UserDTO> {
        return userService.getAllUsers()
    }
}