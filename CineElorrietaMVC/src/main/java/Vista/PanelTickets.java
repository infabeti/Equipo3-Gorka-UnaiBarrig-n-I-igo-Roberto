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

@SuppressWarnings("serial")
public class PanelTickets extends JPanel {

	private JButton btnVolver;
	private JButton btnAñadir;
	private JLabel lblTickets;
	private JList list_1;
	private JSpinner spinner;
	private JTable table;
	private ControladorPanelTickets controladorPanelTickets;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelTickets(ControladorPanelTickets controladorPanelTickets)
	{
		this.controladorPanelTickets = controladorPanelTickets;
		setLayout(null);
		
		lblTickets = new JLabel("Tickets");
		lblTickets.setBounds(198, 15, 115, 14);
		add(lblTickets);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 211, 89, 23);
		add(btnVolver);
		
		
		list_1 = new JList();
		list_1.setBounds(20, 59, 155, 141);
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
		spinner.setBounds(185, 59, 41, 23);
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		add(spinner);
		
		JTextArea cont = new JTextArea();
		cont.setText("1");
		cont.setBounds(110, 10, 26, 22);
		add(cont);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1, 2, 3, 4},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Producto", "Cantidad", "Precio/Cant", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(236, 60, 165, 80);
		add(table);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(355, 212, 46, 14);
		add(lblNewLabel);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(controladorPanelTickets.entrega());
				
			}
		});
		btnAñadir.setBounds(117, 211, 89, 23);
		add(btnAñadir);
		
		JLabel lblNumeroDeCompra = new JLabel("Numero de compra:");
		lblNumeroDeCompra.setBounds(10, 15, 115, 14);
		add(lblNumeroDeCompra);
		
		
		
		
		
		
		
		
		
		initializeEvents();
	}
	
	private int calcularPrecioCant(int valor,int preciobase) {
		int precio = valor+preciobase;
		return precio;
	}
	

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTickets));
		this.btnAñadir.addActionListener(listenerBotonAñadir(this.controladorPanelTickets));
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
			}
		};
	}
	
	private ActionListener listenerBotonGuardar(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Guardar");
				controladorPanelTickets.accionadoBottonGuardarPanelTickets();
			}
		};
	}
}
