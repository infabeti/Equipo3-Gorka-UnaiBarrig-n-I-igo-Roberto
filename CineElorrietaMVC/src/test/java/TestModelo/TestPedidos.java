package TestModelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Modelo.Pedidos;

public class TestPedidos {
	private Date fecha = new Date();
	private Pedidos pedido = new Pedidos();
	//private Pedidos pedido2 = new Pedidos("NumTrans2",fecha,"NomLocal","Direccion",ProductosElegidos [] productos,50.0,3);
	
	@Test
	public void TestClasePedidosNumTrans() {
		pedido.setNumTrans("NumTrans");
		assertEquals("NumTrans",pedido.getNumTrans());
		//assertEquals("NumTrans2",pedido2.getNombre());	
}
	@Test
	public void TestClasePedidosfecha() {
		
		pedido.setFecha(fecha);
		assertEquals(fecha.toString(),pedido.getFecha().toString());
		//assertEquals(fecha.toString(),pedido2.getNombre());	
}
	@Test
	public void TestClasePedidosNomLocal() {
		pedido.setNomLocal("NomLocal");
		assertEquals("NomLocal",pedido.getNomLocal());
		//assertEquals("NomLocal2",pedido2.getNombre());	
}
	@Test
	public void TestClasePedidosDireccion() {
		pedido.setDireccion("Direccion");
		assertEquals("Direccion",pedido.getDireccion());
		//assertEquals("NomLocal2",pedido2.getNombre());	
}
	@Test
	public void TestClasePedidosTotal() {
		pedido.setTotal(25.0,25.0);
		//assertEquals("50",pedido.getTotal());
		//assertEquals("NomLocal2",pedido2.getNombre());	
}
	@Test
	public void TestClasePedidosArrSelec() {
		pedido.setArrSelec(3);
		assertEquals(3,pedido.getArrSelec());
		//assertEquals("NomLocal2",pedido2.getNombre());	
}
}
