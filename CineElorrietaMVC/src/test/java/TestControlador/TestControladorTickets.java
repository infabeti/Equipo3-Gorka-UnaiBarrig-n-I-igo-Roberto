package TestControlador;

import static org.junit.Assert.*;

import org.junit.Test;

import Controlador.ControladorPanelTickets;
import Modelo.Productos;

public class TestControladorTickets {
	private ControladorPanelTickets controlador=new ControladorPanelTickets();
	private Productos [] arr=new Productos[1];
	@SuppressWarnings("deprecation")
	@Test
	public void TestAccionadoBottonAnadirPanelTickets() {
		arr[0]=new Productos("kass",5);
		
		String[] elegidos = controlador.accionadoBottonAnadirPanelTickets(arr[0], 2);

		String[] resultadoproductosesperado= new String[4];
		resultadoproductosesperado[0]= ("kass");
		resultadoproductosesperado[1]= ("2");
		resultadoproductosesperado[2]= ("10");
		resultadoproductosesperado[3]= ("10");
		
		assertArrayEquals(resultadoproductosesperado,elegidos);
	}

}
