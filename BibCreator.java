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
 * Import the necessary java libraries
 */
import java.util.Scanner;
import java.io.*;

public class BibCreator {
	public static boolean doneCount = false;

	/**
	 * Main method that will execute the reading of the file, check whether a file
	 * is valid or not, that will convert the files to the IEEE, ACM and NJ
	 * respectively, and review a file as chosen by the user
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String[] Files = { "Latex1.bib", "Latex2.bib", "Latex3.bib", "Latex4.bib", "Latex5.bib", "Latex6.bib",
				"Latex7.bib", "Latex8.bib", "Latex9.bib", "Latex10.bib" };
		Scanner sc = null;
		PrintWriter pwIEEE = null;
		PrintWriter pwACM = null;
		PrintWriter pwNJ = null;
		Scanner key = new Scanner(System.in);
		BufferedReader bf = null;

//Welcome message
//---------------
		System.out.println(
				"---------------------------\n" + "Welcome to the BibCreator\n" + "---------------------------\n");

//To read the files:
//------------------		
		for (int i = 0; i < Files.length; i++) {
			try {
				sc = new Scanner(new FileInputStream(Files[i]));
			} catch (FileNotFoundException e) {
				System.out.println("Could not open input file " + Files[i] + " for reading.\n"
						+ "Please check if file exists! Program will termindate after closing " + " any opened files");
				sc.close();
			}
			sc.close();

			try {
				pwIEEE = new PrintWriter(new FileOutputStream("IEEE" + (i + 1) + ".json"));
				pwACM = new PrintWriter(new FileOutputStream("ACM" + (i + 1) + ".json"));
				pwNJ = new PrintWriter(new FileOutputStream("NJ" + (i + 1) + ".json"));
			} catch (FileNotFoundException e) {
				System.out.println("Could not open/create the" + Files[i] + ".\n"
						+ "Program will termindate after closing any opened files.");
				/*
				 * File file1 = new File("IEEE" + (i + 1) + ".json"); File file2 = new
				 * File("ACM" + (i + 1) + ".json"); File file3 = new File("NJ" + (i + 1) +
				 * ".json"); file1.delete(); file2.delete(); file3.delete();
				 */
				sc.close();
				// System.exit(0);
			}
			pwIEEE.close();
			pwACM.close();
			pwNJ.close();
		}

//To check whether a file is valid or not
//----------------------------------------
		for (int i = 1; i <= Files.length; i++) {
			processFilesForValidation.procesFilesForValidation(i, sc);
			doneCount = true;
		}

		System.out.println("A total of " + processFilesForValidation.InvalidFiles
				+ " files were invalid, and could not be processed. " + "All other "
				+ (10 - processFilesForValidation.InvalidFiles) + " valid files have been created.");
		System.out.println();

//Review a file chosen by the user
//--------------------------------
		System.out.println("Please enter the name of one of the files that you need to review: ");
		String str = key.next();
		try {
			bf = new BufferedReader(new FileReader(str));
		} catch (FileNotFoundException e) {
			System.out.println("Could not open input file. File does not exist; possibly it could not be created!");
			System.out.println("\n" + "However, you will be allowed another chance to enter another file name.");
			System.out.println("Please enter the name of one of the files that you need to review: ");
			str = key.next();
			try {
				bf = new BufferedReader(new FileReader(str));

			} catch (FileNotFoundException e1) {
				System.out.println(
						"\n" + "Could not open input file. File does not exist; possibly it could not be created!");
				System.out.println("Sorry! I am unable to display your desired files! Program will exit");
				System.exit(0);
			}
		}

		try {
			FileContents.DisplayFileContents(str, bf);
		} catch (IOException e) {
			System.out.println("Error: An error has occurred while reading from the " + str + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);
		}
//Closing message
//---------------
		finally {
			System.out.println("\n" + "Goodbye! Hope you have enjoyed creating the needed files using BibCreator.");
		}

	}

}
