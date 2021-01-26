package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import Controlador.ControladorPanelTickets;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class PanelTickets extends JPanel {

	private JButton btnVolver;
	private JLabel lblTickets;
	private int contP1 = 0;
	private int contP2 = 100;

	private ControladorPanelTickets controladorPanelTickets;
	
	public PanelTickets(ControladorPanelTickets controladorPanelTickets)
	{
		this.controladorPanelTickets = controladorPanelTickets;
		setLayout(null);
		
		lblTickets = new JLabel("Tickets");
		lblTickets.setBounds(198, 15, 115, 14);
		add(lblTickets);
		
		JList list_1_1 = new JList();
		list_1_1.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1_1.setBounds(260, 52, 155, 138);
		add(list_1_1);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(34, 239, 89, 23);
		add(btnVolver);
		
		JList list_1 = new JList();
		list_1.setBounds(34, 52, 155, 138);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"producto 1", "producto 2", "producto 3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		add(list_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(199, 59, 41, 23);
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		add(spinner);
		
		JButton btnNewButton = new JButton("A�adir");
		btnNewButton.setBounds(100, 205, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Nombre del producto
				String selec = list_1.getSelectedValue().toString();
				
				Integer valor = (Integer)spinner.getValue();
				String numero = String.valueOf(valor);
				String numeros=numero.concat(numero);
				String texto = selec+": Cant: "+numero+"\n";
				
				
				JList list_1_1 = new JList();
				DefaultListModel modelo = new DefaultListModel();
				modelo.addElement(texto);
				list_1_1.setModel(modelo);
				
				
			}

		
		});
		add(btnNewButton);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selec = list_1_1.getSelectedValue().toString();
				
				
			}
		});
		btnEliminar.setBounds(270, 201, 89, 23);
		add(btnEliminar);
		
		
		
		
		
		
		
		
		
		initializeEvents();
	}
	
	protected int parseInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelTickets));
	}
	
	private ActionListener listenerBotonVolver(ControladorPanelTickets controladorPanelTickets) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelTickets.accionadoBottonVolverPanelTickets();
			}
		};
	}
}
