package exceptions;

/**
 * Exception Handler whenever the input argument format is invalid
 * @author Kin Shing Chong
 * @version 01/12/2021
 */
public class InvalidArgFormatException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Exception Handler whenever the input argument is missing one of the required fields (filepath, compare type or sort type)
	 * @param fileOutArgCount counting the valid file output argument number
	 * @param optionArgCount counting the valid compare argument input
	 * @param fileInputArgCount counting the valid file input argument number
	 */
	public InvalidArgFormatException(int fileOutArgCount,int optionArgCount,int fileInputArgCount) {
        System.out.println("Number of correct file input argument provided (expected 1): "+ fileInputArgCount);
        System.out.println("Number of correct option argument provided (expected 1): "+ optionArgCount);
        System.out.println("Number of correct file output argument provided (optional): "+ fileOutArgCount);
        System.out.println("Expected: 2(or 3) argumensts in any order, case insensitive, 1 for file input path, 1 for option. (optinal: 1 for file output path)");
	}
	
	/**
	 * Exception Handler whenever the input argument is not in the pool of accepted type
	 * @param optionType the option type input
	 */
	public InvalidArgFormatException(String optionType) {
        System.out.println("Incorrect type input!");
        System.out.println("Option Type input: "+ optionType);
        System.out.println("Allowed option: f, l or o");
    }
}