package binary;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class txt extends JPanel implements ActionListener {
	JButton sayigir, sirala, laekle, ara;
	static JButton aranan_b;
	TextField text, say, arat;
	static txt p;
	JLabel label;
	JButton[] btn;
	Button uyari;
	static JFrame f;
	int sayac = 0, aranan;
	int[] dizi;
	boolean flag = false;

	public txt() {
		super();

		sayigir = new JButton("ekle");
		sayigir.setBounds(100, 240, 70, 30);
		add(sayigir);
		sayigir.addActionListener(this);

		ara = new JButton("ara");
		ara.setBounds(180, 240, 70, 30);
		add(ara);
		ara.addActionListener(this);

		laekle = new JButton("indis");
		add(laekle);
		laekle.setBounds(260, 240, 70, 30);
		laekle.addActionListener(this);

		sirala = new JButton("sýrala");
		add(sirala);
		sirala.setBounds(180, 280, 70, 30);
		sirala.addActionListener(this);

		laekle.setEnabled(true);
		sayigir.setEnabled(false);
		sirala.setEnabled(false);
		ara.setEnabled(false);

		say = new TextField("1", 10);
		say.setBounds(100, 200, 70, 30);
		add(say);

		text = new TextField("2", 10);
		text.setBounds(260, 200, 70, 30);
		add(text);

		arat = new TextField(10);
		arat.setBounds(180, 200, 70, 30);
		add(arat);


	}

	public static void main(String[] args) {
		f = new JFrame("");
		p = new txt();
		p.setBackground(Color.blue);
		f.add(p);
		p.setLayout(null);
		f.setSize(800, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == laekle) {
			int a = Integer.parseInt(text.getText());
			btn = new JButton[a];
			int c = 20;
			for (int i = 0; i < a; i++) {
				btn[i] = new JButton("0");
				btn[i].setForeground(Color.red);
				btn[i].setBackground(Color.green);
				btn[i].setSize(50, 40);
				btn[i].setLocation(c, 10);
				btn[i].setEnabled(false);
				p.add(btn[i]);
				btn[i].setVisible(true);
				c += 80;
			}
			laekle.setEnabled(false);
			sayigir.setEnabled(true);
			sirala.setEnabled(false);
			ara.setEnabled(false);
		}// butonlarý ekledim

		else if (e.getSource() == sayigir) {

			if (sayac < btn.length) {

				btn[sayac].setText(String.valueOf(say.getText()));
				sayac++;
				if (sayac == btn.length) {
					laekle.setEnabled(false);
					sayigir.setEnabled(false);
					sirala.setEnabled(true);
					ara.setEnabled(false);

				}
			}

			dizi = new int[Integer.parseInt(text.getText())];

			// butonlara sayý ekledim

		} else if (e.getSource() == sirala) {
			for (int z = 0; z < dizi.length; z++) {
				int q = Integer.parseInt(btn[z].getText());
				dizi[z] = q;
			}

			int bos;
			for (int i = 0; i < dizi.length - 1; i++) {
				for (int k = 0; k < dizi.length - i - 1; k++) {
					if (dizi[k] > dizi[k + 1]) {
						bos = dizi[k];
						dizi[k] = dizi[k + 1];
						dizi[k + 1] = bos;
						btn[k].setText(String.valueOf(dizi[k]));
					}
				}
			}
			for (int j = 0; j < dizi.length; j++) {
				btn[j].setText(String.valueOf(dizi[j]));
			}

			laekle.setEnabled(false);
			sayigir.setEnabled(false);
			sirala.setEnabled(false);
			ara.setEnabled(true);

		}

		else if (e.getSource() == ara) {
			int aranan = Integer.parseInt(arat.getText());
			int buyuk, kucuk, orta;
			
			buyuk = dizi.length - 1;
			kucuk = 0;

			repaint();
			while (kucuk <= buyuk) {
				orta = (buyuk + kucuk) / 2;
				btn[buyuk].setForeground(Color.red);
				btn[buyuk].setBackground(Color.green);				
				btn[orta].setForeground(Color.red);
				btn[orta].setBackground(Color.green);

				repaint();
				if (aranan == dizi[orta]) {
					btn[orta].setForeground(Color.green);
					btn[orta].setBackground(Color.red);
					repaint();
					break;
				} else if (aranan < dizi[orta]) {
					buyuk = orta - 1;
					btn[orta].setForeground(Color.red);
					btn[orta].setBackground(Color.green);
					repaint();
					
				} else if (aranan > dizi[orta]) {
					kucuk = orta + 1;
					btn[orta].setForeground(Color.red);
					btn[orta].setBackground(Color.green);
					repaint();
				}

				btn[orta].setForeground(Color.red);
				btn[orta].setBackground(Color.green);
				repaint();

			}
			if (kucuk > buyuk) {

				JOptionPane.showMessageDialog(null, "Bulunamadý", "Mesaj -1",
						-1);
			}
		}
		repaint();
	}
}
