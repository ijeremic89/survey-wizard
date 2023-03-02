package com.example.surveyWizard.entities

import com.example.surveyWizard.enums.QuestionType
import jakarta.persistence.*

@Entity
@Table(name = "survey_question")
open class SurveyQuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @ManyToOne
    @JoinColumn(name = "survey_id")
    open var surveyEntity: SurveyEntity? = null

    @Lob
    @Column(name = "question", nullable = false)
    open var question: String? = null

    @Column(name = "required", nullable = false)
    open var required: Boolean? = false

    @Enumerated
    @Column(name = "question_type", nullable = false)
    open var questionType: QuestionType? = null
}