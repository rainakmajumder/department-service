package com.demo.ron.department.service.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.ron.department.service.enums.Error;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> handleFailures(Exception e) {
		ErrorMessage error = new ErrorMessage(e.getMessage());

		if (e.getMessage().equals(Error.INTERNAL_SERVER_ERROR.toString())) {
			return new ResponseEntity<ErrorMessage>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		} else if (e.getMessage().equals(Error.RECORD_NOT_FOUND.toString())) {
			return new ResponseEntity<ErrorMessage>(error, new HttpHeaders(), HttpStatus.NOT_FOUND);
		} else if (e.getMessage().equals(Error.SERVICE_UNAVAILABLE.toString())) {
			return new ResponseEntity<ErrorMessage>(error, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
		} else if (e.getMessage().equals(Error.BAD_REQUEST.toString())) {
			return new ResponseEntity<ErrorMessage>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ErrorMessage>(error, new HttpHeaders(), HttpStatus.REQUEST_TIMEOUT);

	}
}
