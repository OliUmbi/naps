package ch.bbbaden.naps.util;

import ch.bbbaden.naps.exceptions.invalid.InvalidEmailException;
import ch.bbbaden.naps.exceptions.invalid.InvalidPasswordException;
import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class ValidationUtil {
	
	public static void checkIfEmailIsValid (String email) {
		String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if (! Pattern.compile(pattern).matcher(email).matches()) {
			throw new InvalidEmailException("not in correct form 'name@example.com'");
		}
	}
	
	public static void checkIfPasswordIsValid (String password) {
		Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
		Pattern lowerCasePatten = Pattern.compile("[a-z ]");
		Pattern digitCasePatten = Pattern.compile("[0-9 ]");
		
		if (password == null) {
			throw new InvalidPasswordException("empty");
		}
		if (password.length() < 8) {
			throw new InvalidPasswordException("less then 8 characters");
		}
		if (! UpperCasePatten.matcher(password).find()) {
			throw new InvalidPasswordException("no uppercase character");
		}
		if (! lowerCasePatten.matcher(password).find()) {
			throw new InvalidPasswordException("no lowercase character");
		}
		if (! digitCasePatten.matcher(password).find()) {
			throw new InvalidPasswordException("no number");
		}
	}
}
