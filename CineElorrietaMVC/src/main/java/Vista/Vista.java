package Vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Vista extends JFrame{


	

	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 501, 500);
		getContentPane().setLayout(null);
		
		this.setTitle("RETO 3");
		
		Color cpanel = new Color(96,111,130);
		Color cpanel2 = new Color(67,75,86);
		Color cpanel3 = new Color(224,224,216);
		
		
		
	}
	
	public void mostrarPanel(JPanel panel) {
		Color cpanel3 = new Color(224,224,216);
		this.setContentPane(panel);
		this.setVisible(true);
		 this.getContentPane().setBackground(cpanel3);
		 
	}
}
