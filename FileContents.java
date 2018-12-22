/**
 * Kennan Hoa (27199112)
 * COMP 249
 * Assignment 3
 * Due November 9th, 2018
 */

//---------------------------------------------------------------
//Assignment 3
//Written by: Kennan Hoa (27199112)
//---------------------------------------------------------------

/**
 * Import the necessary java library
 */
import java.io.*;

public class FileContents {

	/**
	 * Method to display the contents of the user selected file
	 * 
	 * @param str a string value
	 * @param bf  a BufferReader
	 * @throws IOException an exception
	 */
	public static void DisplayFileContents(String str, BufferedReader bf) throws IOException {

		while ((str = bf.readLine()) != null) {
			System.out.println(str);
		}
		bf.close();
	}
}