package Controlador;

import Modelo.BDD;
import Modelo.Modelo;
import Modelo.Productos;
import Vista.PanelBienvenida;
import Vista.PanelTickets;
import Vista.Vista;

public class ControladorPanelTickets {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTickets panelTickets;
	private int cont=1;
	
	
	public ControladorPanelTickets(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelTickets() {
		this.panelTickets = new PanelTickets(this);
		this.vista.mostrarPanel(this.panelTickets);
	}
	
	public void accionadoBottonVolverPanelTickets() {
		this.controlador.navegarPanelBienvenida();
	}
	public void accionadoBottonAñadirPanelTickets() {
	
	}
	public void accionadoBottonGuardarPanelTickets() {
		this.cont++;
	}
	
	public String[] pasarString(){
		BDD productos = new BDD();
		Productos[] poductos2 = productos.getProductos();
		String [] arrayr=new String[poductos2.length];
		for(int i=0; i<poductos2.length; i++) {
			arrayr[i]=poductos2[i].toString();
		}
		return  arrayr;
		
	}
}
