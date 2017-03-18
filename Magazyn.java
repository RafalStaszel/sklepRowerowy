import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Magazyn {

	Rowery rower1 = new Rowery("Merida", "Lite901", 56, 2500, 3299.99);
	Rowery rower2 = new Rowery("Kands", "Maestro", 28, 900, 1199.99);
	Rowery rower3 = new Rowery("Author", "A5500", 62, 3500, 4499.99);
	ArrayList<Rowery> rowery = new ArrayList<>();

	public void wstawRowery() {

	
	rowery.add(rower1);
	rowery.add(rower2);
	rowery.add(rower3);
	
	
	}


	
	
	public String stackPokazRowery(){
		//String wyslijSO
		String wyslijSO = rowery.stream().map(Object::toString)
                .collect(Collectors.joining(", \n"));
		return wyslijSO;
		
	}
		
	/*	public void pokazRowery2(){
		
		String str = Arrays.toString(rowery.toArray());
		System.out.println(str);
		System.out.println(rowery.get(1).toString());*/
	}

	/*public String pokazRowery() {
		
			return	"Model - " + rower1.getMarka() + " Marka - " + rower1.getModel() + " rozmiar = " + rower1.getRozmiar()
						+ "\nCena zakupu = " + rower1.getCenaZ() + " Cena sprzeda¿y = " + rower1.getCenaS();
	}

	public void pokazRowerJeden(Rowery rower1) {
		System.out.println(
				"Model - " + rower1.getMarka() + " Marka - " + rower1.getModel() + " rozmiar = " + rower1.getRozmiar()
						+ "\nCena zakupu = " + rower1.getCenaZ() + " Cena sprzeda¿y = " + rower1.getCenaS());
	}*/

