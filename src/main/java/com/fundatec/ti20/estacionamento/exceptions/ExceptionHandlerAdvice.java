package com.fundatec.ti20.estacionamento.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<ApiErrorDTO> ConflictHandler(ConflitoException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ConstraintErrorDTO> methodArgumentNotValidHandler(
            ConstraintViolationException exception, HttpServletRequest request) {
        log.error(exception.getMessage());
        ConstraintErrorDTO constraintViolationsDTO = new ConstraintErrorDTO();
        constraintViolationsDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        constraintViolationsDTO.setMessage("Requisicao possui campos invalidos");
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            constraintViolationsDTO.addError(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return new ResponseEntity<>(constraintViolationsDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAllowedException.class)
    public ResponseEntity<ApiErrorDTO> handleMethodNotAllowed(NotAllowedException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> NotFoundHandler(ObjectNotFoundException e) {
        return new ResponseEntity<>(new ApiErrorDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorDTO> ErroDesconhecidoHandler(Throwable e) {
        return new ResponseEntity<>(new ApiErrorDTO("não temos uma excessão para isso ainda",
                LocalDateTime.now()), HttpStatus.I_AM_A_TEAPOT);
    }
}
