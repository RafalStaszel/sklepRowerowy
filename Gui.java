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
	private JMenu jmPlik, jmOprogramie;
	private JMenuItem mZapis, mWyjscie, mOdczyt, mOdczytZKlasy;
	private JTextArea textArea;
	JButton btnRowery, btnCzysc;
	Magazyn magazyn = new Magazyn();
	

	public Gui() {
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
		mZapis.addActionListener(this);

		mOdczyt = new JMenuItem("Odczyt");
		jmPlik.add(mOdczyt);
		mOdczyt.addActionListener(this);

		mOdczytZKlasy = new JMenuItem("Odczyt z klasy");
		jmPlik.add(mOdczytZKlasy);
		mOdczytZKlasy.addActionListener(this);

		mWyjscie = new JMenuItem("Wyjscie");
		jmPlik.addSeparator();
		jmPlik.add(mWyjscie);

		btnRowery = new JButton("Rowery");
		btnRowery.setBounds(10, 60, 100, 20);
		frame.getContentPane().add(btnRowery);
		btnRowery.addActionListener(this);
		
		btnCzysc = new JButton("Wyczyœæ");
		btnCzysc.setBounds(200, 60, 100, 20);
		frame.getContentPane().add(btnCzysc);
		btnCzysc.addActionListener(this);

		textArea = new JTextArea();
		textArea.setBounds(50, 300, 800, 300);
		frame.getContentPane().add(textArea);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ae = e.getSource();
		if (ae == btnRowery) {
			textArea.setText("");
			textArea.append(magazyn.stackPokazRowery());

		} else if (ae == mZapis) {
			magazyn.zapis();
		} else if (ae == mOdczyt) {
			magazyn.wstawRowery();
		} else if (ae == mOdczytZKlasy){;
		magazyn.odczytZKlasy();
	}
	else if(ae==btnCzysc){
		textArea.setText(" ");
	}
}
}
