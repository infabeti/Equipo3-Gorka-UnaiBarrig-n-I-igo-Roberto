package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{

	private JButton btnPedidos;
	private JButton btnComandas;
	private JButton btnTickets;
	private JButton btnAprovisionamiento;
	private JLabel lblBienvenida;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	
	public PanelBienvenida(ControladorPanelBienvenida controladorPanelBienvenida) {
		this.controladorPanelBienvenida = controladorPanelBienvenida;
		
		setLayout(null);
		
		lblBienvenida = new JLabel("Pantalla inicial");
		lblBienvenida.setBounds(120, 20, 180, 23);
		add(lblBienvenida);
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(120, 60, 180, 23);
		add(btnPedidos);
		
		btnComandas = new JButton("Comandas");
		btnComandas.setBounds(120, 90, 180, 23);
		add(btnComandas);
		
		btnTickets = new JButton("Facturas/Tickets");
		btnTickets.setBounds(120, 120, 180, 23);
		add(btnTickets);
		
		btnAprovisionamiento = new JButton("Aprovisionamiento");
		btnAprovisionamiento.setBounds(120, 150, 180, 23);
		add(btnAprovisionamiento);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnTickets.addActionListener(listenerBotonTickets(this.controladorPanelBienvenida));
		this.btnPedidos.addActionListener(listenerBotonPedidos(this.controladorPanelBienvenida));
		this.btnComandas.addActionListener(listenerBotonComandas(this.controladorPanelBienvenida));
		this.btnAprovisionamiento.addActionListener(listenerBotonAprovisionamiento(this.controladorPanelBienvenida));

	}
	
	
	private ActionListener listenerBotonTickets(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Tickets");
				controladorPanelBienvenida.accionadoBottonMostrarPanelTickets();
			}
		};
	}
	private ActionListener listenerBotonPedidos(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Pedidos");
				controladorPanelBienvenida.accionadoBottonMostrarPanelPedidos();
			}
		};
	}
	private ActionListener listenerBotonComandas(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Comandas");
				controladorPanelBienvenida.accionadoBottonMostrarPanelComandas();
			}
		};
	}
	private ActionListener listenerBotonAprovisionamiento(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Aprovisionamiento");
				controladorPanelBienvenida.accionadoBottonMostrarPanelAprovisionamiento();
			}
		};
	}
}
