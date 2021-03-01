package Controlador;

import javax.swing.JTextArea;

import Modelo.BDD;
import Modelo.Modelo;
import Modelo.Productos;
import Modelo.ProductosElegidos;
import Modelo.Tickets;
import Vista.PanelBienvenida;
import Vista.PanelTickets;
import Vista.Vista;

public class ControladorPanelTickets {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTickets panelTickets;
	
	public ControladorPanelTickets() {
	}
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
	public String[] accionadoBottonAnadirPanelTickets(Object object, int cant) {
		String[] Separado =  modelo.productos.separar(object);
		modelo.ticket.setProductos(Separado[0],Separado[1],cant);
		String total = modelo.ticket.getTotal();
		String precioCant = modelo.ticket.getCant();
		String Cant1 = String.valueOf(cant);
		String[] todo = {Separado[0],Cant1,precioCant,total};
		return todo; 
	}
	public String accionadoBottonEliminarTotal() {
		return modelo.ticket.eliminarTotal();
	}	
	public String[] stringProductos(){
		return modelo.BDD.convertirArrayProductosString();
	}
	public String getContador() {
		return modelo.Contador.getContador();
	}

	public void setContador(String cont) {
		modelo.Contador.setContador(cont);
	}
	public String getFecha() {
		return modelo.ticket.getFecha();
	}
	public void accionadoBottonEliminarPanelTickets(int i) {
		modelo.ticket.setArrSelec(i);
	}

}
