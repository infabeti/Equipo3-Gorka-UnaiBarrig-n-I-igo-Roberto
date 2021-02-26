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
	private String[] Separado;
	
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
		Separado =  modelo.productos.separar(object);
		double PrecioProducto = Double.parseDouble(Separado[1]);
		modelo.ticket.setProductos(Separado[0],PrecioProducto,cant);
		return Separado; 
	}
	public double accionadoBottonAnadirPrecioCant() {
		return modelo.ticket.getCant();
	}
	public String accionadoBottonAnadirTotal() {
		return modelo.ticket.getTotal();
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
			
	}

}
