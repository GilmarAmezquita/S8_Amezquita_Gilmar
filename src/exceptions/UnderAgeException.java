package exceptions;

public class UnderAgeException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UnderAgeException() {
		super("People who enter must be of legal age");
	}
}
