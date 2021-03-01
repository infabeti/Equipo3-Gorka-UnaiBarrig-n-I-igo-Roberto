package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Productos;
import Modelo.BDD;

public class TestBDD {
	private BDD BDD = new BDD();
	private Productos [] resultadoproductosesperado=new Productos[6];
	private Productos[] resultadoproductos;
	
	@Test
	public void consultaProductosBDD() {
		resultadoproductosesperado[0]=new Productos("kass",5);
		resultadoproductosesperado[1]=new Productos("cocacola",5);
		resultadoproductosesperado[2]=new Productos("cafe",5);
		resultadoproductosesperado[3]=new Productos("pintxos",5);
		resultadoproductosesperado[4]=new Productos("pastel",5);
		resultadoproductosesperado[5]=new Productos("pistachos",5);
		
		resultadoproductos  = BDD.getProductos();
		
		for(int i = 0;i<resultadoproductos.length;i++) {
		assertEquals(resultadoproductosesperado[i].getNombreP(),resultadoproductos[i].getNombreP());
		assertEquals(resultadoproductosesperado[i].getPrecio(),resultadoproductos[i].getPrecio());
		}
	}
	
	@Test
	public void consultaProductosBDDsetget() {
		resultadoproductosesperado[0]=new Productos();
		resultadoproductosesperado[1]=new Productos();
		resultadoproductosesperado[2]=new Productos();
		resultadoproductosesperado[3]=new Productos();
		resultadoproductosesperado[4]=new Productos();
		resultadoproductosesperado[5]=new Productos();
		resultadoproductosesperado[0].setNombreP("kass");
		resultadoproductosesperado[0].setPrecio(5);
		resultadoproductosesperado[1].setNombreP("cocacola");
		resultadoproductosesperado[1].setPrecio(5);
		resultadoproductosesperado[2].setNombreP("cafe");
		resultadoproductosesperado[2].setPrecio(5);
		resultadoproductosesperado[3].setNombreP("pintxos");
		resultadoproductosesperado[3].setPrecio(5);
		resultadoproductosesperado[4].setNombreP("pastel");
		resultadoproductosesperado[4].setPrecio(5);
		resultadoproductosesperado[5].setNombreP("pistachos");
		resultadoproductosesperado[5].setPrecio(5);
	
		resultadoproductos  = BDD.getProductos();
		
		for(int i = 0;i<resultadoproductos.length;i++) {
		assertEquals(resultadoproductosesperado[i].getNombreP(),resultadoproductos[i].getNombreP());
		assertEquals(resultadoproductosesperado[i].getPrecio(),resultadoproductos[i].getPrecio());
		}
	}
	
	

}