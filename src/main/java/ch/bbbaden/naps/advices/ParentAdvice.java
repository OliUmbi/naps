package ch.bbbaden.naps.advices;

import ch.bbbaden.naps.dtos.ErrorMessageDTO;
import ch.bbbaden.naps.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ParentAdvice {
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessageDTO exceptionHandler (Exception exception) {
		return new ErrorMessageDTO(exception.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorMessageDTO unauthorizedHandler (UnauthorizedException exception) {
		return new ErrorMessageDTO(exception.getMessage());
	}
}
