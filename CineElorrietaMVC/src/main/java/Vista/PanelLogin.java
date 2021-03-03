package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Controlador.ControladorPanelTickets;
import Controlador.ControladorPanelLogin;
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
public class PanelLogin extends JPanel {

	private JButton btnRegistrar;
	private JButton btnIngresar;
	private JLabel lblUsuario;
	private JLabel lblDNI;
	private JLabel lblContrase�a;

	private ControladorPanelLogin controladorPanelLogin;
	private JTextField nombretxt;
	private JTextField contrase�atxt; 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelLogin(ControladorPanelLogin controladorPanelLogin)
	{
		this.controladorPanelLogin = controladorPanelLogin;
		setLayout(null);
		
		lblUsuario = new JLabel("Inicio de Sesion");
		lblUsuario.setBounds(184, 25, 115, 14);
		add(lblUsuario);
		
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(83, 85, 104, 14);
		add(lblDNI);
		
		lblContrase�a = new JLabel("Contrase\u00F1a:");
		lblContrase�a.setBounds(83, 134, 104, 14);
		add(lblContrase�a);
		
		nombretxt = new JTextField();
		nombretxt.setBounds(184, 82, 150, 20);
		add(nombretxt);
		nombretxt.setColumns(10);
		
		contrase�atxt = new JTextField();
		contrase�atxt.setColumns(10);
		contrase�atxt.setBounds(184, 131, 150, 20);
		add(contrase�atxt);
		
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
		this.btnIngresar.addActionListener(listenerBotonIngresar(this.controladorPanelLogin));
		this.btnRegistrar.addActionListener(listenerBotonRegistrar(this.controladorPanelLogin));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	}
	
	private ActionListener listenerBotonIngresar(ControladorPanelLogin controladorPanelLogin) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Ingresar");
				Usuarios [] usuarios =aumentarArrUsu(controladorPanelLogin.DevolverUsuariosPanelLogin());
				String DNIIntroducido = nombretxt.getText();
				String Contrase�aIntroducida = contrase�atxt.getText();

				String nombre1 = usuarios[0].getDNI();
				String contrase�a1 = usuarios[0].getContrase�a();

				if(DNIIntroducido.equals(nombre1) && Contrase�aIntroducida.equals(contrase�a1)) 
				{
					JOptionPane.showMessageDialog(null, "El Usuario ha iniciado sesion");
					controladorPanelLogin.accionadoBottonRegistrarPanelLogin();
				}
				else {
						JOptionPane.showMessageDialog(null, "El Usuario introducido no esta registrado");
						
				}
				controladorPanelLogin.accionadoBottonIngresarPanelLoginBienvenida();
			}
		};
	}	
	
	private ActionListener listenerBotonRegistrar(ControladorPanelLogin controladorPanelUsuarios) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Registrar");
				controladorPanelUsuarios.accionadoBottonRegistrarPanelLogin();
			}
		};
	}
	public Usuarios[] aumentarArrUsu(Usuarios[] Usuario) {
		Usuarios[] temp = new Usuarios[Usuario.length];
		for (int i = 0; i<Usuario.length;i++) {
			temp[i] = Usuario[i];
		}
		return Usuario = Arrays.copyOf(temp ,Usuario.length);
		
	}
}
