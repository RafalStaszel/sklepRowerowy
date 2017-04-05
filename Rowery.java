import java.io.Serializable;

public class Rowery implements Serializable{
	private String marka;
	private String model;
	private int rozmiar;
	private double cenaZ;
	private double cenaS;
	public Rowery(String string, String string2, int i, double j, double k) {
		this.marka = string;
		this.model = string2;
		this.rozmiar = i;
		this.cenaZ = j;
		this.cenaS = k;
		
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
