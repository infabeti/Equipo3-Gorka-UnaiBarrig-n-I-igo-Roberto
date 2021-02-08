package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelPedidos;
import Controlador.ControladorPanelTickets;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.Choice;
import javax.swing.JSlider;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PanelPedidos extends JPanel {

	private JButton btnVolver;
	private JButton btnAnadir;
	private JLabel lblPedidos;
	private ControladorPanelPedidos controladorPanelPedidos;
	private JTextField textField;
	private JComboBox combo;
	private JTable table;
	private JLabel TextoNIF;
	private JLabel TextoNombre;
	private JLabel TextoApellido;
	private JTextField NIF;
	private JTextField Apellido;
	private JTextField Nombre;
	
	@SuppressWarnings("unchecked")
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		this.controladorPanelPedidos = controladorPanelPedidos;
		
		setLayout(null);
		
		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setBounds(198, 25, 54, 14);
		add(lblPedidos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(21, 466, 89, 23);
		btnVolver.setFocusPainted(false);
		Color cpanel = new Color(200,194,182);
		btnVolver.setBackground(cpanel);
		add(btnVolver);
		
		btnAnadir = new JButton("A\u00F1adir\r\n");
		btnAnadir.setFocusPainted(false);
		btnAnadir.setBackground(new Color(200, 194, 182));
		btnAnadir.setBounds(21, 418, 89, 23);
		add(btnAnadir);
		
		NIF = new JTextField();
		NIF.setBounds(74, 317, 86, 20);
		NIF.setVisible(false);
		add(NIF);
		NIF.setColumns(10);
		
		Apellido = new JTextField();
		Apellido.setColumns(10);
		Apellido.setBounds(340, 317, 86, 20);
		Apellido.setVisible(false);
		add(Apellido);
		
		Nombre = new JTextField();
		Nombre.setColumns(10);
		Nombre.setBounds(208, 317, 86, 20);
		Nombre.setVisible(false);
		add(Nombre);
		
		TextoNIF = new JLabel("NIF");
		TextoNIF.setBounds(110, 302, 46, 14);
		TextoNIF.setVisible(false);
		add(TextoNIF);
		
		TextoNombre = new JLabel("Nombre");
		TextoNombre.setBounds(229, 302, 46, 14);
		TextoNombre.setVisible(false);
		add(TextoNombre);
		
		TextoApellido = new JLabel("Apellido");
		TextoApellido.setBounds(361, 302, 46, 14);
		TextoApellido.setVisible(false);
		add(TextoApellido);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = controladorPanelPedidos.pasarString();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(21, 239, 157, 140);
		add(list);
		
		JLabel lblNewLabel = new JLabel("Direccion:\r\n");
		lblNewLabel.setBounds(155, 197, 66, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(218, 194, 86, 20);
		add(textField);
		textField.setColumns(10);
		String variableDeTexto;
		variableDeTexto =textField.getText();
		
		String col[] = {"Producto", "Cantidad", "Precio/Cant"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Producto", "Cantidad", "Precio/Cant"
			}
		));
		
		table.setBounds(283, 240, 165, 140);
		add(table);
		
		combo = new JComboBox();
		combo.addItem("Local");
		combo.addItem("Domicilio");
		combo.setBackground(SystemColor.activeCaption);
		combo.setToolTipText("");
		combo.setBounds(38, 192, 86, 22);
		add(combo);
		
		
		combo.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
			      // Aquí hacemos lo que queramos hacer.
				  String Direccion= variableDeTexto;
			   }
			});
		
		
		
		initializeEvents();
	}
	
	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelPedidos));
		this.btnAnadir.addActionListener(listenerBotonAnadir(this.controladorPanelPedidos));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelPedidos.accionadoBottonVolverPanelPedidos();
			}
		};
	}
	private ActionListener listenerBotonAnadir(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir");
				controladorPanelPedidos.accionadoBottonAñadirPanelPedidos();
			}
		};
	}
}
