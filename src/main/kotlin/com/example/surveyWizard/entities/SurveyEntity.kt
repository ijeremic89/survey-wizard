package com.example.surveyWizard.entities

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "survey")
open class SurveyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    open var userEntity: UserEntity? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "start_date", nullable = false)
    open var startDate: Instant? = null

    @Column(name = "end_date", nullable = false)
    open var end_date: Instant? = null

    @OneToMany(mappedBy = "surveyEntity", cascade = [CascadeType.ALL])
    open var surveyQuestionEntities: MutableList<SurveyQuestionEntity> = mutableListOf()
}