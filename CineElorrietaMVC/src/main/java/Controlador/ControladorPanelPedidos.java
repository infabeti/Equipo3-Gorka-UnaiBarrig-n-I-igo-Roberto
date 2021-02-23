package Controlador;

import Modelo.BDD;
import Modelo.Modelo;
import Modelo.Productos;
import Vista.PanelPedidos;
import Vista.Vista;

public class ControladorPanelPedidos {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPedidos panelPedidos;
	private static String[] Separado;
	
	public ControladorPanelPedidos(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelPedidos() {
		this.panelPedidos = new PanelPedidos(this);
		this.vista.mostrarPanel(this.panelPedidos);
	}
	
	public void accionadoBottonVolverPanelPedidos() {
		this.controlador.navegarPanelBienvenida();
	}
	public double accionadoBottonAñadirPrecioCant(double num1, double num2) {
		modelo.pedidos.setCant(num1,num2);
		return modelo.pedidos.getCant();
	}
	public String accionadoBottonAñadirTotal() {
		
		return modelo.pedidos.getTotal();
	}
	public String[] accionadoBottonAñadirPanelPedidos(Object selec, int cant) {
		
			Separado =  modelo.productos.separar(selec);
			double PrecioProducto = Double.parseDouble(Separado[1]);
			modelo.ticket.setProductos(Separado[0],PrecioProducto,cant);
			return Separado; 
		
	}
	public String[] stringProductos(){
		String [] arrayr = modelo.BDD.convertirArrayProductosString();
		return arrayr;
		
	}
	public static String[] setSeparado() {
		return (String[]) Separado;
	}
	public String getContador() {
		return modelo.Contador.getContador();
	}

	public void setContador(String cont) {
		modelo.Contador.setContador(cont);
	}

	public String accionadoBottonEliminarTotal() {
		return modelo.pedidos.eliminarTotal();
	}	
}
