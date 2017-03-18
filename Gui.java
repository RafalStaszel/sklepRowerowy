import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Gui extends JFrame implements ActionListener {
	
	

	private JFrame frame;
	private JMenuBar jmenu;
	private JMenu jmPlik,jmOprogramie;
	private JMenuItem mZapis,mWyjscie;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
/*	public Gui() {
		initialize();
	}*/

	
	public Gui(){
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		jmenu = new JMenuBar();
		frame.setJMenuBar(jmenu);
		
		jmPlik = new JMenu("Plik");
		jmenu.add(jmPlik);
		
		mZapis = new JMenuItem("Zapis");
		jmPlik.add(mZapis);
		
		mWyjscie = new JMenuItem("Wyjscie");
		jmPlik.addSeparator();
		jmPlik.add(mWyjscie);
		
		JButton btnRowery = new JButton("Rowery");
		btnRowery.setBounds(10, 60, 100, 20);
		frame.getContentPane().add(btnRowery);
		btnRowery.addActionListener(this);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 300, 800, 300);
		frame.getContentPane().add(textArea);
		
		
		
		
		Magazyn magazyn = new Magazyn();
		magazyn.wstawRowery();
		textArea.append(magazyn.stackPokazRowery());
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ae = e.getSource();
		
		
	}
}
