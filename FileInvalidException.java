/**
 * Kennan Hoa (27199112) COMP 249 Assignment 3 Due November 9th, 2018
 */

//---------------------------------------------------------------
//Assignment 3
//Written by: Kennan Hoa (27199112)
//---------------------------------------------------------------

public class FileInvalidException extends Exception {

	/**
	 * FileInvalidExeption default constructor
	 */
	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information\n" + "(i.e. month={}, title={}, etc.) ");
	}

	/**
	 * FileInvalidException parameterized constructor
	 * 
	 * @param s a String value
	 */
	public FileInvalidException(String s) {
		super(s);
	}

	/**
	 * FileInvalidException message
	 */
	public String getMessage() {
		return (super.getMessage());
	}

}
