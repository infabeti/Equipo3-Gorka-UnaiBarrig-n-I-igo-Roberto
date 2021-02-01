package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import Controlador.ControladorPanelRegistrar;
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
public class PanelRegistrar extends JPanel {

	private JButton btnVolver;
	private JButton btnRegistrar;
	private JLabel lblTickets;

	private ControladorPanelRegistrar controladorPanelRegistrar;
	private JTable table;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelRegistrar(ControladorPanelRegistrar controladorPanelRegistrar)
	{
		this.controladorPanelRegistrar = controladorPanelRegistrar;
		setLayout(null);
		
		lblTickets = new JLabel("Registro");
		lblTickets.setBounds(184, 25, 115, 14);
		add(lblTickets);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(37, 211, 89, 23);
		add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(37, 85, 54, 14);
		add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Apellido:");
		lblContrasea.setBounds(37, 134, 54, 14);
		add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(101, 82, 95, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(101, 131, 98, 20);
		add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 430, 2);
		add(separator);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(320, 211, 89, 23);
		add(btnRegistrar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 245, 430, 2);
		add(separator_1);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(234, 85, 34, 14);
		add(lblDni);
		
		JLabel lblContrasea_1 = new JLabel("Contrase\u00F1a:");
		lblContrasea_1.setBounds(234, 134, 135, 14);
		add(lblContrasea_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(314, 82, 95, 20);
		add(textField_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(314, 131, 94, 20);
		add(passwordField_1);

		
		initializeEvents();
	}
	

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelRegistrar));
		this.btnRegistrar.addActionListener(listenerBotonVolver(this.controladorPanelRegistrar));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelRegistrar controladorPanelRegistrar) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelRegistrar.accionadoBottonVolverPanelRegistrar();
			}
		};
	}
	private ActionListener listenerBotonRegistrar(ControladorPanelRegistrar controladorPanelRegistrar) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registrar");
				controladorPanelRegistrar.accionadoBottonRegistrarPanelRegistrar();
			}
		};
	}
}
