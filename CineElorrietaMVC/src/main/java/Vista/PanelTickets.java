package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(263, 52, 131, 138);
		add(textPane);
		
		lblTickets = new JLabel("Tickets");
		lblTickets.setBounds(198, 15, 115, 14);
		add(lblTickets);
		
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(34, 239, 89, 23);
		add(btnVolver);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"producto 1", "producto 2", "producto 3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(34, 52, 155, 138);
		add(list_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setBounds(199, 59, 41, 23);
		add(spinner);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selec = list_1.getSelectedValue().toString();
				Integer valor = (Integer)spinner.getValue();
				String numero = String.valueOf(valor);
				textPane.setText(selec+": Cant: "+numero);
			}
		});
		btnNewButton.setBounds(100, 205, 89, 23);
		add(btnNewButton);
		
		
		
		
		
		
		
		initializeEvents();
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
