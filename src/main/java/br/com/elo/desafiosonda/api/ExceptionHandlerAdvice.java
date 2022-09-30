package br.com.elo.desafiosonda.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import br.com.elo.desafiosonda.exception.*;

import br.com.elo.desafiosonda.exception.ApiException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ExceptionHandlerDTO> handleException(ApiException exception) {
		
		ExceptionHandlerDTO exceptionHandler = new ExceptionHandlerDTO(exception.getCausa() ,exception.getMessage());
		
		return ResponseEntity.status(exception.getHttpStatus()).body(exceptionHandler);
	}
}
