import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Magazyn {

	Rowery rower1;
	Rowery rower2;
	Rowery rower3;
	ArrayList<Rowery> rowery = new ArrayList<>();

	File plik = new File("plik.txt");

	public void wstawRowery() {
		try (FileInputStream fis = new FileInputStream(plik)) {
			ObjectInputStream ois = new ObjectInputStream(fis);

			
			rowery = (ArrayList<Rowery>) ois.readObject();
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
		rowery.add(rower1);
		rowery.add(rower2);
		rowery.add(rower3);
	}

	public String stackPokazRowery() {

		String wyslijSO = rowery.stream().map(Object::toString).collect(Collectors.joining(", \n"));
		return wyslijSO;
	}

	public void zapis() {
		try (FileOutputStream fos = new FileOutputStream(plik)) {
			ObjectOutputStream obs = new ObjectOutputStream(fos);

			obs.writeObject(rowery);

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
}
