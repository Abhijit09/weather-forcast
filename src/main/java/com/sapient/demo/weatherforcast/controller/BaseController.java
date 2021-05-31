package com.sapient.demo.weatherforcast.controller;

import com.sapient.demo.weatherforcast.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleError() {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setMessage("Error while retrieving weather data");
        errorResponse.setErrorCode("ERR-001");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
