package Controlador;

import Modelo.BDD;
import Modelo.Modelo;
import Modelo.Productos;
import Vista.PanelBienvenida;
import Vista.PanelRegistrar;
import Vista.PanelTickets;
import Vista.PanelLogin;
import Vista.Vista;

public class ControladorPanelRegistrar {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelRegistrar panelRegistrar;
	private int cont=1;
	
	
	public ControladorPanelRegistrar(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelRegistrar() {
		this.panelRegistrar = new PanelRegistrar(this);
		this.vista.mostrarPanel(this.panelRegistrar);
	}
	
	public void accionadoBottonVolverPanelRegistrar() {
		this.controlador.navegarPanelUsuarios();
	}
	public void accionadoBottonRegistrarPanelRegistrar(String Nombre, String Apellido, String DNI, String Contraseña, String Local) {
		modelo.BDD.setUsuarios(Local, DNI, Contraseña, Apellido, Nombre);
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
