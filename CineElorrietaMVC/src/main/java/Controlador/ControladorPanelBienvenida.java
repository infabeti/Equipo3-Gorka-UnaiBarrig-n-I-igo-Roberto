package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.Vista;

public class ControladorPanelBienvenida {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelBienvenida panelBienvenida;
	
	public ControladorPanelBienvenida(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelBienvenida() {
		this.panelBienvenida = new PanelBienvenida(this);
		this.vista.mostrarPanel(this.panelBienvenida);
	}
	
	public void accionadoBottonMostrarPanelTickets() {
		modelo.ticket.setFecha();
		this.controlador.navegarPanelTickets();
	}
	public void accionadoBottonMostrarPanelPedidos() {
		this.controlador.navegarPanelPedidos();
	}
	public void accionadoBottonMostrarPanelComandas() {
		this.controlador.navegarPanelComandas();
	}
	public void accionadoBottonMostrarPanelAprovisionamiento() {
		this.controlador.navegarPanelAprovisionamiento();
	}
	public void accionadoBottonMostrarPanelCerrar() {
		this.controlador.navegarPanelUsuarios();
	}
	public void accionadoBottonMostrarConexionBDD() {
		
		this.controlador.conectarBDD();
	}

	
}
