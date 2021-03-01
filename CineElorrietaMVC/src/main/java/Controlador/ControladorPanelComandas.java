package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelComandas;
import Vista.PanelTickets;
import Vista.Vista;

public class ControladorPanelComandas {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelComandas panelComandas;
	
	public ControladorPanelComandas(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelComandas() {
		this.panelComandas = new PanelComandas(this);
		this.vista.mostrarPanel(this.panelComandas);
	}
	
	public void accionadoBottonVolverPanelComandas() {
		this.controlador.navegarPanelBienvenida();
	}
}
