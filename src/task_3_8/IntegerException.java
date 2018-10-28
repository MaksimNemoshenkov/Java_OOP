package task_3_8;

public class IntegerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5163973724908316273L;

	public IntegerException(String mesage) {
		super(mesage);
	}
	@Override
	public String getMessage() {
		return "IntegerException: " + super.getMessage();
	}
}
