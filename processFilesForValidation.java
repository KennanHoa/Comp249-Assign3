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
 * Import of all necessary java libraries
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

public class processFilesForValidation {
	
	public static int InvalidFiles = 0;
	
	/**
	 * Method to check whether a file is valid or not. If not, it shall be deleted. 
	 * @param i an integer value
	 * @param sc a Scanner
	 */
	public static void  procesFilesForValidation(int i, Scanner sc) {
		int count = 0;
		String Line;
		PrintWriter pwIEEE = null;
		PrintWriter pwACM = null;
		PrintWriter pwNJ = null;
		
//Creating all three types of files (i.e.: IEEE, ACM, NJ) for each text file
//---------------------------------------------------------------------------
		try { 
			sc = new Scanner(new FileInputStream("Latex"+ i+ ".bib"));
			pwIEEE = new PrintWriter(new FileOutputStream("IEEE"+i+".json"));
			pwACM = new PrintWriter(new FileOutputStream("ACM"+i+".json"));
			pwNJ = new PrintWriter(new FileOutputStream("NJ"+i+".json"));	
			File file1 = new File("IEEE"+i+".json");
			File file2 = new File("ACM"+i+".json");
			File file3 = new File("NJ"+i+".json");
		
//Checking whether a file has an empty field (i.e.: the file is invalid)
//----------------------------------------------------------------------
		while (sc.hasNextLine()) {
			Line = sc.nextLine();
			if (Line.contains("author={}, ")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				
				throw new FileInvalidException("File is Invalide: Field \"author\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if(Line.contains("journal={}, ")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"journal\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if (Line.contains("title={}, ")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"title\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if (Line.contains("year={}, ")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"year\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if (Line.contains("volume={}, ")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"volume\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if (Line.contains("number={}, ")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"number\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if (Line.contains("pages={}," )) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"pages\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if (Line.contains("keywords={}, ")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"keywords\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if (Line.contains("doi={}, ")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"doi\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if (Line.contains("ISSN={},")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"ISSN\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else if (Line.contains("month={},")) {
				InvalidFiles++;
				sc.close();
				pwIEEE.close();
				pwACM.close();
				pwNJ.close();
				file1.delete();
				file2.delete();
				file3.delete();
				throw new FileInvalidException("File is Invalide: Field \"month\" is Empty. Processing stopped" + " at this point. Other empty fields may be present as well!");
			}
			else {
					IEEECreator.CreateIEEE(Line, pwIEEE);
					NJCreator.CreateNJ(Line, pwNJ);
					ACMCreator.CreateACM(Line, pwACM);
			}
		}
		
		sc.close();
		pwIEEE.close();
		pwACM.close();
		pwNJ.close();
		
		}
		
//If the file is invalid, then delete the three types 
//of binary files of the respective invalid file
//---------------------------------------------------
		catch (FileInvalidException s) {
			System.out.println("Error: Detected Empty Field!");
			System.out.println("============================");
			System.out.println();
			System.out.println("Problem detected with input file: Latex" +i +".bib");
			System.out.println(s.getMessage());
			
			
			
			System.out.println();
			}
		catch (FileNotFoundException e) {
			System.out.println("Could not open input file " + "Latex"+ i+ ".bib" + " for reading.\n" +
					"Please check if file exists! Program will termindate after closing " +
					" any opened files");
			}
		sc.close();
		pwIEEE.close();
		pwACM.close();
		pwNJ.close();
		
	}
}

