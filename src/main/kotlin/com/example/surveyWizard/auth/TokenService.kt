package com.example.surveyWizard.auth

import com.example.surveyWizard.dtos.LoginDTO
import com.example.surveyWizard.dtos.UserDTO
import com.example.surveyWizard.services.UserService
import org.springframework.context.annotation.Lazy
import org.springframework.security.oauth2.jwt.*
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit

@Service
class TokenService(
    private val jwtDecoder: JwtDecoder,
    private val jwtEncoder: JwtEncoder,
    @Lazy val userService: UserService,
) {
    fun createToken(loginDTO: LoginDTO): String {
        val jwsHeader = JwsHeader.with { "HS256" }.build()
        val claims = JwtClaimsSet.builder()
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plus(30L, ChronoUnit.DAYS))
            .subject(loginDTO.email)
            .claim("email", loginDTO.email)
            .build()
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).tokenValue
    }

    fun parseToken(token: String): UserDTO? {
        return try {
            val jwt = jwtDecoder.decode(token)
            val userEmail = jwt.claims["email"].toString()
            userService.findByEmail(userEmail)
        } catch (e: Exception) {
            null
        }
    }
}