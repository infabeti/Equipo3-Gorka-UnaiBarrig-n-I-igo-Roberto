package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelTickets;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class PanelTickets extends JPanel {

	private JButton btnVolver;
	private JLabel lblTickets;
	private JLabel lblProducto1;
	private JLabel lblProducto2;
	private JLabel lblProducto3;
	private int contP1 = 0;
	private int contP2 = 0;
	private int contP3 = 0;

	private ControladorPanelTickets controladorPanelTickets;
	
	public PanelTickets(ControladorPanelTickets controladorPanelTickets)
	{
		this.controladorPanelTickets = controladorPanelTickets;
		
		setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(247, 63, 146, 197);
		add(textPane);
		
		lblTickets = new JLabel("Tickets");
		lblTickets.setBounds(198, 15, 115, 14);
		add(lblTickets);
		
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 192, 89, 23);
		add(btnVolver);
		
		JButton btnNewButton = new JButton("Producto1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			contP1 = contador(contP1);
				
			}
		});
		btnNewButton.setBounds(58, 66, 89, 23);
		add(btnNewButton);
		
		JButton btnProducto = new JButton("Producto2");
		btnProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contP2 = contador(contP2);
			}
		});
		btnProducto.setBounds(58, 100, 89, 23);
		add(btnProducto);
		
		JButton btnNewButton_1_1 = new JButton("Producto3");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contP3 = contador(contP3);
				String numero = String.valueOf(contP3);
				textPane.setText(numero);
			}
		});
		btnNewButton_1_1.setBounds(58, 134, 89, 23);
		add(btnNewButton_1_1);
		
		
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTickets));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelTickets.accionadoBottonVolverPanelTickets();
			}
		};
	}
	public int contador(int cont) {
		return cont++;
	}
}
