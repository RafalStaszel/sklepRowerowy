package paczka.glowna;
import java.io.Serializable;

public class Rowery implements Serializable{
	
	private String marka;
	private String model;
	private int rozmiar;
	private double cenaZ;
	private double cenaS;
	private static int licznik = 0;
	
	public Rowery(String marka, String model, int rozmiar, double cenaZ, double cenaS) {
		this.marka = marka;
		this.model = model;
		this.rozmiar = rozmiar;
		this.cenaZ = cenaZ;
		this.cenaS = cenaS;
		++licznik;
		
		
	}

	
	
	public static int getLicznik() {
		return licznik;
	}



	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRozmiar() {
		return rozmiar;
	}
	public void setRozmiar(int rozmiar) {
		this.rozmiar = rozmiar;
	}
	public double getCenaS() {
		return cenaS;
	}
	public void setCenaS(double cenaS) {
		this.cenaS = cenaS;
	}
	public double getCenaZ() {
		return cenaZ;
	}
	public void setCenaZ(double cenaZ) {
		this.cenaZ = cenaZ;
	}
	
	@Override
	public String toString() {
		return  "Rowery marka = " + marka + ", model = " + model + ", rozmiar = " + rozmiar + ", cenaZ = " + cenaZ + ", cenaS = "
				+ cenaS ;
	}
	
	

}
