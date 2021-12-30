package ch.bbbaden.naps.advices;

import ch.bbbaden.naps.dtos.ErrorMessageDTO;
import ch.bbbaden.naps.exceptions.alreadyexists.AccountAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AlreadyExistsAdvice {
	
	@ResponseBody
	@ExceptionHandler(AccountAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDTO accountAlreadyExistsHandler (AccountAlreadyExistsException exception) {
		return new ErrorMessageDTO(exception.getMessage());
	}
}
