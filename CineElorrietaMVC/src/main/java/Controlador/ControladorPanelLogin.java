package Controlador;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.BDD;
import Modelo.Modelo;
import Modelo.Productos;
import Modelo.Usuarios;
import Vista.PanelBienvenida;
import Vista.PanelTickets;
import Vista.PanelLogin;
import Vista.Vista;

public class ControladorPanelLogin {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelUsuarios;
	private int cont = 1;

	public ControladorPanelLogin(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}

	public void mostrarPanelUsuarios() {
		this.panelUsuarios = new PanelLogin(this);
		this.vista.mostrarPanel(this.panelUsuarios);
	}

	public void accionadoBottonIngresarPanelLoginBienvenida() {
		JOptionPane.showMessageDialog(null, "El Usuario ha iniciado sesion");
		this.controlador.navegarPanelBienvenida();
	}

	public void accionadoBottonRegistrarPanelLogin() {
		this.controlador.navegarPanelRegistrar();
	}

	public String[] DevolverUsuariosPanelLogin(String nIFIntroducido, String contrasenaIntroducida)
			throws SQLException {

		Usuarios Usuarios = modelo.BDD.LoginUsu(nIFIntroducido, contrasenaIntroducida);
		String UsuariosAString = Usuarios.toString();
		String[] DevolverUsuarios = modelo.ArraysUtils.separarParaUsu(UsuariosAString);
		return DevolverUsuarios;
	}

}
