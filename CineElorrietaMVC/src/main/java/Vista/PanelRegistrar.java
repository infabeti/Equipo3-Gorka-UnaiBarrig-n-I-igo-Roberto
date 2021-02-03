package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controlador.ControladorPanelRegistrar;
import Controlador.ControladorPanelTickets;
import Controlador.ControladorPanelUsuarios;
import Modelo.Registrar;
import Modelo.Usuarios;

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
	private JTextField nombretxt;
	private JTextField apellidotxt;
	private JTextField DNItxt;
	private JTextField contraseñatxt;
	
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
		
		nombretxt = new JTextField();
		nombretxt.setBounds(101, 82, 95, 20);
		add(nombretxt);
		nombretxt.setColumns(10);
		
		apellidotxt = new JTextField();
		apellidotxt.setBounds(101, 131, 98, 20);
		add(apellidotxt);
		
		DNItxt = new JTextField();
		DNItxt.setColumns(10);
		DNItxt.setBounds(314, 82, 95, 20);
		add(DNItxt);
		
		contraseñatxt = new JTextField();
		contraseñatxt.setBounds(314, 131, 94, 20);
		add(contraseñatxt);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 430, 2);
		add(separator);
		
		ArrayList<Registrar> lista_registrados=new ArrayList<>();

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Nombre = nombretxt.getText();
				String Apellido = apellidotxt.getText();
				String DNI = DNItxt.getText();
				String Contraseña = contraseñatxt.getText();
				Registrar nuevo_usuario = new Registrar();
				nuevo_usuario.setNombre(Nombre);
				nuevo_usuario.setApellido(Apellido);
				nuevo_usuario.setDNI(DNI);
				nuevo_usuario.setContraseña(Contraseña);
				lista_registrados.add(nuevo_usuario);
				JOptionPane.showMessageDialog(null, "El Usuario ha sido registrado");
				
			}
		});
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
