package Controlador;

import javax.swing.JOptionPane;

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
	
	public void accionadoBottonIngresarPanelLoginBienvenida(String local) {
		JOptionPane.showMessageDialog(null, "El Usuario ha iniciado sesion");
		this.controlador.navegarPanelBienvenida(local);
	}
	public void accionadoBottonRegistrarPanelLogin() {
		this.controlador.navegarPanelRegistrar();
	}
	public String[] DevolverUsuariosPanelLogin() {
		
		Usuarios[] Usuarios= modelo.BDD.getUsuarios();
		String UsuariosAString = Usuarios.toString();
		String[] DevolverUsuarios = separar(UsuariosAString);
		return DevolverUsuarios;
	}
	public String[] separar(Object selec) {
		return ((String) selec).split(",") ;
	}
}
