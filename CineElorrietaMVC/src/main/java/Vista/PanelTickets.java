package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import Controlador.ControladorPanelTickets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelTickets extends JPanel {

	private JButton btnVolver;
	private JButton btnAñadir;
	private JButton btnGuardar;
	private JLabel lblTickets;
	private JList list_1;
	private JSpinner spinner;
	private JTable table;
	private JTextArea cont;
	private JLabel lblNewLabel;
	private ControladorPanelTickets controladorPanelTickets;
	private double precioTotal = 0;
	private JTextField NIF;
	private JTextField Apellido;
	private JTextField Nombre;
	private JCheckBox Factura;
	private JLabel TextoNIF;
	private JLabel TextoNombre;
	private JLabel TextoApellido;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelTickets(ControladorPanelTickets controladorPanelTickets)
	{
		this.controladorPanelTickets = controladorPanelTickets;
		setLayout(null);
		
		lblTickets = new JLabel("Tickets");
		lblTickets.setBounds(227, 15, 115, 14);
		add(lblTickets);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(33, 423, 89, 23);
		add(btnVolver);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(367, 423, 89, 23);
		add(btnGuardar);
		
		
		list_1 = new JList();
		list_1.setBounds(45, 59, 155, 141);
		list_1.setModel(new AbstractListModel() {
			String[] values = controladorPanelTickets.pasarString();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		add(list_1);
		
		spinner = new JSpinner();
		spinner.setBounds(210, 56, 41, 23);
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		add(spinner);
		
		cont = new JTextArea();
		cont.setEditable(false);
		cont.setText("1");
		cont.setBounds(147, 10, 26, 22);
		add(cont);
		
		
		
		lblNewLabel = new JLabel("0");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(410, 151, 46, 14);
		
		add(lblNewLabel);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnAñadir.setBounds(277, 147, 89, 23);
		add(btnAñadir);
		
		JLabel lblNumeroDeCompra = new JLabel("Numero de compra:");
		lblNumeroDeCompra.setBounds(22, 15, 115, 14);
		add(lblNumeroDeCompra);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(376, 151, 115, 14);
		add(lblTotal);
		
		
		String col[] = {"Producto", "Cantidad", "Precio/Cant"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Producto", "Cantidad", "Precio/Cant"
			}
		));
		table.setBounds(275, 60, 165, 80);
		add(table);
		
		Factura = new JCheckBox("Factura");
		Factura.setBounds(50, 220, 97, 23);
		Factura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Factura.isSelected() == true) {
					NIF.setVisible(true);
					Apellido.setVisible(true);
					Nombre.setVisible(true);
					TextoNIF.setVisible(true);
					TextoNombre.setVisible(true);
					TextoApellido.setVisible(true);
				}else {
					NIF.setVisible(false);
					Apellido.setVisible(false);
					Nombre.setVisible(false);
					TextoNIF.setVisible(false);
					TextoNombre.setVisible(false);
					TextoApellido.setVisible(false);
				}
			}
		});
	
		add(Factura);
		
		NIF = new JTextField();
		NIF.setBounds(72, 321, 86, 20);
		NIF.setVisible(false);
		add(NIF);
		NIF.setColumns(10);
		
		Apellido = new JTextField();
		Apellido.setColumns(10);
		Apellido.setBounds(338, 321, 86, 20);
		Apellido.setVisible(false);
		add(Apellido);
		
		Nombre = new JTextField();
		Nombre.setColumns(10);
		Nombre.setBounds(206, 321, 86, 20);
		Nombre.setVisible(false);
		add(Nombre);
		
		TextoNIF = new JLabel("NIF");
		TextoNIF.setBounds(108, 306, 46, 14);
		TextoNIF.setVisible(false);
		add(TextoNIF);
		
		TextoNombre = new JLabel("Nombre");
		TextoNombre.setBounds(227, 306, 46, 14);
		TextoNombre.setVisible(false);
		add(TextoNombre);
		
		TextoApellido = new JLabel("Apellido");
		TextoApellido.setBounds(359, 306, 46, 14);
		TextoApellido.setVisible(false);
		add(TextoApellido);
	
		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTickets));
		this.btnAñadir.addActionListener(listenerBotonAñadir(this.controladorPanelTickets));
		this.btnGuardar.addActionListener(listenerBotonGuardar(this.controladorPanelTickets));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelTickets.accionadoBottonVolverPanelTickets();
			}
		};
	}
	private ActionListener listenerBotonAñadir(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir");
				controladorPanelTickets.accionadoBottonAñadirPanelTickets(list_1.getSelectedValue());
				String[] values = ControladorPanelTickets.setSeparado();
				 double numEntero = Double.parseDouble(values[1]);
				 double spinnerInt = (int) spinner.getValue();
				 double precioCant = spinnerInt*numEntero;
				Object[] objs = {values[0],spinner.getValue(),precioCant};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(objs);
				
				precioTotal = ControladorPanelTickets.suma(precioTotal,precioCant);
				String total = String.valueOf(precioTotal);		
				lblNewLabel.setText(total);
			}
		};
	}
	
	private ActionListener listenerBotonGuardar(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Guardar");
				
			}
		};
	}
}
