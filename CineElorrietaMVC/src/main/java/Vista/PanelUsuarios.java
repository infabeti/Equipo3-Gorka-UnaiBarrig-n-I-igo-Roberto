package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import Controlador.ControladorPanelTickets;
import Controlador.ControladorPanelUsuarios;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class PanelUsuarios extends JPanel {

	private JButton btnRegistrar;
	private JButton btnIngresar;
	private JLabel lblUsuario;

	private ControladorPanelUsuarios controladorPanelUsuarios;
	private JTable table;
	private JTextField textField;
	private JPasswordField passwordField;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelUsuarios(ControladorPanelUsuarios controladorPanelUsuarios)
	{
		this.controladorPanelUsuarios = controladorPanelUsuarios;
		setLayout(null);
		
		lblUsuario = new JLabel("Inicio de Sesion");
		lblUsuario.setBounds(184, 25, 115, 14);
		add(lblUsuario);
		
		
		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setBounds(83, 85, 104, 14);
		add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(83, 134, 104, 14);
		add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(184, 82, 150, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 131, 150, 20);
		add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 430, 2);
		add(separator);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(171, 211, 89, 23);
		add(btnRegistrar);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(320, 211, 89, 23);
		add(btnIngresar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 245, 430, 2);
		add(separator_1);

		
		initializeEvents();
	}
	

	private void initializeEvents() {
		this.btnIngresar.addActionListener(listenerBotonIngresar(this.controladorPanelUsuarios));
		this.btnRegistrar.addActionListener(listenerBotonRegistrar(this.controladorPanelUsuarios));
	}
	
	private ActionListener listenerBotonIngresar(ControladorPanelUsuarios controladorPanelUsuarios) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Ingresar");
				controladorPanelUsuarios.accionadoBottonIngresarPanelUsuarios();
			}
		};
	}
	private ActionListener listenerBotonRegistrar(ControladorPanelUsuarios controladorPanelUsuarios) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registrar");
				controladorPanelUsuarios.accionadoBottonRegistrarPanelUsuarios();
			}
		};
	}
	
	
	
}
