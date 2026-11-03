package aman.example.crudSpringBootDemo.exception;

import aman.example.crudSpringBootDemo.dto.ValidationExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice


public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTOResponse> handleResourceNotFoundException
            (ResourceNotFoundException e , HttpServletRequest req) {
        ExceptionDTOResponse exceptionResponse = new ExceptionDTOResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                "validation failed",
                req.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDto> handleMethodArgumentNotValidException
            (MethodArgumentNotValidException e , HttpServletRequest req) {
        Map<String,String> fieldErrors = new HashMap<>();
        e.getBindingResult()
                .getFieldErrors()
                .forEach(
                        (error) ->
                        {fieldErrors.put
                                (error.getField(), error.getDefaultMessage());});


        ValidationExceptionResponseDto exceptionResponse = new ValidationExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "validation failed",
                req.getRequestURI(),
                fieldErrors
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionResponse);
    }



    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTOResponse> handleRuntimeException
            (RuntimeException e , HttpServletRequest req) {
        ExceptionDTOResponse exceptionResponse = new ExceptionDTOResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "validation failed",
                req.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponse);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTOResponse> handleGenericException
            (Exception e ,HttpServletRequest req){ // basically ye exception last exception hota h ki agar kuch nhi h to ye exception to dena hi h
        ExceptionDTOResponse exceptionResponse = new ExceptionDTOResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getMessage(),
                req.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponse);
    }
}
