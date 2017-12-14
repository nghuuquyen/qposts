package exceptions;

public class DAOException extends Exception {
	private static final long serialVersionUID = 1L;
	private int code = 5001;
	
	public int getCode() {
		return code;
	}
	
	public DAOException(String message) {
		super(message);
	}
}
