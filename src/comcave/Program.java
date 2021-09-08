package comcave;


import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.RandomAccessFile;


public class Program {

	public static void main(String[] args) {
		textDateiSchreiben();
		binaerDateiSchreiben();		
		binaerDateiLesen();
		objekteSchreiben();
	}
	
	
	private static void objekteSchreiben() {
		//Serialisierung
		Artikel artikel = new Artikel("IPhone", 1200);
		ArrayList<Artikel> artikelListe = new ArrayList<Artikel>();
		artikelListe.add(artikel);
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("artikel.com"));
			oos.writeObject(artikel);
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
