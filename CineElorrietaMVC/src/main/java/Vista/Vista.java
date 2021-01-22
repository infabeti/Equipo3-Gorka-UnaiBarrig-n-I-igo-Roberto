package Vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Vista extends JFrame{


	

	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 450, 300);
		getContentPane().setLayout(null);
		
		this.setTitle("RETO 3");
		
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, 114, 261);
		getContentPane().add(panel);
		
		Color cpanel = new Color(96,111,130);
		Color cpanel2 = new Color(67,75,86);
		Color cpanel3 = new Color(224,224,216);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(114, 0, 320, 45);
		getContentPane().add(panel2);
		
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(114, 45, 320, 216);
		getContentPane().add(panel3);
		
		
		panel2.setBackground(cpanel);
		panel3.setBackground(cpanel3);
		panel.setBackground(cpanel2);
		
		
		
	}
	
	public void mostrarPanel(JPanel panel) {
		Color cpanel3 = new Color(224,224,216);
		this.setContentPane(panel);
		this.setVisible(true);
		 this.getContentPane().setBackground(cpanel3);
		 
	}
}
