package com.hekeki.kotlinspringbootskeleton.webapp.exception

import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    private val log = LoggerFactory.getLogger(GlobalResponseEntityExceptionHandler::class.java)

    @ExceptionHandler(Exception::class)
    fun unexpectedException(e: Exception, response: HttpServletResponse): ResponseEntity<ErrorMessage> {
        log.error(e.message, e)
        return ResponseEntity(ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "An error occurred while processing this request."), HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}