package ch.bbbaden.naps.advices;

import ch.bbbaden.naps.dtos.ErrorMessageDTO;
import ch.bbbaden.naps.exceptions.invalid.InvalidEmailException;
import ch.bbbaden.naps.exceptions.invalid.InvalidLoginException;
import ch.bbbaden.naps.exceptions.invalid.InvalidPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidAdvice {
	
	@ResponseBody
	@ExceptionHandler(InvalidPasswordException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDTO invalidPasswordHandler (InvalidPasswordException exception) {
		return new ErrorMessageDTO(exception.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidEmailException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDTO invalidEmailHandler (InvalidEmailException exception) {
		return new ErrorMessageDTO(exception.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(InvalidLoginException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDTO invalidLoginHandler (InvalidLoginException exception) {
		return new ErrorMessageDTO(exception.getMessage());
	}
}
