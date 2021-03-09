package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Controlador.ControladorPanelRegistrar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class PanelRegistrar extends JPanel {

	private JButton btnVolver;
	private JButton btnRegistrar;
	private JLabel lblTickets;
	private ControladorPanelRegistrar controladorPanelRegistrar;
	private JTable table;
	private JTextField nombretxt;
	private JTextField apellidotxt;
	private JTextField NIFtxt;
	private JTextField contraseñatxt;
	private JSeparator separator;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JTextField NIFLocaltxt;
	
	
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
		btnVolver.setFocusPainted(false);
		Color cpanel = new Color(200,194,182);
		btnVolver.setBackground(cpanel);
		add(btnVolver);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(37, 85, 54, 14);
		add(lblNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(37, 134, 54, 14);
		add(lblApellido);
		
		nombretxt = new JTextField();
		nombretxt.setBounds(101, 82, 95, 20);
		add(nombretxt);
		nombretxt.setColumns(10);
		
		apellidotxt = new JTextField();
		apellidotxt.setColumns(10);
		apellidotxt.setBounds(101, 131, 95, 20);
		add(apellidotxt);
		
		NIFtxt = new JTextField();
		NIFtxt.setColumns(10);
		NIFtxt.setBounds(314, 82, 95, 20);
		add(NIFtxt);
		
		contraseñatxt = new JTextField();
		contraseñatxt.setColumns(10);
		contraseñatxt.setBounds(314, 131, 95, 20);
		add(contraseñatxt);
		
		separator = new JSeparator();
		separator.setBounds(10, 60, 430, 2);
		add(separator);
		
		

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(320, 211, 89, 23);
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setBackground(cpanel);
		add(btnRegistrar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 245, 430, 2);
		add(separator_1);
		
		JLabel lblNIF = new JLabel("DNI:\r\n");
		lblNIF.setBounds(234, 85, 34, 14);
		add(lblNIF);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setBounds(234, 134, 135, 14);
		add(lblContrasena);
		
		JLabel lblLocal = new JLabel("NIF:");
		lblLocal.setBounds(37, 186, 92, 14);
		add(lblLocal);
		
		NIFLocaltxt = new JTextField();
		NIFLocaltxt.setColumns(10);
		NIFLocaltxt.setBounds(101, 180, 95, 20);
		add(NIFLocaltxt);

		initializeEvents();
	}
	

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelRegistrar));
		this.btnRegistrar.addActionListener(listenerBotonRegistrar(this.controladorPanelRegistrar));
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
				
			
				try {
					controladorPanelRegistrar.accionadoBottonRegistrarPanelRegistrar(nombretxt.getText(),apellidotxt.getText(),NIFtxt.getText(),contraseñatxt.getText(),NIFLocaltxt.getText());
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "El Usuario ha sido registrado");
				controladorPanelRegistrar.accionadoBottonVolverPanelRegistrar();
			}
		};
	}
	public void validarRegistro() {
		
	}
}
