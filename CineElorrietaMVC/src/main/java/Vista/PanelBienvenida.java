package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;
import Modelo.Registrar;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{

	private JButton btnPedidos;
	private JButton btnComandas;
	private JButton btnTickets;
	private JButton btnAprovisionamiento;
	private JButton btnBDD;
	private JButton btnCerrar;
	private JLabel lblBienvenida;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	
	public PanelBienvenida(ControladorPanelBienvenida controladorPanelBienvenida) {
		this.controladorPanelBienvenida = controladorPanelBienvenida;
		
		setLayout(null);
		
		lblBienvenida = new JLabel("BIENVENIDA");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(153, 26, 200, 23);
		add(lblBienvenida);
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(153, 84, 212, 74);
		btnPedidos.setFocusPainted(false);
		Color cpanel = new Color(200,194,182);
		btnPedidos.setBackground(cpanel);
		add(btnPedidos);
		
		btnComandas = new JButton("Comandas");
		btnComandas.setBounds(153, 341, 212, 74);
		btnComandas.setFocusPainted(false);
		btnComandas.setBackground(cpanel);
		add(btnComandas);
		
		btnTickets = new JButton("Facturas/Tickets");
		btnTickets.setBounds(153, 171, 212, 74);
		btnTickets.setFocusPainted(false);
		btnTickets.setBackground(cpanel);
		add(btnTickets);
		
		btnAprovisionamiento = new JButton("Aprovisionamiento");
		btnAprovisionamiento.setBounds(153, 256, 212, 74);
		btnAprovisionamiento.setFocusPainted(false);
		btnAprovisionamiento.setBackground(cpanel);
		add(btnAprovisionamiento);

		
		btnCerrar = new JButton("Cerrar Sesion");
		btnCerrar.setBounds(303, 230, 120, 23);
		add(btnCerrar);		
		
		initializeEvents();
	}
	


	private void initializeEvents() {
		this.btnTickets.addActionListener(listenerBotonTickets(this.controladorPanelBienvenida));
		this.btnPedidos.addActionListener(listenerBotonPedidos(this.controladorPanelBienvenida));
		this.btnComandas.addActionListener(listenerBotonComandas(this.controladorPanelBienvenida));
		this.btnAprovisionamiento.addActionListener(listenerBotonAprovisionamiento(this.controladorPanelBienvenida));
		this.btnCerrar.addActionListener(listenerBotonCerrar(this.controladorPanelBienvenida));


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
	private ActionListener listenerBotonBDD(ControladorPanelBienvenida controladorPanelBDD) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento conexi�n BDD");
				controladorPanelBDD.accionadoBottonMostrarConexionBDD();
			}
		};
	}
	private ActionListener listenerBotonCerrar(ControladorPanelBienvenida controladorPanelBienvenida) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Cerrar Sesion");
				controladorPanelBienvenida.accionadoBottonMostrarPanelCerrar();
			}
		};
	}
}
