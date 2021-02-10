package Controlador;

import javax.swing.JTextArea;

import Modelo.BDD;
import Modelo.Modelo;
import Modelo.Productos;
import Modelo.Tickets;
import Vista.PanelBienvenida;
import Vista.PanelTickets;
import Vista.Vista;

public class ControladorPanelTickets {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelTickets panelTickets;
	private static String[] Separado;
	
	public static String[] setSeparado() {
		return (String[]) Separado;
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
	public void accionadoBottonAnadirPanelTickets(Object selec) {
		Separado =  modelo.productos.separar(selec);
	}
	public double accionadoBottonAnadirPrecioCant(double num1, double num2) {
		modelo.ticket.setCant(num1,num2);
		return modelo.ticket.getCant();
	}
	public double accionadoBottonAnadirTotal(double num1, double num2) {
		modelo.ticket.setTotal(num1,num2);
		return modelo.ticket.getTotal();
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

	public void accionadoBottonEliminarPanelTickets() {
	
		
	}
}
