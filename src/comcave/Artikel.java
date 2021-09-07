package comcave;

import java.io.Serializable;

public class Artikel implements Serializable {
	
	private String bezeichnung;
	private double preis;
	
	public Artikel(String bezeichnung, double preis) {
		this.bezeichnung = bezeichnung;
		this.preis = preis;
	}
	
	
	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	
	public double getPreis() {
		return preis;
	}




	public void setPreis(double preis) {
		this.preis = preis;
	}
}
