package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelComandas;
import Controlador.ControladorPanelTickets;

@SuppressWarnings("serial")
public class PanelComandas extends JPanel {

	private JButton btnVolver;
	private JLabel lblComandas;
	private ControladorPanelComandas controladorPanelComandas;

	public PanelComandas(ControladorPanelComandas controladorPanelComandas) {
		this.controladorPanelComandas = controladorPanelComandas;

		setLayout(null);

		lblComandas = new JLabel("Comandas");
		lblComandas.setBounds(198, 15, 115, 14);
		add(lblComandas);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(58, 192, 89, 23);
		btnVolver.setFocusPainted(false);
		Color cpanel = new Color(200, 194, 182);
		btnVolver.setBackground(cpanel);
		add(btnVolver);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelComandas));
	}

	private ActionListener listenerBotonVolver(ControladorPanelComandas controladorPanelComandas) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelComandas.accionadoBottonVolverPanelComandas();
			}
		};
	}
}
