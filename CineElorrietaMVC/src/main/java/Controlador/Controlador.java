package Controlador;

import Modelo.BDD;
import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	private BDD bd;
	private Vista vista;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	private ControladorPanelTickets controladorPanelTickets;
	private ControladorPanelPedidos controladorPanelPedidos;
	private ControladorPanelComandas controladorPanelComandas;
	private ControladorPanelAprovisionamiento controladorPanelAprovisionamiento;
	private ControladorPanelLogin controladorPanelUsuarios;
	private ControladorPanelRegistrar controladorPanelRegistrar;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelBienvenida = new ControladorPanelBienvenida(this.modelo, this.vista, this);
		this.controladorPanelTickets = new ControladorPanelTickets(this.modelo, this.vista, this);
		this.controladorPanelPedidos = new ControladorPanelPedidos(this.modelo, this.vista, this);
		this.controladorPanelComandas = new ControladorPanelComandas(this.modelo, this.vista, this);
		this.controladorPanelAprovisionamiento = new ControladorPanelAprovisionamiento(this.modelo, this.vista, this);
		this.controladorPanelUsuarios = new ControladorPanelLogin(this.modelo, this.vista, this);
		this.controladorPanelRegistrar = new ControladorPanelRegistrar(this.modelo, this.vista, this);
		this.navegarPanelUsuarios();
	}
	public void navegarPanelBienvenida() {
		System.out.println("Navegar panel Bienvenida");
		this.controladorPanelBienvenida.mostrarPanelBienvenida();
	}
	
	public void navegarPanelTickets() {
		System.out.println("Navegar panel Tickets");
		this.controladorPanelTickets.mostrarPanelTickets();
	}
	public void navegarPanelPedidos() {
		System.out.println("Navegar panel Pedidos");
		this.controladorPanelPedidos.mostrarPanelPedidos();
	}
	
	public void navegarPanelComandas() {
		System.out.println("Navegar panel Comandas");
		this.controladorPanelComandas.mostrarPanelComandas();
	}
	
	public void navegarPanelAprovisionamiento() {
		System.out.println("Navegar panel Aprovisionamiento");
		this.controladorPanelAprovisionamiento.mostrarPanelAprovisionamiento();
	}
	public void navegarPanelRegistrar() {
		System.out.println("Navegar panel Registrar");
		this.controladorPanelRegistrar.mostrarPanelRegistrar();
	}
	
	public void navegarPanelUsuarios() {
		System.out.println("Navegar panel Usuarios");
		this.controladorPanelUsuarios.mostrarPanelUsuarios();
	}
	
	public void conectarBDD() {
		System.out.println("Conectar a BDD");
		this.bd.conexion();
	}
	
}
