package TestModelo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Modelo.Productos;

public class TestProductos {
	private Productos producto = new Productos();
	private Productos producto1 = new Productos("Nombre2",5);
	
	@Test
	public void TestClaseProductosNombreP() {
		producto.setNombreP("Nombre");
		assertEquals("Nombre",producto.getNombreP());
		assertEquals("Nombre2",producto1.getNombreP());
}
	@Test
	public void TestClaseProductosPrecio() {
		producto.setPrecio(1);
		assertEquals(1,producto.getPrecio());
		assertEquals(5,producto1.getPrecio());
}
	@Test
	public void TestClaseProductosPrecioVent() {
		producto.setPrecioVent(10.0);
		assertEquals(10.0,producto.getPrecioVent(),0);
}
	@Test
	public void TestClaseProductosCodigo() {
		producto.setCodigo("codigo");
		assertEquals("codigo",producto.getCodigo());
}
	@Test
	public void TestClaseProductosNombre() {
		producto.setNombre("Nombre");
		assertEquals("Nombre",producto.getNombre());
}
	@Test
	public void TestClaseProductosPrecioComp() {
		producto.setPrecioComp(10.0);
		assertEquals(10.0,producto.getPrecioComp(),0);
}
	@Test
	public void TestClaseProductosFecha() {
		Date fecha = new Date();
		producto.setfechacad(fecha);
		assertEquals(fecha,producto.getfechacad());
}
	@Test
	public void TestClaseProductosToString() {
		assertEquals("Nombre2-5",producto1.toString());
}
	@Test
	public void TestClaseProductosSeparar() {
		String [] value = producto1.separar(producto1.toString());
		String[] resultado = {"Nombre2","5"};
		assertArrayEquals(resultado,value);
}
	
}
