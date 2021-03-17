package Controlador;

import java.sql.SQLException;

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
	
	public ControladorPanelPedidos(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelPedidos() throws SQLException {
		this.panelPedidos = new PanelPedidos(this);
		this.vista.mostrarPanel(this.panelPedidos);
	}
	
	public void accionadoBottonVolverPanelPedidos() {
		this.controlador.navegarPanelBienvenida();
	}
	public String[] accionadoBottonAnadirPanelPedidos(Object selec, int cant) {
			String[] Separado;
			Separado =  modelo.productos.separar(selec);
			modelo.pedidos.setProductos(Separado[0],Separado[1],cant);
			String total = modelo.pedidos.getTotal();
			String precioCant = modelo.pedidos.getCant();
			String Cant1 = String.valueOf(cant);
			String[] todo = {Separado[0],Cant1,precioCant,total};
			return todo; 
	}
	public String[] stringProductos() throws SQLException{
		String [] arrayr = modelo.BDD.convertirArrayProductosString();
		return arrayr;
		
	}
	
	public String getContador() throws SQLException {
		String numero = modelo.ScriptsBDD.NTrans();
		int numero1 = Integer.parseInt(numero);
		numero1++;
		String contador = String.valueOf(numero1);
		
		return contador;
	}

	public void setContador(String cont) {
		modelo.Contador.setContador(cont);
	}

	public String accionadoBottonEliminarTotal() {
		return modelo.pedidos.eliminarTotal();
	}	
	public void accionadoBottonEliminarPanelPedidos(int i) {
		modelo.pedidos.setArrSelec(i);
	}
	
	public void insertPedido(String entrega) throws SQLException {
		modelo.ScriptsBDD.registrarPedido(entrega);
	}
	public void borrarTotalTickets() {
		modelo.pedidos.borrarTotal();
	}
}
