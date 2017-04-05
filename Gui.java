
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Gui extends JFrame implements ActionListener {

	private JFrame frame;
	private JMenuBar jmenu;
	private JMenu jmPlik, jmOprogramie;
	private JMenuItem mZapis, mWyjscie, mOdczyt, mOdczytZKlasy;
	private JTextArea textArea;
	private JComboBox kolorKombo;
	private JButton btnRowery, btnCzysc, btnNowyRower, btnUsunRower, btnNowyRower2;

	public Gui() {
		initializeGUI();
	}

	private void initializeGUI() {

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Sklep Rowerowy");

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

		btnNowyRower = new JButton("Nowy Rower");
		btnNowyRower.setBounds(400, 60, 150, 20);
		frame.getContentPane().add(btnNowyRower);
		btnNowyRower.addActionListener(this);
		
		btnNowyRower2 = new JButton("Nowy Rower ver 2");
		btnNowyRower2.setBounds(400, 90, 150, 20);
		frame.getContentPane().add(btnNowyRower2);
		btnNowyRower2.addActionListener(this);
		
		btnUsunRower = new JButton("Usuñ rower");
		btnUsunRower.setBounds(600, 60, 150, 20);
		frame.getContentPane().add(btnUsunRower);
		btnUsunRower.addActionListener(this);

		textArea = new JTextArea();
		textArea.setBounds(50, 200, 800, 300);
		frame.getContentPane().add(textArea);

		kolorKombo = new JComboBox();
		kolorKombo.setBounds(750, 10, 100, 20);
		frame.getContentPane().add(kolorKombo);
		kolorKombo.addItem("Metal");
		kolorKombo.addItem("Nimbus");
		kolorKombo.addItem("Windows");
		kolorKombo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Magazyn magazyn = new Magazyn();
		Object ae = e.getSource();
		if (ae == btnRowery) {
			textArea.append(magazyn.stackPokazRowery());
		} else if (ae == mZapis) {
			magazyn.zapis();
		} else if (ae == mOdczyt) {
			magazyn.wstawRowery();
		} else if (ae == mOdczytZKlasy) {
			;
			magazyn.odczytZKlasy();
		} else if (ae == btnCzysc) {
			textArea.setText(" ");
		} else if (ae == kolorKombo) {
			String kolor = kolorKombo.getSelectedItem().toString();
			if (kolor.equals("Metal")) {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException eX) {

					eX.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
			} else if (kolor.equals("Nimbus")) {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException eX) {

					eX.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
			} else if (kolor.equals("Windows")) {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException eX) {

					eX.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
			}

		} else if (ae == btnNowyRower) {
			OknoWprowadzaniaRoweru nw = new OknoWprowadzaniaRoweru();
			nw.noweOkno();

		}
		
		else if (ae == btnNowyRower2) {
			String inputValue = JOptionPane.showInputDialog(frame, "Wpisz rower: Marka model rozmiar cenaZ cenaS");
			magazyn.dodajRower2(inputValue);

		}
		else if (ae == btnUsunRower ) {
			String inputValue = JOptionPane.showInputDialog(frame, "Jaki rower usunac?");
			System.out.println(inputValue);
			int i = Integer.parseInt(inputValue)-1;
			
			magazyn.usunRower(i);
		}
	}

	public void sterujaca() {
		OknoWprowadzaniaRoweru nw = new OknoWprowadzaniaRoweru();
		Magazyn magazyn = new Magazyn();

		magazyn.dodajRower();

	}

}
