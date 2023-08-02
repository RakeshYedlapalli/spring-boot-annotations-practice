package com.gap.sample.practice.Springboot_practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoEmployeesFoundInDatabase.class)
    public ResponseEntity<String> handleNoRecordsFoundInDatabaseException(){
        return new ResponseEntity<>("No Records Found in Database..", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeCouldntBeSavedInDatabase.class)
    public ResponseEntity<String> handleemployeeCoudntSavedException(){
        return new ResponseEntity<>("Employee Data couldn't be inserted in Database..", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeNotFoundInDatabaseException.class)
    public ResponseEntity<String> hanleemployeeNotFoundInDatabaseById(){
        return new ResponseEntity<>("Employee Data couldn't be saved in Database..", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleBadRequestErrors(){
        return new ResponseEntity<>("Provided data is not valid", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.UnprocessableEntity.class)
    public ResponseEntity<String> handleUnprocessableException(){
        return new ResponseEntity<>("The request can't be processable...", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
