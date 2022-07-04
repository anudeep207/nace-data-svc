package co.luxoft.nace.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.luxoft.nace.model.ResponseStatus;
import co.luxoft.nace.utils.Constant;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<?> handleErrorResponse(final Exception exception) {
		ResponseStatus response = ResponseStatus.builder()
			.status(Constant.ResponseStatus.FAIL.name())
			.code("500")
			.cause(exception.getLocalizedMessage())
			.build();
		return ResponseEntity.internalServerError().body(response);
	}
}
