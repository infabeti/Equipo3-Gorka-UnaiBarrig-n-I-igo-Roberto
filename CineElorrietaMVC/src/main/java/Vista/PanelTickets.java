package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import Controlador.ControladorPanelTickets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelTickets extends JPanel {

	private JButton btnVolver;
	private JButton btnAnadir;
	private JButton btnGuardar;
	private JLabel lblTickets;
	@SuppressWarnings("rawtypes")
	private JList list_1;
	private JSpinner spinner;
	private JTable table;
	private JLabel PrecioFinal;
	private ControladorPanelTickets controladorPanelTickets;
	private JTextField NIF;
	private JTextField Apellido;
	private JTextField Nombre;
	private JCheckBox Factura;
	private JLabel TextoNIF;
	private JLabel TextoNombre;
	private JLabel TextoApellido;
	private DefaultTableModel model;
	private JLabel Aviso;
	private JTextField cont;
	private JTextField LocalTexto;
	private JButton btnEliminar;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelTickets(ControladorPanelTickets controladorPanelTickets) throws SQLException {
		this.controladorPanelTickets = controladorPanelTickets;
		setLayout(null);

		lblTickets = new JLabel("Tickets");
		lblTickets.setBounds(210, 15, 115, 14);

		add(lblTickets);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(33, 423, 89, 23);
		btnVolver.setFocusPainted(false);
		Color cpanel = new Color(200, 194, 182);
		btnVolver.setBackground(cpanel);
		add(btnVolver);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(367, 423, 89, 23);
		btnGuardar.setFocusPainted(false);

		btnGuardar.setBackground(cpanel);
		add(btnGuardar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(265, 315, 89, 23);
		btnEliminar.setFocusPainted(false);

		btnEliminar.setBackground(cpanel);
		add(btnEliminar);

		list_1 = new JList();
		list_1.setBounds(33, 205, 155, 141);
		list_1.setModel(new AbstractListModel() {
			String[] values = controladorPanelTickets.stringProductos();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		add(list_1);

		spinner = new JSpinner();
		spinner.setBounds(198, 202, 41, 23);
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		add(spinner);

		PrecioFinal = new JLabel("0");
		PrecioFinal.setBackground(Color.WHITE);
		PrecioFinal.setForeground(Color.BLACK);
		PrecioFinal.setBounds(398, 297, 46, 14);
		add(PrecioFinal);

		btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAnadir.setBounds(265, 293, 89, 23);
		btnAnadir.setFocusPainted(false);
		btnAnadir.setBackground(cpanel);
		add(btnAnadir);

		JLabel lblNumeroDeCompra = new JLabel("Numero de Ticket:");
		lblNumeroDeCompra.setBounds(22, 15, 115, 14);
		add(lblNumeroDeCompra);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(364, 297, 115, 14);
		add(lblTotal);

		String col[] = { "Producto", "Cantidad", "Precio/Cant" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Producto", "Cantidad", "Precio/Cant" }));

		table.setBounds(263, 206, 165, 80);
		add(table);

		Factura = new JCheckBox("Factura");
		Factura.setBounds(33, 80, 97, 23);
		Factura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Factura.isSelected() == true) {
					NIF.setVisible(true);
					Apellido.setVisible(true);
					Nombre.setVisible(true);
					TextoNIF.setVisible(true);
					TextoNombre.setVisible(true);
					TextoApellido.setVisible(true);
				} else {
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
		NIF.setBounds(54, 134, 86, 20);
		NIF.setVisible(false);
		add(NIF);
		NIF.setColumns(10);

		Apellido = new JTextField();
		Apellido.setColumns(10);
		Apellido.setBounds(320, 134, 86, 20);
		Apellido.setVisible(false);
		add(Apellido);

		Nombre = new JTextField();
		Nombre.setColumns(10);
		Nombre.setBounds(188, 134, 86, 20);
		Nombre.setVisible(false);
		add(Nombre);

		TextoNIF = new JLabel("NIF");
		TextoNIF.setBounds(90, 119, 46, 14);
		TextoNIF.setVisible(false);
		add(TextoNIF);

		TextoNombre = new JLabel("Nombre");
		TextoNombre.setBounds(209, 119, 46, 14);
		TextoNombre.setVisible(false);
		add(TextoNombre);

		TextoApellido = new JLabel("Apellido");
		TextoApellido.setBounds(341, 119, 46, 14);
		TextoApellido.setVisible(false);
		add(TextoApellido);

		JLabel fechaTexto = new JLabel("Fecha:");
		fechaTexto.setBounds(284, 56, 180, 14);
		fechaTexto.setText("Fecha: " + controladorPanelTickets.getFecha());
		add(fechaTexto);

		Aviso = new JLabel("Rellene los campos");
		Aviso.setBackground(Color.RED);
		Aviso.setForeground(Color.BLACK);
		Aviso.setBounds(320, 165, 115, 14);
		Aviso.setVisible(false);
		add(Aviso);

		cont = new JTextField();
		cont.setText(controladorPanelTickets.getContador());
		cont.setEditable(false);
		cont.setColumns(10);
		cont.setBounds(127, 12, 54, 20);
		add(cont);

		LocalTexto = new JTextField();
		LocalTexto.setEditable(false);
		LocalTexto.setBounds(291, 12, 115, 20);
		LocalTexto.setText(controladorPanelTickets.getNombreLocal());
		add(LocalTexto);
		LocalTexto.setColumns(10);

		initializeEvents();
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTickets));
		this.btnAnadir.addActionListener(listenerBotonAnadir(this.controladorPanelTickets));
		this.btnGuardar.addActionListener(listenerBotonGuardar(this.controladorPanelTickets));
		this.btnEliminar.addActionListener(listenerBotonEliminar(this.controladorPanelTickets));

	}

	private ActionListener listenerBotonVolver(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelTickets.accionadoBottonVolverPanelTickets();
				controladorPanelTickets.borrarTotalTickets();
			}
		};
	}

	private ActionListener listenerBotonAnadir(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir");
				String[] ProductoSeleccionado = controladorPanelTickets
						.accionadoBottonAnadirPanelTickets(list_1.getSelectedValue(), (int) spinner.getValue());
				Object[] objs = { ProductoSeleccionado[0], ProductoSeleccionado[1], ProductoSeleccionado[2] };
				model = (DefaultTableModel) table.getModel();
				model.addRow(objs);
				PrecioFinal.setText(ProductoSeleccionado[3]);
			}
		};
	}

	private ActionListener listenerBotonGuardar(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Guardar");
				boolean comprobar = comprobarCamposFactura();
				if (comprobar == true) {
					try {
						controladorPanelTickets.insertTickets(cont.getText(), NIF.getText(), Nombre.getText(),
								Apellido.getText(), Factura.isSelected());
						controladorPanelTickets.borrarTotalTickets();
						controladorPanelTickets.accionadoBottonVolverPanelTickets();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
	}

	private ActionListener listenerBotonEliminar(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.removeRow(table.getSelectedRow());
				String total = controladorPanelTickets.accionadoBottonEliminarTotal();
				PrecioFinal.setText(total);
			}
		};
	}

	// Este metodo comprueba si se ha selecionado 1 producto como minimo
	public boolean comprobarCamposFactura() {
		boolean si = false;
		if (table.getRowCount() == 0) {
			Aviso.setVisible(true);
			return si = false;
		} else if (table.getRowCount() > 0 && Factura.isSelected() == true) {
			if (NIF.getText().length() == 0 || Nombre.getText().length() == 0 || Apellido.getText().length() == 0) {
				Aviso.setVisible(true);
				return si = false;
			} 
		} else {
			Aviso.setVisible(false);
			return si = true;
		}
		return si;

	}
}
