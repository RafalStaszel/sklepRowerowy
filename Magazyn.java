
public class Magazyn {

	Rowery rower1 = new Rowery("Merida", "Lite901", 56, 2500, 3299.99);
	Rowery rower2 = new Rowery("Kands", "Maestro", 28, 900, 1199.99);
	Rowery rower3 = new Rowery("Author", "A5500", 62, 3500, 4499.99);

	public void wstawRowery() {

		Magazyn magazyn = new Magazyn();
		magazyn.pokazRowery(rower1);
		magazyn.pokazRowery(rower2);
		magazyn.pokazRowery(rower3);
	}

	public void wyborRoweru(int i) {
		Magazyn magazyn = new Magazyn();
		switch (i) {
		case 1:
			magazyn.pokazRowerJeden(rower1);
			break;
		case 2:
			magazyn.pokazRowerJeden(rower2);
			break;
		case 3:
			magazyn.pokazRowerJeden(rower3);
			break;
		/*defualt: 
				System.out.println("Nie wybrano nic");*/
		}
	}

	public void pokazRowery(Rowery rower1) {
		System.out.println(
				"Model - " + rower1.getMarka() + " Marka - " + rower1.getModel() + " rozmiar = " + rower1.getRozmiar()
						+ "\nCena zakupu = " + rower1.getCenaZ() + " Cena sprzeda¿y = " + rower1.getCenaS());
	}

	public void pokazRowerJeden(Rowery rower1) {
		System.out.println(
				"Model - " + rower1.getMarka() + " Marka - " + rower1.getModel() + " rozmiar = " + rower1.getRozmiar()
						+ "\nCena zakupu = " + rower1.getCenaZ() + " Cena sprzeda¿y = " + rower1.getCenaS());
	}
}
