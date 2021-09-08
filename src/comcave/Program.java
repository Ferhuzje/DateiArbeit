package comcave;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;


public class Program {

	public static void main(String[] args) {
		textDateiSchreiben();
	 	textDateiLesen();
 		binaerDateiSchreiben();		
 		binaerDateiLesen();
 		objekteSchreiben();
 		objekteLesen();
 		csvSchreiben();
 		csvLesen();
 		fileKlasse();
		
	}
	
	private static void fileKlasse() {
		
		File file = new File("verzeichnis\\dateiname.txt");
		File dir = new File("verzeichnis");
		
	 	try {
		 		if(dir.mkdir()) {
		 			file.createNewFile();
		 			System.out.println("file erstellt");
	 		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("existiert ja/nein: " + file.exists());
		System.out.println("ist das eine Datei? " + file.isFile());
		System.out.println("ist ein Verzeichnis? " + dir.isDirectory());
		
		
		// aktuelles Verzeichnis ermitteln
		File datei = new File("virtual.txt");
		System.out.println(datei.getAbsolutePath());
		File datei2 = new File(datei.getAbsolutePath());
		System.out.println( datei2.getParent() );
	}
	
	
	
	private static void csvLesen() {
		try { 
			BufferedReader br = new BufferedReader(new FileReader("kunden.csv"));
			String zeile = "";
			while ( ( zeile = br.readLine()) != null ) {
				String[] kunden = zeile.split(",");
				for(String daten : kunden) {
					System.out.println(daten);
				}
				System.out.println("");
			}
			br.close();
		}
		catch (Exception e) {
			System.out.println("Fehler beim Lesen der CSV-Datei");
		}
	}
	
	
	private static void csvSchreiben() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("kunden.csv"));
			bw.write("Mathilde,Mustermann,1234657987\n");
			bw.write("Maxi,Musterfrau,669741\n");
			bw.close();
		}
		catch (Exception e) {
			System.out.println("Fehler beim csv schreiben");
		}
	}
	
	private static void objekteLesen() {
		ArrayList<Artikel> liste = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("artikel.com"));
			liste = (ArrayList<Artikel>)ois.readObject();
			ois.close();
		}
		catch (Exception e) {
			System.out.println("Kann Artikel Daten nicht einlesen");
		}
		
	}
	
	private static void objekteSchreiben() {
		//Serialisierung
		Artikel artikel = new Artikel("IPhone", 1200);
		ArrayList<Artikel> artikelListe = new ArrayList<Artikel>();
		artikelListe.add(artikel);
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("artikel.com"));
			oos.writeObject(artikelListe);
			oos.close();
		} catch (IOException e) {
			System.out.println("Datei Fehler");			
		}
		
	}
	
	private static void binaerDateiLesen() {
	
		try {
			RandomAccessFile file = new RandomAccessFile("binaerdatei.bin", "r");
			System.out.println( file.readInt() );
			System.out.println( file.readDouble());
			System.out.println( file.readBoolean());
			System.out.println( file.readUTF() ) ;
			file.close();
		}
		catch (IOException e) {
			System.out.println("Kann Datei nicht lesen");
		}
	}
		
	private static void binaerDateiSchreiben() {
		int i = 100;
		double d = 99.99;
		boolean b = true;
		String s = "Java";
		
		try {
			RandomAccessFile file = new RandomAccessFile("binaerdatei.bin", "rw");
			file.writeInt(i);
			file.writeDouble(d);
			file.writeBoolean(b);;
			file.writeUTF(s);
			file.close();
			System.out.println("Schreibvorgang fertig");
			} 
		catch (IOException e) {
			System.out.println("Datei - Fehler");
		}
	}
	
	private static void textDateiLesen() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("datei.txt"));
			String zeile;
			while((zeile = br.readLine()) != null ) {
				System.out.println(zeile);
			}
		}
		catch (IOException e) {
			System.out.println("Datei konnte nicht gelesen werden.");
		}
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
//		catch(FileNotFoudException e) {
//		e.printStackTrace();
			
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
		//fängt _alle_ Fehler ab
		catch(Exception e) {
			System.out.println("Daten konnten nicht gespeichert werden");
		}
			
	}
}
