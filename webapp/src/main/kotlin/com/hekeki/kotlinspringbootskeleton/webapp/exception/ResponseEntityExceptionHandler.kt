package io.nbage.webapp.exception

import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    private val log = LoggerFactory.getLogger(GlobalResponseEntityExceptionHandler::class.java)

    @ExceptionHandler(Exception::class)
    fun unexpectedException(e: Exception, response: HttpServletResponse) {
        log.error(e.message, e)
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred while processing this request.")
    }
}