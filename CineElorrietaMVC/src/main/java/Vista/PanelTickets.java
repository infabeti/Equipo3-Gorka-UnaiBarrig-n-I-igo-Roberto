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
	private int precioTotal = 0;
	
	
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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Factura");
		chckbxNewCheckBox.setBounds(50, 220, 97, 23);
		add(chckbxNewCheckBox);
	
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
				 int numEntero = Integer.parseInt(values[1]);
				 int spinnerInt = (int) spinner.getValue();
				 int precioCant = spinnerInt*numEntero;
				Object[] objs = {values[0],spinner.getValue(),precioCant};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(objs);
				
				precioTotal = precioTotal+precioCant;
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
