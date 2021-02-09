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
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.Choice;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PanelPedidos extends JPanel {

	private JButton btnVolver;
	private JButton btnAnadir;
	private JLabel lblPedidos;
	private ControladorPanelPedidos controladorPanelPedidos;
	private JComboBox Localidad;
	private JTable table;
	private JLabel TextoNIF;
	private JLabel TextoNombre;
	private JLabel TextoApellido;
	private JTextField NIF;
	private JTextField Apellido;
	private JTextField Nombre;
	private JSpinner spinner;
	private JLabel DireccionLabel;
	private JTextField DireccionTexto;
	private DefaultTableModel model;
	private JLabel PrecioFinal;
	private double precioTotal = 0;
	private JList list;
	
	
	@SuppressWarnings("unchecked")
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		this.controladorPanelPedidos = controladorPanelPedidos;
		
		setLayout(null);
		
		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setBounds(226, 25, 54, 14);
		add(lblPedidos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(39, 412, 89, 23);
		btnVolver.setFocusPainted(false);
		Color cpanel = new Color(200,194,182);
		btnVolver.setBackground(cpanel);
		add(btnVolver);
		
		btnAnadir = new JButton("A\u00F1adir\r\n");
		btnAnadir.setFocusPainted(false);
		btnAnadir.setBackground(new Color(200, 194, 182));
		btnAnadir.setBounds(135, 412, 89, 23);
		add(btnAnadir);
		
		NIF = new JTextField();
		NIF.setBounds(79, 85, 86, 20);
		NIF.setVisible(true);
		NIF.setColumns(10);
		add(NIF);
		
		Apellido = new JTextField();
		Apellido.setColumns(10);
		Apellido.setBounds(345, 85, 86, 20);
		Apellido.setVisible(true);
		add(Apellido);
		
		Nombre = new JTextField();
		Nombre.setColumns(10);
		Nombre.setBounds(213, 85, 86, 20);
		Nombre.setVisible(true);
		add(Nombre);
		
		TextoNIF = new JLabel("NIF");
		TextoNIF.setBounds(115, 70, 46, 14);
		TextoNIF.setVisible(true);
		add(TextoNIF);
		
		TextoNombre = new JLabel("Nombre");
		TextoNombre.setBounds(234, 70, 46, 14);
		TextoNombre.setVisible(true);
		add(TextoNombre);
		
		TextoApellido = new JLabel("Apellido");
		TextoApellido.setBounds(366, 70, 46, 14);
		TextoApellido.setVisible(true);
		add(TextoApellido);
		
		spinner = new JSpinner();
		spinner.setBounds(217, 252, 41, 23);
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		add(spinner);
		
		list = new JList();
		list.setBounds(39, 239, 157, 140);
		list.setModel(new AbstractListModel() {
			String[] values = controladorPanelPedidos.pasarString();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		add(list);
		
		DireccionLabel = new JLabel("Direccion:\r\n");
		DireccionLabel.setBounds(238, 188, 66, 14);
		DireccionLabel.setVisible(false);
		add(DireccionLabel);
		
		DireccionTexto = new JTextField();
		DireccionTexto.setBounds(301, 185, 86, 20);
		DireccionTexto.setVisible(false);
		add(DireccionTexto);
		DireccionTexto.setColumns(10);
		String variableDeTexto;
		variableDeTexto =DireccionTexto.getText();
		
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
		
		PrecioFinal = new JLabel("0");
		PrecioFinal.setBackground(Color.WHITE);
		PrecioFinal.setForeground(Color.BLACK);
		PrecioFinal.setBounds(402, 398, 46, 14);
		add(PrecioFinal);
		
		Localidad = new JComboBox();
		Localidad.addItem("Local");
		Localidad.addItem("Domicilio");
		Localidad.setBackground(SystemColor.activeCaption);
		Localidad.setToolTipText("");
		Localidad.setBounds(121, 183, 86, 22);
		add(Localidad);
		
		JLabel totalTexto = new JLabel("Total:");
		totalTexto.setBounds(358, 398, 54, 14);
		add(totalTexto);
		
		
		Localidad.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				  String Direccion= variableDeTexto;
				  if (Localidad.getSelectedItem() == "Local") {
					  DireccionTexto.setVisible(false);
					  DireccionLabel.setVisible(false);
					}else if (Localidad.getSelectedItem() == "Domicilio") {
						DireccionTexto.setVisible(true);
						DireccionLabel.setVisible(true);
					}
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
				controladorPanelPedidos.accionadoBottonAñadirPanelPedidos(list.getSelectedValue());
				String[] values = ControladorPanelPedidos.setSeparado();
				 double numEntero = Double.parseDouble(values[1]);
				 double spinnerInt = (int) spinner.getValue();
				 double precioCant = controladorPanelPedidos.accionadoBottonAñadirPrecioCant(spinnerInt, numEntero);
				Object[] objs = {values[0],spinner.getValue(),precioCant};
				model = (DefaultTableModel) table.getModel();
				model.addRow(objs);
				precioTotal = controladorPanelPedidos.accionadoBottonAñadirTotal(precioTotal,precioCant);
				String total = String.valueOf(precioTotal);		
				PrecioFinal.setText(total);
			}
		};
	}
}
