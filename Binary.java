package binary;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Binary extends JFrame {

	public static void main(String args[]) {
		JFrame f = new JFrame("");
		f.setSize(800, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void ek_p() {
		JPanel ek_p = new JPanel();
		ek_p.setBounds(500, 50, 200, 300);
		add(ek_p);
		ek_p.setLayout(null);

		Button bas = new Button("int bas = 0;" + "int son = dizi.length-1;"
				+ "int i;" + "while (bas <= son)" + "i = (bas + son)/2;"
				+ "if (dizi[i] == aranan)" + "{yazdýr('Bulundu')break;} "
				+ "else if (dizi[i] > aranan) " + "   son = i - 1;" + "  else"
				+ "    bas = i + 1;}");
		bas.setBackground(Color.orange);
		bas.setBounds(500, 50, 200, 300);
		bas.setEnabled(true);
		bas.setVisible(true);
		add(bas);
	}

}