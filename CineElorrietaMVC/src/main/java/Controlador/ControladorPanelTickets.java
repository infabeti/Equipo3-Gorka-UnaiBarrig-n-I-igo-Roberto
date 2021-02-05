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
	public void accionadoBottonAñadirPanelTickets(Object selec) {
		Productos producto = new Productos();
		Separado = producto.separar(selec);
	}
	public double accionadoBottonAñadirPrecioCant(double num1, double num2) {
		Modelo.ticket.setCant(num1,num2);
		return Modelo.ticket.getCant();
	}
	public double accionadoBottonAñadirTotal(double num1, double num2) {
		Modelo.ticket.setTotal(num1,num2);
		return Modelo.ticket.getTotal();
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
	public void contador(JTextArea cont) {
		int i = Integer.parseInt(cont.getText());
		String s=String.valueOf(i+1);
		cont.setText(s);
	}
}
