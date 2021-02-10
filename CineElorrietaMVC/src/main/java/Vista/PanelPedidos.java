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
	private JSpinner spinner;
	private JLabel DireccionLabel;
	private JTextField DireccionTexto;
	private DefaultTableModel model;
	private JLabel PrecioFinal;
	private double precioTotal = 0;
	private JList list;
	private JLabel Aviso;
	JButton btnGuardar;
	
	
	@SuppressWarnings("unchecked")
	public PanelPedidos(ControladorPanelPedidos controladorPanelPedidos)
	{
		this.controladorPanelPedidos = controladorPanelPedidos;
		
		setLayout(null);
		
		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setBounds(226, 25, 54, 14);
		add(lblPedidos);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(39, 326, 89, 23);
		btnVolver.setFocusPainted(false);
		Color cpanel = new Color(200,194,182);
		btnVolver.setBackground(cpanel);
		add(btnVolver);
		
		btnAnadir = new JButton("A\u00F1adir\r\n");
		btnAnadir.setFocusPainted(false);
		btnAnadir.setBackground(new Color(200, 194, 182));
		btnAnadir.setBounds(110, 236, 86, 23);
		add(btnAnadir);
		
		spinner = new JSpinner();
		spinner.setBounds(217, 98, 41, 23);
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		add(spinner);
		
		list = new JList();
		list.setBounds(39, 85, 157, 140);
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
		DireccionLabel.setBounds(221, 60, 66, 14);
		DireccionLabel.setVisible(false);
		add(DireccionLabel);
		
		Aviso = new JLabel("Rellene los campos");
		Aviso.setBounds(374, 60, 115, 14);
		Aviso.setVisible(false);
		add(Aviso);
		
		DireccionTexto = new JTextField();
		DireccionTexto.setBounds(284, 57, 86, 20);
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
		
		table.setBounds(283, 86, 165, 140);
		add(table);
		
		PrecioFinal = new JLabel("0");
		PrecioFinal.setBackground(Color.WHITE);
		PrecioFinal.setForeground(Color.BLACK);
		PrecioFinal.setBounds(402, 237, 46, 14);
		add(PrecioFinal);
		
		Localidad = new JComboBox();
		Localidad.addItem("Local");
		Localidad.addItem("Domicilio");
		Localidad.setBackground(SystemColor.activeCaption);
		Localidad.setToolTipText("");
		Localidad.setBounds(104, 55, 86, 22);
		add(Localidad);
		
		JLabel totalTexto = new JLabel("Total:");
		totalTexto.setBounds(358, 237, 54, 14);
		add(totalTexto);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(374, 326, 89, 23);
		add(btnGuardar);
		
		
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
		this.btnGuardar.addActionListener(listenerBotonGuardar(this.controladorPanelPedidos));
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
	
	private ActionListener listenerBotonGuardar(ControladorPanelPedidos controladorPanelPedidos) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				boolean comprobar = comprobarCampos();
				if (comprobar == true) {
					// controladorPanelPedidos.accionadoBottonGuardarPanelPedidos();
				}
			}
		};
	}
	
	//Este metodo comprueba si se ha selecionado 1 producto como minimo
		public boolean comprobarCampos() {
			boolean si = false;
			if(table.getRowCount() == 0 ) {
				Aviso.setVisible(true);
			} 
			else if (Localidad.getSelectedItem() == "Domicilio" && table.getRowCount() > 0) {
					if (DireccionTexto.getText().length()==0) {
						Aviso.setVisible(true);
					}else {
						Aviso.setVisible(false);
						return si = true;
					}
			}else {
				Aviso.setVisible(false);
				return si = true;
			}
			return si;
			} 
	}
	
