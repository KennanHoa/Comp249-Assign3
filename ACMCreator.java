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
 * Import all necessary libraries
 */
import java.io.*;
import java.util.Scanner;

public class ACMCreator {
	static int count = 1;
	static String completeLine111 = "";
	static String completeLine222 = "";
	static String completeLine333 = "";
	static String completeLine444 = "";
	static String completeLine555 = "";
	static String completeLine666 = "";
	static String completeLine777 = "";
	static String completeLine888 = "";

	/**
	 * Method to convert the text file into a binary file of style ACM
	 * 
	 * @param Line  a String value
	 * @param pwACM a PrintWriter
	 */
	public static void CreateACM(String Line, PrintWriter pwACM) {
		int countAuthor = 1;
		String author1 = "";
		String journal1 = "";
		String title1 = "";
		String year1 = "";
		String volume1 = "";
		String number1 = "";
		String pages1 = "";
		// String keywords1 = "";
		String doi1 = "";
		// String ISSN1 = "";
		// String month1 = "";
		boolean flag3 = false;
		String[] SplitLine1 = Line.split("=");

		if (SplitLine1[0].contains("author")) {
			String[] SplitLine2 = SplitLine1[1].split(" ");
			for (int i = 0; i < SplitLine2.length; i++) {
				author1 += " ";
				if (SplitLine2[i].contains("and"))
					countAuthor++;

				else if (!(SplitLine2[i].equals("and")) && countAuthor < 2) {
					if (SplitLine2[i].contains("{")) {
						author1 += SplitLine2[i].replace("{", "");
					} else if (SplitLine2[i].contains("}")) {
						author1 += SplitLine2[i].replace("}", "");
					} else if (SplitLine2[i].contains("")) {
						author1 += SplitLine2[i].replace("", "");
					} else {
						author1 += SplitLine2[i];
					}
				}

				if (countAuthor > 1) {
					author1 += "et al. ";
					break;
				}
			}
			completeLine111 = author1;
		}

		else if (SplitLine1[0].contains("year")) {
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					year1 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					break;
				}
			}
			completeLine222 = year1;
		} else if (SplitLine1[0].contains("title")) {
			String[] SplitLine2 = SplitLine1[1].split(" ");
			for (int j = 0; j < SplitLine2.length; j++) {
				title1 += " ";
				if (SplitLine2[j].contains("{")) {
					title1 += SplitLine2[j].replace("{", "");
				} else if (SplitLine2[j].contains("},")) {
					title1 += SplitLine2[j].replace("},", ".");
				} else {
					title1 += SplitLine2[j];
				}
			}
			completeLine333 = title1;
		} else if (SplitLine1[0].contains("journal")) {
			String[] SplitLine2 = SplitLine1[1].split(" ");
			for (int j = 0; j < SplitLine2.length; j++) {
				journal1 += " ";
				if (SplitLine2[j].contains("{")) {
					journal1 += SplitLine2[j].replace("{", "");
				} else if (SplitLine2[j].contains("},")) {
					journal1 += SplitLine2[j].replace("},", ". ");
				} else {
					journal1 += SplitLine2[j];
				}
			}
			completeLine444 = journal1;
		} else if (SplitLine1[0].contains("volume")) {
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					volume1 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					volume1 += ",";
				}
			}
			completeLine555 = volume1;

		} else if (SplitLine1[0].contains("number")) {
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					number1 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					number1 += "";
				}
			}
			completeLine666 = number1;
		} else if (SplitLine1[0].contains("pages")) {
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					pages1 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					pages1 += ".";
				}
			}
			completeLine777 = pages1;
		} else if (SplitLine1[0].contains("doi"))
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					doi1 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					doi1 += ".";
				}

				completeLine888 = doi1 + "\n\n";
				flag3 = true;
			}
		if (flag3) {
			if (BibCreator.doneCount) {
				count = 1;
				BibCreator.doneCount = false;
			}

			pwACM.print("[" + count + "]" + completeLine111 + completeLine222 + "." + completeLine333 + completeLine444
					+ completeLine555 + completeLine666 + "(" + completeLine222 + "), " + completeLine777
					+ "DOI:https://doi.org/" + completeLine888);
			count++;
			flag3 = false;
			completeLine111 = "";
			completeLine222 = "";
			completeLine333 = "";
			completeLine444 = "";
			completeLine555 = "";
			completeLine666 = "";
			completeLine777 = "";
			completeLine888 = "";
			countAuthor = 0;
		}

	}
}
