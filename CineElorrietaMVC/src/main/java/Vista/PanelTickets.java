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

@SuppressWarnings("serial")
public class PanelTickets extends JPanel {

	private JButton btnVolver;
	private JButton btnAñadir;
	private JLabel lblTickets;

	private ControladorPanelTickets controladorPanelTickets;
	private JTable table;
	
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
		
		
		JList list_1 = new JList();
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
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(185, 59, 41, 23);
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		add(spinner);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 29, 51, 22);
		add(textArea);
		
		table = new JTable();
		table.setBounds(236, 60, 165, 141);
		add(table);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(355, 212, 46, 14);
		add(lblNewLabel);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selec = list_1.getSelectedValue().toString();
				Integer valor = (Integer)spinner.getValue();
					
			}
		});
		btnAñadir.setBounds(117, 211, 89, 23);
		add(btnAñadir);
		
		
		
		
		
		
		
		
		
		initializeEvents();
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
				controladorPanelTickets.accionadoBottonAñadirPanelTickets();
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
