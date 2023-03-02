package com.example.surveyWizard.exceptions

import org.springframework.web.server.ResponseStatusException

class RegisterException(message: String?): Exception(message)

class UsedUsernameException(message: String?): Exception(message)

class RoleNotFoundRegisterException(message: String?): Exception(message)

class ApiException(code: Int, message: String) : ResponseStatusException(code, message, null)