package pl.bjur.shooter.commons.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
class ShooterControllerExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ErrorInfo handleNotFound(Throwable t) {
		return new ErrorInfo(ERROR_CODE.NOT_FOUND, t.getMessage());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	public ErrorInfo handleEntityNotFound(Throwable t) {
		return new ErrorInfo(ERROR_CODE.NOT_FOUND, t.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ErrorInfo handleNotValid(Throwable t) {
		return new ErrorInfo(ERROR_CODE.NOT_VALID_PARAM, t.getMessage());
	}
}