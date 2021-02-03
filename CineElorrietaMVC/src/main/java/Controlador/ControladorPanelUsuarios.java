package Controlador;

import Modelo.BDD;
import Modelo.Modelo;
import Modelo.Productos;
import Modelo.Usuarios;
import Vista.PanelBienvenida;
import Vista.PanelTickets;
import Vista.PanelUsuarios;
import Vista.Vista;

public class ControladorPanelUsuarios {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelUsuarios panelUsuarios;
	private int cont=1;
	
	
	public ControladorPanelUsuarios(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelUsuarios() {
		this.panelUsuarios = new PanelUsuarios(this);
		this.vista.mostrarPanel(this.panelUsuarios);
	}
	
	public void accionadoBottonIngresarPanelUsuarios() {
		this.controlador.navegarPanelBienvenida();
	}
	public void accionadoBottonRegistrarPanelUsuarios() {
		this.controlador.navegarPanelRegistrar();
	}

	
	

	
	public String[] pasarString(){
		BDD Usuarios = new BDD();
		Usuarios[] usuarios2 = Usuarios.getUsuarios();
		String [] arrayr=new String[usuarios2.length];
		for(int i=0; i<usuarios2.length; i++) {
			arrayr[i]=usuarios2[i].toString();
		}
		return  arrayr;
		
	}
}
