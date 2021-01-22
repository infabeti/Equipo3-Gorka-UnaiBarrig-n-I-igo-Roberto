package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelAprovisionamiento;
import Controlador.ControladorPanelTickets;

@SuppressWarnings("serial")
public class PanelAprovisionamiento extends JPanel {

	private JButton btnVolver;
	private JLabel lblAprovisionamiento;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	
	public PanelAprovisionamiento(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento)
	{
		this.controladorPanelAprovisionamiento = controladorPanelAprovisionamiento;
		
		setLayout(null);
		
		lblAprovisionamiento = new JLabel("Aprovisionamiento");
		lblAprovisionamiento.setBounds(198, 15, 115, 14);
		add(lblAprovisionamiento);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 192, 89, 23);
		add(btnVolver);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelAprovisionamiento));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelAprovisionamiento controladorPanelAprovisionamiento) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelAprovisionamiento.accionadoBottonVolverPanelAprovisionamiento();
			}
		};
	}
}
