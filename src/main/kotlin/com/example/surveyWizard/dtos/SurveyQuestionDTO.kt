package com.example.surveyWizard.dtos

import com.example.surveyWizard.entities.SurveyEntity
import com.example.surveyWizard.enums.QuestionType

/**
 * A DTO for the {@link com.example.surveyWizard.entities.SurveyQuestion} entity
 */
data class SurveyQuestionDTO(
    val id: Int?,
    val surveyEntity: SurveyEntity?,
    val question: String?,
    val required: Boolean?,
    val questionType: QuestionType?
)