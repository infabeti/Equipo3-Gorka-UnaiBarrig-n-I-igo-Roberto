package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorPanelPedidos;
import Controlador.ControladorPanelTickets;
import Modelo.Modelo;

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
	private JSpinner spinner;
	private JLabel DireccionLabel;
	private JTextField DireccionTexto;
	private DefaultTableModel model;
	private JLabel PrecioFinal;
	private double precioTotal = 0;
	private JList list;
	private JLabel Aviso;
	JButton btnGuardar;
	private JTextField cont;
	private JButton btnEliminar;
	private JTextField localtxt;

	@SuppressWarnings("unchecked")
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos) throws SQLException {
		this.controladorPanelPedidos = controladorPanelPedidos;

		setLayout(null);

		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setBounds(226, 25, 54, 14);
		add(lblPedidos);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(283, 266, 89, 23);
		Color cpanel = new Color(200, 194, 182);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setBackground(cpanel);
		add(btnEliminar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(39, 326, 89, 23);
		btnVolver.setFocusPainted(false);
		btnVolver.setBackground(cpanel);
		add(btnVolver);

		btnAnadir = new JButton("A\u00F1adir\r\n");
		btnAnadir.setFocusPainted(false);
		btnAnadir.setBackground(new Color(200, 194, 182));
		btnAnadir.setBounds(106, 266, 86, 23);
		add(btnAnadir);

		spinner = new JSpinner();
		spinner.setBounds(220, 161, 41, 23);
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		add(spinner);

		list = new JList();
		list.setBounds(41, 115, 157, 140);
		list.setModel(new AbstractListModel() {
			String[] values = controladorPanelPedidos.stringProductos();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		add(list);

		DireccionLabel = new JLabel("Direccion:\r\n");
		DireccionLabel.setBounds(283, 90, 66, 14);
		DireccionLabel.setVisible(false);
		add(DireccionLabel);

		Aviso = new JLabel("Rellene los campos");
		Aviso.setBounds(193, 300, 115, 14);
		Aviso.setVisible(false);
		add(Aviso);

		DireccionTexto = new JTextField();
		DireccionTexto.setBounds(345, 87, 86, 20);
		DireccionTexto.setVisible(false);
		add(DireccionTexto);
		DireccionTexto.setColumns(10);
		String variableDeTexto;
		variableDeTexto = DireccionTexto.getText();

		String col[] = { "Producto", "Cantidad", "Precio/Cant" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Producto", "Cantidad", "Precio/Cant" }));

		table.setBounds(285, 116, 165, 140);
		add(table);

		PrecioFinal = new JLabel("0");
		PrecioFinal.setBackground(Color.WHITE);
		PrecioFinal.setForeground(Color.BLACK);
		PrecioFinal.setBounds(417, 301, 46, 14);
		add(PrecioFinal);

		Localidad = new JComboBox();
		Localidad.addItem("Local");
		Localidad.addItem("Domicilio");
		Localidad.setBackground(SystemColor.activeCaption);
		Localidad.setToolTipText("");
		Localidad.setBounds(42, 86, 86, 22);
		add(Localidad);

		JLabel totalTexto = new JLabel("Total:");
		totalTexto.setBounds(369, 301, 54, 14);
		add(totalTexto);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(374, 326, 89, 23);
		btnGuardar.setFocusPainted(false);
		btnGuardar.setBackground(cpanel);
		add(btnGuardar);

		JLabel lblNewLabel = new JLabel("Numero de pedido:");
		lblNewLabel.setBounds(27, 25, 115, 14);
		add(lblNewLabel);

		cont = new JTextField();
		cont.setEditable(false);
		cont.setBounds(142, 22, 54, 20);
		cont.setText(controladorPanelPedidos.getContador());
		cont.setColumns(10);
		add(cont);
		
		localtxt = new JTextField();
		localtxt.setEditable(false);
		localtxt.setColumns(10);
		localtxt.setBounds(308, 22, 115, 20);
		localtxt.setText(controladorPanelPedidos.getNombreLocal());
		add(localtxt);

		Localidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String Direccion = variableDeTexto;
				if (Localidad.getSelectedItem() == "Local") {
					DireccionTexto.setVisible(false);
					DireccionLabel.setVisible(false);
				} else if (Localidad.getSelectedItem() == "Domicilio") {
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
		this.btnGuardar.addActionListener(listenerBotonGuardar(this.controladorPanelPedidos));
		this.btnEliminar.addActionListener(listenerBotonEliminar(this.controladorPanelPedidos));
	}

	private ActionListener listenerBotonEliminar(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
				tablemodel.removeRow(table.getSelectedRow());
				String total = controladorPanelPedidos.accionadoBottonEliminarTotal();
				PrecioFinal.setText(total);
			}
		};
	}

	private ActionListener listenerBotonVolver(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelPedidos.accionadoBottonVolverPanelPedidos();
				controladorPanelPedidos.borrarTotalTickets();
			}
		};
	}

	private ActionListener listenerBotonAnadir(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Añadir");

				try {
					Object[][] objs = controladorPanelPedidos.accionadoBottonAnadirPanelTickets(list.getSelectedValue(), (int) spinner.getValue());
					model = (DefaultTableModel) table.getModel();
					for(int i = model.getRowCount()-1;i>=0;i--) {
						model.removeRow(i);
					}
					for (int i = 0;i<objs.length;i++) {
						Object[] objs2 = {objs[i][0],objs[i][1],objs[i][2]};
						model.addRow(objs2);
					}
					
					PrecioFinal.setText(controladorPanelPedidos.Total());
					Aviso.setVisible(false);
					
				}
				catch(Exception E) {
					
					System.out.println("No has añadido ningún producto");
					Aviso.setVisible(true);
				}
				


			}
		};
	}

	private ActionListener listenerBotonGuardar(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				boolean comprobar = comprobarCampos();
				if (comprobar == true) {
					try {
						controladorPanelPedidos.insertPedido(DireccionTexto.getText());
						controladorPanelPedidos.borrarTotalTickets();
						controladorPanelPedidos.accionadoBottonVolverPanelPedidos();
					} catch (SQLException e) {
						System.out.println("No has añadido ningún producto");
						
					}

				}
				
				
			}
		};
	}

	// Este metodo comprueba si se ha selecionado 1 producto como minimo
	public boolean comprobarCampos() {
		boolean si = true;
		if (table.getRowCount()<= 0) {
			Aviso.setVisible(true);
			 return si = false;
		} 
		
		if (Localidad.getSelectedItem() == "Domicilio" && table.getRowCount() > 0) {
			if (DireccionTexto.getText().length() <= 0) {
				Aviso.setVisible(true);
				System.out.println("direcciontexto");
				 return si = false;
			
			}
			
		} 
		return si;
	}
}
