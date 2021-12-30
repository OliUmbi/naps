package ch.bbbaden.naps.advices;

import ch.bbbaden.naps.dtos.ErrorMessageDTO;
import ch.bbbaden.naps.exceptions.notfound.AccountNotFoundException;
import ch.bbbaden.naps.exceptions.notfound.RoleNotFoundException;
import ch.bbbaden.naps.exceptions.notfound.TokenNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(RoleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDTO roleNotFoundHandler (RoleNotFoundException exception) {
		return new ErrorMessageDTO(exception.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDTO accountNotFoundHandler (AccountNotFoundException exception) {
		return new ErrorMessageDTO(exception.getMessage());
	}
	
	@ResponseBody
	@ExceptionHandler(TokenNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDTO tokenNotFoundHandler (TokenNotFoundException exception) {
		return new ErrorMessageDTO(exception.getMessage());
	}
}
