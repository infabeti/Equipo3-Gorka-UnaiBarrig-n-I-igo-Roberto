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
	public void accionadoBottonAñadirPanelPedidos() {
		this.controlador.navegarPanelBienvenida();
	}
	public double accionadoBottonAñadirPrecioCant(double num1, double num2) {
		Modelo.pedidos.setCant(num1,num2);
		return Modelo.pedidos.getCant();
	}
	public double accionadoBottonAñadirTotal(double num1, double num2) {
		Modelo.pedidos.setTotal(num1,num2);
		return Modelo.pedidos.getTotal();
	}
	public void accionadoBottonAñadirPanelPedidos(Object selec) {
		Productos producto = new Productos();
		Separado = producto.separar(selec);
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
