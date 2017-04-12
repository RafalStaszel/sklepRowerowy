package paczka.glowna;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OknoWprowadzaniaRoweru implements ActionListener {

	private JFrame frame;
	private JTextField okMarka;
	private JTextField okModel;
	private JTextField okRozmiar;
	private JTextField okCenaZ;
	private JTextField okCenaS;
	private String nowaMarka;
	private String nowaModel;
	private int nowaRozmiar;
	private double nowaCenaZ;
	private double nowaCenaS;

	static private Rowery rowerX;

	public Rowery getRowerX() {
		return this.rowerX;
	}

	public String getNowaMarka() {
		return nowaMarka;
	}

	public String getNowaModel() {
		return nowaModel;
	}

	public int getNowaRozmiar() {
		return nowaRozmiar;
	}

	public double getNowaCenaZ() {
		return nowaCenaZ;
	}

	public double getNowaCenaS() {
		return nowaCenaS;
	}

	public void noweOkno() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoWprowadzaniaRoweru window = new OknoWprowadzaniaRoweru();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OknoWprowadzaniaRoweru() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.setBounds(248, 202, 89, 23);
		frame.getContentPane().add(btnZapisz);
		btnZapisz.addActionListener(this);

		JLabel lblModel = new JLabel("Marka");
		lblModel.setBounds(10, 32, 46, 14);
		frame.getContentPane().add(lblModel);

		JLabel lblMarka = new JLabel("Model");
		lblMarka.setBounds(10, 84, 46, 14);
		frame.getContentPane().add(lblMarka);

		JLabel lblNewLabel = new JLabel("Rozmiar");
		lblNewLabel.setBounds(10, 125, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCenaZakupu = new JLabel("Cena Zakupu");
		lblCenaZakupu.setBounds(10, 168, 78, 14);
		frame.getContentPane().add(lblCenaZakupu);

		JLabel lblCenaSprzeday = new JLabel("Cena Sprzeda\u017Cy");
		lblCenaSprzeday.setBounds(10, 206, 89, 14);
		frame.getContentPane().add(lblCenaSprzeday);

		okMarka = new JTextField();
		okMarka.setBounds(105, 29, 86, 20);
		frame.getContentPane().add(okMarka);
		okMarka.setColumns(10);

		okModel = new JTextField();
		okModel.setBounds(105, 81, 86, 20);
		frame.getContentPane().add(okModel);
		okModel.setColumns(10);

		okRozmiar = new JTextField();
		okRozmiar.setBounds(105, 122, 86, 20);
		frame.getContentPane().add(okRozmiar);
		okRozmiar.setColumns(10);

		okCenaZ = new JTextField();
		okCenaZ.setBounds(105, 165, 86, 20);
		frame.getContentPane().add(okCenaZ);
		okCenaZ.setColumns(10);

		okCenaS = new JTextField();
		okCenaS.setBounds(105, 203, 86, 20);
		frame.getContentPane().add(okCenaS);
		okCenaS.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		zrobRower();
		Magazyn magazyn2 = new Magazyn();
		magazyn2.dodajRower();		
		frame.dispose();
	}

	public Rowery zrobRower() {
		this.nowaMarka = okMarka.getText();
		this.nowaModel = okModel.getText();
		this.nowaRozmiar = Integer.parseInt(okRozmiar.getText());
		this.nowaCenaZ = Double.parseDouble(okCenaZ.getText());
		this.nowaCenaS = Double.parseDouble(okCenaS.getText());

		Rowery rowerX = new Rowery(nowaMarka, nowaModel, nowaRozmiar, nowaCenaZ, nowaCenaS);
		System.out.println("Rower zrobiony o modelu = " + nowaModel + " Marka = " + rowerX.getMarka());
		return this.rowerX = rowerX;
	}

	public Rowery przekazRower() {
		return this.rowerX;
	}

}
