package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelLogin;
import javax.swing.JTextField;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class PanelLogin extends JPanel {

	private JButton btnRegistrar;
	private JButton btnIngresar;
	private JLabel lblUsuario;
	private JLabel lblNIF;
	private JLabel lblContraseña;

	private ControladorPanelLogin controladorPanelLogin;
	private JTextField NIFtxt;
	private JTextField contraseñatxt; 
	private JLabel error;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelLogin(ControladorPanelLogin controladorPanelLogin)
	{
		this.controladorPanelLogin = controladorPanelLogin;
		setLayout(null);
		
		lblUsuario = new JLabel("Inicio de Sesion");
		lblUsuario.setBounds(184, 25, 115, 14);
		add(lblUsuario);
		
		
		lblNIF = new JLabel("NIF:");
		lblNIF.setBounds(83, 85, 104, 14);
		add(lblNIF);
		
		lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(83, 134, 104, 14);
		add(lblContraseña);
		
		NIFtxt = new JTextField();
		NIFtxt.setBounds(184, 82, 150, 20);
		add(NIFtxt);
		NIFtxt.setColumns(10);
		
		contraseñatxt = new JTextField();
		contraseñatxt.setColumns(10);
		contraseñatxt.setBounds(184, 131, 150, 20);
		add(contraseñatxt);
		
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
		
		error = new JLabel("NIF o Contraseña incorrecto");
		error.setBounds(194, 162, 163, 14);
		error.setVisible(false);
		add(error);
		
		initializeEvents();
	}
	

	private void initializeEvents() {
		this.btnIngresar.addActionListener(listenerBotonIngresar(this.controladorPanelLogin));
		this.btnRegistrar.addActionListener(listenerBotonRegistrar(this.controladorPanelLogin));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	}
	
	private ActionListener listenerBotonIngresar(ControladorPanelLogin controladorPanelLogin) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				System.out.println("Ejecutando evento Boton Ingresar");
				String NIFIntroducido = NIFtxt.getText();
				String ContrasenaIntroducida = contraseñatxt.getText();
				
				try {
						String[]usuarios = controladorPanelLogin.DevolverUsuariosPanelLogin(NIFIntroducido,ContrasenaIntroducida);
						String Local = usuarios[0];
						String NIF = usuarios[1];
						String Contrasena =  usuarios[2];
						error.setVisible(false);
						controladorPanelLogin.accionadoBottonIngresarPanelLoginBienvenida();
				}
					catch(Exception E) {
						System.out.println("Usuario incorrecto");
						error.setVisible(true);
					}
			
				
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
}
