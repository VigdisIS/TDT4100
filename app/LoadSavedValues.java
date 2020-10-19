package app2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class LoadSavedValues implements Lagring {

	public void writeToFile(String filNavn, PetNumber progBarVerdi){
		try (FileWriter f = new FileWriter(filNavn, true);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);) {
			p.println(String.valueOf(progBarVerdi.getNumber()));
			System.out.println(String.valueOf(progBarVerdi.getNumber()) + " lagret.");
		} catch (IOException i) { 
			i.printStackTrace(); 
			}
	}

	@Override
	public String readFromFile(String filNavn, PetNumber progBarVerdi) {
		
		String results = "";
		
		try 
		{
			File openFile = new File(filNavn);
			Scanner fileScanner = new Scanner(openFile);
			
			String currentLine = fileScanner.nextLine();
			while(fileScanner.hasNextLine()) {
				results+= currentLine + "\n";
				currentLine = fileScanner.nextLine();
			}
			results += currentLine + "\n";
			fileScanner.close();
			
		}
		catch(IOException error) {
			error.printStackTrace(); 
			System.exit(1);
		}
		System.out.println("Loaded values: \n"+ results);
		return results;
		
		
	}

}
