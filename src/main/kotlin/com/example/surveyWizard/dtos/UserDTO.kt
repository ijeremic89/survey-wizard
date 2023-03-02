package com.example.surveyWizard.dtos

/**
 * A DTO for the {@link com.example.surveyWizard.entities.User} entity
 */
data class UserDTO(
    val id: Int?,
    val username: String?,
    val password: String?,
    val email: String?,
    val roles: String?
)