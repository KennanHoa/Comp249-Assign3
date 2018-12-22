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
 * Import the necessary java library
 */
import java.io.PrintWriter;

public class NJCreator {

	boolean done = false;
	static String completeLine1 = "";
	static String completeLine2 = "";
	static String completeLine3 = "";
	static String completeLine4 = "";
	static String completeLine5 = "";
	static String completeLine6 = "";

	/**
	 * Method to convert the text file into a binary file of style NJ
	 * 
	 * @param Line a String value
	 * @param pwNj a PrintWriter
	 */
	public static void CreateNJ(String Line, PrintWriter pwNj) {
		String author2 = "";
		String journal2 = "";
		String title2 = "";
		String year2 = "";
		String volume2 = "";
		// String number2 = "";
		String pages2 = "";
		// String keywords2 = "";
		// String doi2 = "";
		// String ISSN2 = "";
		// String month2 = "";
		boolean flag = false;

		String[] SplitLine1 = Line.split("=");
		if (SplitLine1[0].contains("author")) {

			String[] SplitLine2 = SplitLine1[1].split(" ");
			for (int j = 0; j < SplitLine2.length; j++) {

				if (SplitLine2[j].contains("{")) {
					author2 += SplitLine2[j].replace("{", "");
				} else if (SplitLine2[j].contains("and")) {
					author2 += SplitLine2[j].replace("and", "&");
				} else if (SplitLine2[j].contains("},")) {
					author2 += SplitLine2[j].replace("},", ".");
				} else {
					author2 += SplitLine2[j];
				}
				author2 += " ";
			}

			completeLine1 = author2;
		} else if (SplitLine1[0].contains("title")) {
			String[] SplitLine2 = SplitLine1[1].split(" ");
			for (int j = 0; j < SplitLine2.length; j++) {
				if (SplitLine2[j].contains("{")) {
					title2 += SplitLine2[j].replace("{", "");
				} else if (SplitLine2[j].contains("},")) {
					title2 += SplitLine2[j].replace("},", ".");
				} else {
					title2 += SplitLine2[j];
				}
				title2 += " ";
			}
			completeLine2 = title2;
		} else if (SplitLine1[0].contains("journal")) {
			String[] SplitLine2 = SplitLine1[1].split(" ");
			for (int j = 0; j < SplitLine2.length; j++) {
				if (SplitLine2[j].contains("{")) {
					journal2 += SplitLine2[j].replace("{", "");
				} else if (SplitLine2[j].contains("},")) {
					journal2 += SplitLine2[j].replace("},", ".");
				} else {
					journal2 += SplitLine2[j];
				}
				journal2 += " ";
			}
			completeLine3 = journal2;
		} else if (SplitLine1[0].contains("volume")) {
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					volume2 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					volume2 += ",";
				}
			}
			completeLine4 = volume2;
		} else if (SplitLine1[0].contains("pages")) {
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					pages2 += SplitLine1[1].charAt(j);
				}
			}
			completeLine5 = pages2;
			flag = true;
		}

		else if (SplitLine1[0].contains("year")) {
			for (int j = 0; j < SplitLine1[1].length(); j++) {
				if (!(SplitLine1[1].charAt(j) == '{' || SplitLine1[1].charAt(j) == '}'
						|| SplitLine1[1].charAt(j) == ',')) {
					year2 += SplitLine1[1].charAt(j);
				} else if (SplitLine1[1].charAt(j) == ',') {
					year2 = "(" + year2 + ").";
				}
			}
			completeLine6 = year2 + "\n\n";

		}

		if (flag) {
			pwNj.print(completeLine1 + completeLine2 + completeLine3 + completeLine4 + completeLine5 + completeLine6);
			flag = false;
			completeLine1 = "";
			completeLine2 = "";
			completeLine3 = "";
			completeLine4 = "";
			completeLine5 = "";
			completeLine6 = "";
		}
	}
}
