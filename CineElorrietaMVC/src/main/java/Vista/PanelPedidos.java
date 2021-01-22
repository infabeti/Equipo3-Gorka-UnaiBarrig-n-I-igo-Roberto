package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelTickets;

@SuppressWarnings("serial")
public class PanelPedidos extends JPanel {

	private JButton btnVolver;
	private JLabel lblPedidos;
	private ControladorPanelTickets controladorPanelPedidos;
	
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		this.controladorPanelPedidos = controladorPanelPedidos;
		
		setLayout(null);
		
		lblPedidos = new JLabel("Panel Pedidos");
		lblPedidos.setBounds(58, 35, 115, 14);
		add(lblPedidos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 62, 89, 23);
		add(btnVolver);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPedidos));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelPedidos.accionadoBottonVolverPanelPedidos();
			}
		};
	}
}
