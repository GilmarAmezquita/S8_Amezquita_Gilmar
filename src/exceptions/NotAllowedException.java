package exceptions;

public class NotAllowedException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotAllowedException() {
		super("The day does not match the penultimate number of the ID");
	}
}
