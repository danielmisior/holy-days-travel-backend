package com.backend.holydaystravel.controller;

import com.backend.holydaystravel.exception.FlightNotFoundException;
import com.backend.holydaystravel.exception.HotelNotFoundException;
import com.backend.holydaystravel.exception.TourNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TourNotFoundException.class)
    public ResponseEntity<Object> handleTourNotFoundException(TourNotFoundException e) {
        return new ResponseEntity<>("The tour doesn't exist.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Object> handleHotelNotFoundException(HotelNotFoundException e) {
        return new ResponseEntity<>("The hotel doesn't exist.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<Object> handleFlightNotFoundException(FlightNotFoundException e) {
        return new ResponseEntity<>("The flight doesn't exist.", HttpStatus.BAD_REQUEST);
    }
}
