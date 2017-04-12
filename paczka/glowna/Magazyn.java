package paczka.glowna;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Magazyn {

	Rowery rower1; // do usuniecia
	Rowery rower2; // do usuniecia
	Rowery rower3; // do usuniecia
	static ArrayList<Rowery> roweryL = new ArrayList<>();
	OknoWprowadzaniaRoweru nwR = new OknoWprowadzaniaRoweru();

	File plik = new File("dane.dll");

	public void wstawRowery() {
		try (FileInputStream fis = new FileInputStream(plik)) {
			ObjectInputStream ois = new ObjectInputStream(fis);

			roweryL = (ArrayList<Rowery>) ois.readObject();

			Iterator<Rowery> iterator = roweryL.iterator();
			while (iterator.hasNext())
				System.out.print(iterator.next().toString() + " \n");
			System.out.println("Ilosc rowerów w arrayu - " + roweryL.size());

			ois.close();

		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Doczytac co to IO Exception");
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Tutaj problem");
			// e.printStackTrace();

		}
	}

	public void odczytZKlasy() {
		Rowery rower1 = new Rowery("Merida", "Lite901", 56, 2500, 3299.99);
		Rowery rower2 = new Rowery("Kands", "Maestro", 28, 900, 1199.99);
		Rowery rower3 = new Rowery("Author", "A5500", 62, 3500, 4499.99);
		roweryL.add(rower1);
		roweryL.add(rower2);
		roweryL.add(rower3);
	}

	public String stackPokazRowery() {

		String wyslijSO = "\n" + roweryL.stream().map(Object::toString).collect(Collectors.joining(", \n"));
		return wyslijSO;
	}

	public void zapis() {
		try (FileOutputStream fos = new FileOutputStream(plik)) {
			ObjectOutputStream obs = new ObjectOutputStream(fos);

			obs.writeObject(roweryL);

			obs.close();

			System.out.println("Zapis");

		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Doczytac co to IO Exception");
			e.printStackTrace();
		}

	}

	public void usunRower(int i) {

		roweryL.remove(i);
	}

	public void dodajRower() {

		System.out.println("Lista rowerow to " + roweryL.size());
		roweryL.add(nwR.getRowerX());

		System.out.println("Lista rowerow to " + roweryL.size());
	}

	public void dodajRower2(String inputValue) {

		String[] pociety = inputValue.split(" ");
		String marka = pociety[0];
		String model = pociety[1];
		int rozmiar = Integer.valueOf(pociety[2]);
		double cenaZ = Double.valueOf(pociety[3]);
		double cenaS = Double.parseDouble(pociety[4].replaceAll(",", "."));
		roweryL.add(new Rowery(marka, model, rozmiar, cenaZ, cenaS));

	}

}
