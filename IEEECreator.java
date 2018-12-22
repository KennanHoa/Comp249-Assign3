/**
 * Kennan Hoa (27199112)
 * COMP 249
 * Assignment 3
 * Due November 9th, 2018
 */

//---------------------------------------------------------------
//Assignment 3
//Part I
//Written by: Kennan Hoa (27199112)
//---------------------------------------------------------------

/**
 * Import the necessary java libraries
 */
import java.io.*;
import java.util.Scanner;

public class IEEECreator {
	public static int count = 0;
	static String completeLine11 = "";
	static String completeLine22 = "";
	static String completeLine33 = "";
	static String completeLine44 = "";
	static String completeLine55 = "";
	static String completeLine66 = "";
	static String completeLine77 = "";
	static String completeLine88 = "";

	/**
	 * Method to convert the text file into a binary file of style IEEE
	 * 
	 * @param Line   a String value
	 * @param pwIEEE a PrintWriter
	 */
	public static void CreateIEEE(String Line, PrintWriter pwIEEE) {
		String author1 = "";
		String journal1 = "";
		String title1 = "";
		String year1 = "";
		String volume1 = "";
		String number1 = "";
		String pages1 = "";
		//String keywords1 = "";
		//String doi1 = "";
		//String ISSN1 = "";
		String month1 = "";
		boolean flag1 = false;
		String[] SplitLine1 = Line.split("=");

//For the author:
		if (SplitLine1[0].contains("author")) {
			String[] SplitLine2 = SplitLine1[1].split(" ");
			for (int j = 0; j < SplitLine2.length; j++) {
				author1 += " ";

				if (SplitLine2[j].contains("{")) {
					author1 += SplitLine2[j].replace("{", "");
				} else if (SplitLine2[j].contains(" and ")) {
					author1 += SplitLine2[j].replace(" and ", ",");
				} else if (SplitLine2[j].contains("},")) {
					author1 += SplitLine2[j].replace("},", ".");
				}

				else {

					author1 += SplitLine2[j];
				}

			}
			completeLine11 = author1;

		} else if (SplitLine1[0].contains("title")) {
			String[] SplitLine2 = SplitLine1[1].split(" ");
			for (int j = 0; j < SplitLine2.length; j++) {
				title1 += " ";
				if (SplitLine2[j].contains("{")) {
					title1 += SplitLine2[j].replace("{", "\"");
				} else if (SplitLine2[j].contains("},")) {
					title1 += SplitLine2[j].replace("},", "\",");
				} else {
					title1 += SplitLine2[j];

				}
			}
			completeLine22 = title1;
		} else if (SplitLine1[0].contains("journal")) {
			String[] SplitLine2 = SplitLine1[1].split(" ");
			for (int j = 0; j < SplitLine2.length; j++) {
				journal1 += " ";
				if (SplitLine2[j].contains("{")) {
					journal1 += SplitLine2[j].replace("{", "");
				} else if (SplitLine2[j].contains("},")) {
					journal1 += SplitLine2[j].replace("},", ", ");
				} else {
					journal1 += SplitLine2[j];
				}
			}
			completeLine33 = journal1;
		}

		else if (SplitLine1[0].contains("volume")) {
			volume1 += "vol. ";
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					volume1 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					volume1 += ",";
				}
			}
			completeLine44 = volume1;

		}

		else if (SplitLine1[0].contains("number")) {
			number1 += " no. ";
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					number1 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					number1 += ",";
				}
			}
			completeLine55 = number1;
		} else if (SplitLine1[0].contains("pages")) {
			pages1 += "p. ";
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					pages1 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					pages1 += ",";
				}
			}
			completeLine66 = pages1;

		} else if (SplitLine1[0].contains("month")) {
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					month1 += SplitLine1[1].charAt(j);
				}
			}
			completeLine77 = month1;
			flag1 = true;
		} else if (SplitLine1[0].contains("year")) {
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					year1 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					year1 += ".";

				}
			}
			completeLine88 = year1 + "\n\n";

		}

		if (flag1) {
			pwIEEE.print(completeLine11 + completeLine22 + completeLine33 + completeLine44 + completeLine55
					+ completeLine66 + completeLine77 + " " + completeLine88);
			flag1 = false;
			completeLine11 = "";
			completeLine22 = "";
			completeLine33 = "";
			completeLine44 = "";
			completeLine55 = "";
			completeLine66 = "";
			completeLine77 = "";
			completeLine88 = "";

		}
	}
}