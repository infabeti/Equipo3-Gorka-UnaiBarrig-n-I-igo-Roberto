package Controlador;

import Modelo.BDD;
import Modelo.Modelo;
import Modelo.Productos;
import Modelo.Usuarios;
import Vista.PanelBienvenida;
import Vista.PanelTickets;
import Vista.PanelLogin;
import Vista.Vista;

public class ControladorPanelLogin {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelUsuarios;
	private int cont=1;
	
	
	public ControladorPanelLogin(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelUsuarios() {
		this.panelUsuarios = new PanelLogin(this);
		this.vista.mostrarPanel(this.panelUsuarios);
	}
	
	public void accionadoBottonIngresarPanelLoginBienvenida() {
		this.controlador.navegarPanelBienvenida();
	}
	public void accionadoBottonRegistrarPanelLogin() {
		this.controlador.navegarPanelRegistrar();
	}
	public Usuarios[] DevolverUsuariosPanelLogin() {
		
		return modelo.BDD.getUsuarios();
	}
}
