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
	public void accionadoBottonA�adirPanelPedidos() {
		this.controlador.navegarPanelBienvenida();
	}
	public double accionadoBottonA�adirPrecioCant(double num1, double num2) {
		Modelo.pedidos.setCant(num1,num2);
		return Modelo.pedidos.getCant();
	}
	public double accionadoBottonA�adirTotal(double num1, double num2) {
		Modelo.pedidos.setTotal(num1,num2);
		return Modelo.pedidos.getTotal();
	}
	public void accionadoBottonA�adirPanelPedidos(Object selec) {
		Separado =  Modelo.productos.separar(selec);
	}
	public String[] stringProductos(){
		String [] arrayr = Modelo.BDD.convertirArrayProductosString();
		return arrayr;
		
	}
	public static String[] setSeparado() {
		return (String[]) Separado;
	}
	

	
}
