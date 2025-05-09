package br.com.hcm.ApiRestControleDeContatos.exception.advice;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hcm.ApiRestControleDeContatos.exception.EntityException;
import br.com.hcm.ApiRestControleDeContatos.exception.IndexArrayException;
import br.com.hcm.ApiRestControleDeContatos.exception.NullException;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;

@Hidden // muito importante para não fazer conflito com o Swagger e causar internal error
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NullException.class)
	private ResponseEntity<RestErrorMessage> nullExceptionHandler(NullException exception, HttpServletRequest request) {  
		RestErrorMessage message = new RestErrorMessage(HttpStatus.BAD_REQUEST,	exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
	
	@ExceptionHandler(IndexArrayException.class)
	private ResponseEntity<RestErrorMessage> indexArrayException(IndexArrayException exception) {
		RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@ExceptionHandler(EntityException.class)
	private ResponseEntity<RestErrorMessage> entityException(EntityException exception) {
		RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}

}
