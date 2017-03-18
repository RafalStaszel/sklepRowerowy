import java.awt.EventQueue;
import java.util.Scanner;



public class Zaplecze {

	public static void main(String[] args) {
		
	

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui gui = new Gui();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
	
	
	
	}


