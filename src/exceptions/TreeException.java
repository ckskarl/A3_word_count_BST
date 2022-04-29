package exceptions;

/**
 * Exception Handler related th the Tree structure
 * @author Brandon Donkersloot
 * @version 01/12/2021
 */
@SuppressWarnings("serial")
public class TreeException extends Exception  {
	
	public TreeException() {
		super();
	}
	
	
	/**
	 * 
	 * @param message error message specific to cause of error
	 */
	public TreeException (String message) {
		super(message);
	}

}
