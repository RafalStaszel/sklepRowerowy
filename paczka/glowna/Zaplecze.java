package paczka.glowna;
import java.awt.EventQueue;




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


