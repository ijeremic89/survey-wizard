package com.example.surveyWizard.dtos

import com.example.surveyWizard.entities.UserEntity
import java.time.Instant

/**
 * A DTO for the {@link com.example.surveyWizard.entities.Survey} entity
 */
data class SurveyDTO(
    val id: Int?,
    val userEntity: UserEntity?,
    val name: String?,
    val startDate: Instant?,
    val end_date: Instant?
)