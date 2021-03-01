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
import Controlador.ControladorPanelTickets;
import Controlador.ControladorPanelUsuarios;
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
	private JLabel lblContrasea;

	private ControladorPanelUsuarios controladorPanelUsuarios;
	private JTable table;
	private JTextField nombretxt;
	private JTextField contrase�atxt;
	private int i=0; 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelLogin(ControladorPanelUsuarios controladorPanelUsuarios)
	{
		this.controladorPanelUsuarios = controladorPanelUsuarios;
		setLayout(null);
		
		lblUsuario = new JLabel("Inicio de Sesion");
		lblUsuario.setBounds(184, 25, 115, 14);
		add(lblUsuario);
		
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(83, 85, 104, 14);
		add(lblDNI);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(83, 134, 104, 14);
		add(lblContrasea);
		
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
		
		String usu[]=new String[100];
		
		btnRegistrar = new JButton("Registrar");
		/*btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Usuario = nombretxt.getText();
				String Contrase�a = contrase�atxt.getText();
				Usuarios nuevo_usuario = new Usuarios();
				nuevo_usuario.setDNI(Usuario);
				nuevo_usuario.setContrase�a(Contrase�a);
				lista_usuarios.add(nuevo_usuario);
				JOptionPane.showMessageDialog(null, "El Usuario ha sido registrado");
				
			}
		});*/
		btnRegistrar.setBounds(171, 211, 89, 23);
		add(btnRegistrar);
		
		ArrayList<Usuarios> lista_usuarios=new ArrayList<>();
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] values = controladorPanelUsuarios.pasarString();
				String Usuario = nombretxt.getText();
				String Contrase�a = contrase�atxt.getText();
				Usuarios nuevo_usuario = new Usuarios();
				String nombre=values[i].substring(0,9);
				String cont=values[i].substring(10,values[0].length());
				if(nombre.equals(Usuario) && cont.equals(Contrase�a)) 
				{
					nuevo_usuario.setDNI(Usuario);
					nuevo_usuario.setContrase�a(Contrase�a);
					lista_usuarios.add(nuevo_usuario);
					JOptionPane.showMessageDialog(null, "El Usuario ha iniciado sesion");
				}
				else {
					
						JOptionPane.showMessageDialog(null, "El Usuario introducido no esta registrado");
						controladorPanelUsuarios.accionadoBottonRegistrarPanelUsuarios();
				}
				i++;
			}
		});
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
				controladorPanelUsuarios.accionadoBottonRegistrarPanelUsuarios();
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