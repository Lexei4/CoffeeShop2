package ru.plushchov.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.plushchov.controller.dto.ResponseError;

import java.util.UUID;

@RestControllerAdvice(basePackages = "ru.plushchov.controller")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> illegalArgumentException(IllegalArgumentException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "illegalArgumentException",
                exception.getLocalizedMessage(),
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseError> runtimeException(RuntimeException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "unknown",
                exception.getLocalizedMessage(),
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> runtimeException(Exception exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                "unknown",
                "Something went wrong",
                "mySystem"
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

