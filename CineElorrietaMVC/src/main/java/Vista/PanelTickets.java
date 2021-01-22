package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelTickets;

@SuppressWarnings("serial")
public class PanelTickets extends JPanel {

	private JButton btnVolver;
	private JLabel lblTickets;
	private ControladorPanelTickets controladorPanelTickets;
	
	public PanelTickets(ControladorPanelTickets controladorPanelTickets)
	{
		this.controladorPanelTickets = controladorPanelTickets;
		
		setLayout(null);
		
		lblTickets = new JLabel("Panel Tickets");
		lblTickets.setBounds(58, 35, 115, 14);
		add(lblTickets);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 62, 89, 23);
		add(btnVolver);
		
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
}
