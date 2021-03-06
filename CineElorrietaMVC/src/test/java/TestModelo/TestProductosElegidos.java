package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.ProductosElegidos;

public class TestProductosElegidos {
	private ProductosElegidos producto = new ProductosElegidos();
	private ProductosElegidos producto1 = new ProductosElegidos ("Nombre", 5.0, 2);
	private ProductosElegidos producto2 = new ProductosElegidos ("Nombre2", 5.0, 2,5.0*2);
	
	@Test
	public void TestClaseProductosElegidosNombre() {
		assertEquals("Nombre",producto1.getNombre());
		assertEquals("Nombre2",producto2.getNombre());
		producto.setNombre("Nombre3");
		assertEquals("Nombre3",producto.getNombre());
}
	@Test
	public void TestClaseProductosElegidosPrecioProducto() {
		assertEquals(5.0,producto1.getPrecio(),0);
		assertEquals(5.0,producto2.getPrecio(),0);
		producto.setPrecio(10.0);
		assertEquals(10.0,producto.getPrecio(),0);
}
	@Test
	public void TestClaseProductosElegidosCantidad() {
		assertEquals(2,producto1.getCantidad(),0);
		assertEquals(2,producto2.getCantidad(),0);
		producto.setCantidad(3);
		assertEquals(3,producto.getCantidad(),0);
}
	@Test
	public void TestClaseProductosElegidosPrecioCantidad() {
		assertEquals(producto2.getPrecio()*producto2.getCantidad(),producto2.getPrecioCantidad(),0);
}
}
