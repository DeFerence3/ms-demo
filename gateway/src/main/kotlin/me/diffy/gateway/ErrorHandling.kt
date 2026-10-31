package me.diffy.gateway

import org.springframework.cloud.gateway.support.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.util.*

@ControllerAdvice
class ErrorHandling {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoun(
        exception: NotFoundException
    ): ResponseEntity<ErrorDetails>{
        val errorDetails = ErrorDetails(
            Date(), exception.message ?: "",
            "${exception.body}"
        )
        return ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }


}