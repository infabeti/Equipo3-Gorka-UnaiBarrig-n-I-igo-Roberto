package Controlador;

import java.sql.SQLException;

import Modelo.BDD;
import Modelo.Modelo;
import Modelo.Productos;
import Modelo.ProductosElegidos;
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

	public Object[][] accionadoBottonAnadirPanelTickets(Object selec, int cant) {
		String[] Separado = modelo.productos.separar(selec);
		 ProductosElegidos[] productos= modelo.pedidos.setProductos(Separado[0], Separado[1], Separado[2], cant);
		 Object [][] objs = new Object[productos.length][3];
		
		 for(int i = 0; i<productos.length;i++) {
			 String nombre = productos[i].getNombre();
			 double cant1 = productos[i].getCantidad();
			 double PrecioCant = productos[i].getPrecioCantidad();
			 objs[i][0]=nombre;
			 objs[i][1]=cant1;
			 objs[i][2]=PrecioCant;
		 }
		 return objs;
	}
	public String Total() {
		return modelo.pedidos.getTotal();
	}
	public String[] stringProductos() throws SQLException {
		String[] arrayr = modelo.BDD.convertirArrayProductosString();
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

	

	public void insertPedido(String entrega) throws SQLException {
		modelo.ScriptsBDD.registrarPedido(entrega);
	}

	public void borrarTotalTickets() {
		modelo.pedidos.borrarTotal();
	}
	
public String getNombreLocal() throws SQLException {
	String usuArr = modelo.BDD.getUsuString();
	String [] usuarioArr= modelo.ArraysUtils.separarParaUsu(usuArr);
	return modelo.ScriptsBDD.getNombreLocal(usuarioArr[1]);
	}
}
