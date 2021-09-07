package comcave;


import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Program {

	public static void main(String[] args) {
		textDateiSchreiben();

	}
	
	private static void textDateiSchreiben() {
		
		
		try {
			int[] arrayTest = {1,2,3};
			arrayTest[3] = 100;
			
			System.out.println("try ende");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("exception");
			
			
		}
//		catch(ArrayIndexOutOfBoundsException e1) {
//			System.out.println("Fehler");
//		}
//		catch(IOException e3) {
//
//		}
//		catch(FileNotFoudException e2) {
//		}

	
	
		try {
			
			// Datenstrom erzeugen, Datei öffnen
			FileWriter fw = new FileWriter("datei.txt"); 
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Daten mit Java geschrieben");
			bw.newLine();
			bw.write("die zweite Zeile Daten mit Java geschrieben");
			//Datei schließen
			bw.close();
			System.out.println("Daten gespeichert");
			}
		catch(Exception e) {
			System.out.println("Daten konnten nicht gespeichert werden");
		}
			
		}
		
	

}
