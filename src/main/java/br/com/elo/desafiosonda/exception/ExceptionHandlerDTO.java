package br.com.elo.desafiosonda.exception;

import java.time.LocalDateTime;

//Essa classe é informada todos os campos que eu quero na exceção.
public class ExceptionHandlerDTO {
	
	private LocalDateTime date;
	private String causaError;
	private String msgError;

	
	public ExceptionHandlerDTO(String causaError, String msgError) {
		this.date = LocalDateTime.now();
		this.causaError = causaError;
		this.msgError = msgError;
	}

	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public String getCausaError() {
		return causaError;
	}


	public void setCausaError(String causaError) {
		this.causaError = causaError;
	}


	public String getMsgError() {
		return msgError;
	}


	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	
}
