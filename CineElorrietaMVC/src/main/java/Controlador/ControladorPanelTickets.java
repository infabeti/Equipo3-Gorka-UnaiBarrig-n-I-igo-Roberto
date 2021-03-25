package Controlador;

import java.sql.SQLException;

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
	private String nombreLocal = null;

	public ControladorPanelTickets() {
	}

	public ControladorPanelTickets(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}

	public void mostrarPanelTickets() throws SQLException {
		this.panelTickets = new PanelTickets(this);
		this.vista.mostrarPanel(this.panelTickets);
	}

	public void accionadoBottonVolverPanelTickets() {
		this.controlador.navegarPanelBienvenida();
	}

	public Object[][] accionadoBottonAnadirPanelTickets(Object selec, int cant) {
		String[] Separado = modelo.productos.separar(selec);
		 ProductosElegidos[] productos= modelo.ticket.setProductos(Separado[0], Separado[1], Separado[2], cant);
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
		return modelo.ticket.getTotal();
	}

	public String accionadoBottonEliminarTotal() {
		return modelo.ticket.eliminarTotal();
	}

	public String[] stringProductos() throws SQLException {
		return modelo.BDD.convertirArrayProductosString();
	}

	public String getContador() throws SQLException {
		String numero = modelo.ScriptsBDD.NTrans();
		int numero1 = Integer.parseInt(numero);
		numero1++;
		String contador = String.valueOf(numero1);

		return contador;
	}

	public String getFecha() {
		return modelo.ticket.getFecha();
	}

	public void insertTickets(String Ntrans, String NIF, String Nombre, String Apellido, boolean factura)
			throws SQLException {
		modelo.ScriptsBDD.registrarTicketFacts(Ntrans, NIF, Nombre, Apellido, factura);
		
	}

	public void borrarTotalTickets() {
		modelo.ticket.borrarTotal();
	}
	public String getNombreLocal() throws SQLException {
		String usuArr = modelo.BDD.getUsuString();
		String [] usuarioArr= modelo.ArraysUtils.separarParaUsu(usuArr);
		return modelo.ScriptsBDD.getNombreLocal(usuarioArr[1]);
	}
}
