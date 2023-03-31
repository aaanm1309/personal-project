package br.com.adrianomenezes.generalback.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TokenError extends com.auth0.jwt.exceptions.TokenExpiredException {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public TokenError() {
		super("Token Error - Tratado", Instant.now());
	}
	public TokenError(Exception message) {
		super(message.getMessage(), Instant.now());
	}

	public TokenError(Long timestamp, Integer status, String error, String message, String path) {
		super(message, Instant.now());
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
