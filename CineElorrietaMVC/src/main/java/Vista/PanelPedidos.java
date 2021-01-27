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
import java.awt.SystemColor;
import java.awt.Choice;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class PanelPedidos extends JPanel {

	private JButton btnVolver;
	private JButton btnAñadir;
	private JLabel lblPedidos;
	private ControladorPanelPedidos controladorPanelPedidos;
	private JTextField textField;
	private JComboBox combo;
	
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		this.controladorPanelPedidos = controladorPanelPedidos;
		
		setLayout(null);
		
		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setBounds(198, 25, 54, 14);
		add(lblPedidos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(35, 234, 89, 23);
		btnVolver.setFocusPainted(false);
		Color cpanel = new Color(200,194,182);
		btnVolver.setBackground(cpanel);
		add(btnVolver);
		
		btnAñadir = new JButton("A\u00F1adir\r\n");
		btnAñadir.setFocusPainted(false);
		btnAñadir.setBackground(new Color(200, 194, 182));
		btnAñadir.setBounds(135, 234, 89, 23);
		add(btnAñadir);
		
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
		list.setBounds(35, 68, 140, 140);
		add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(274, 97, 140, 140);
		add(list_1);
		
		JLabel lblNewLabel = new JLabel("Direccion:\r\n");
		lblNewLabel.setBounds(284, 69, 66, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(347, 66, 86, 20);
		add(textField);
		textField.setColumns(10);
		String variableDeTexto;
		variableDeTexto =textField.getText();




		
		combo = new JComboBox();
		combo.addItem("Local");
		combo.addItem("Domicilio");
		combo.setBackground(SystemColor.activeCaption);
		combo.setToolTipText("");
		combo.setBounds(347, 25, 86, 22);
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
		this.btnAñadir.addActionListener(listenerBotonVolver(this.controladorPanelPedidos));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelPedidos.accionadoBottonVolverPanelPedidos();
			}
		};
	}
	private ActionListener listenerBotonAñadir(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir");
				controladorPanelPedidos.accionadoBottonAñadirPanelPedidos();
			}
		};
	}
}
