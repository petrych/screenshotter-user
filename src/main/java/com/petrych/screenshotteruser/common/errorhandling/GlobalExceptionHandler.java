package com.petrych.screenshotteruser.common.errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	public GlobalExceptionHandler() {
		
		super();
	}
	
	@ExceptionHandler(UserEntityNotFoundException.class)
	public ResponseEntity<Object> handleUserEntityNotFoundException(Exception ex, HttpServletRequest request) {
		
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		ApiError apiError = new ApiError(httpStatus.value(), ex.getMessage(), request.getRequestURI());
		
		LOG.warn(apiError.toString());
		
		return new ResponseEntity<>(apiError, Objects.requireNonNull(httpStatus));
	}
	
}
