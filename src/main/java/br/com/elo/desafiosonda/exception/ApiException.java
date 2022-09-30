package br.com.elo.desafiosonda.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus httpStatus;
	private String causa;

	public ApiException(HttpStatus status, String msg, String causa) {
		super(msg);
		this.httpStatus = status;
		this.causa = causa;
	}

	public HttpStatus getHttpStatus() {
		
		return httpStatus;
	}
	
	public String getCausa() {
		return causa;
	}
}
