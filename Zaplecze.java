import java.util.Scanner;

public class Zaplecze {

	public static void main(String[] args) {
		Magazyn magazyn = new Magazyn();
	
Scanner odczyt = new Scanner(System.in);
System.out.println("Wpisz liczbe 1,2,3");
int wybor = odczyt.nextInt();
magazyn.wyborRoweru(wybor);
	}

}
