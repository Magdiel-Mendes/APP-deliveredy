package br.com.apialgafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public abstract class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	

	public EntidadeNaoEncontradaException(String msg) {
		super(msg);
		}


//	public EntidadeNaoEncontradaException(HttpStatus status, String reason) {
//		super(status, reason);
//		// TODO Auto-generated constructor stub
//	}

}
