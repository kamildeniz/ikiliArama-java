package binary;  
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
/**
 * @author 3dmaster
 */
public class ek_p extends JFrame { //burada ise s�n�f�n�z�n (class) ismi olmal�
 
    public static void main(String[] args) {
    	JFrame frm =new JFrame();
		JPanel ek_P = new JPanel();
		ek_P.setBounds(500, 50, 200, 300);
		frm.add(ek_P);  
		frm.setBounds(500, 50, 200, 300);
		//frm.setSize(200,300);
		frm.setVisible(true);
		}
}
