package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScriptsBDD {
	private Modelo modelo;
	static Connection conexionbd;
	
	public void registrarUsuario(String DNI, String Contraseņa, String Apellido, String nombre, String NIF) throws SQLException {	
	conexionbd = DriverManager.getConnection("jdbc:mysql://localhost:33060/reto3","dam","elorrieta");  
	PreparedStatement insert = conexionbd.prepareStatement("insert into usuarios " + "values (\""+DNI+"\",\""+nombre+"\",\""+Apellido+"\",\""+Contraseņa+"\",\""+NIF+"\")");
	insert.executeUpdate();
	}
	
	public void registrarTicketFacts(String ntrans, String NIF, String Apellido, String Nombre, boolean factura) throws SQLException {
	conexionbd = DriverManager.getConnection("jdbc:mysql://localhost:33060/reto3","dam","elorrieta");
	
	//hace falta codigo de los productos y cantidad
	if (factura == false) {
		
		PreparedStatement insert = conexionbd.prepareStatement("insert into transaccion " + "values ()");
		insert.executeUpdate();
		
	} else if (factura == true) {
		PreparedStatement ticket = conexionbd.prepareStatement("insert into transaccion " + "values ()");
		ticket.executeUpdate();
		PreparedStatement comprador = conexionbd.prepareStatement("insert into comprador (nifc,ApellidoC,NombreC) " + "values (\""+NIF+"\",\""+Apellido+"\",\""+Nombre+"\")");
		comprador.executeUpdate();
		PreparedStatement facturaIntro = conexionbd.prepareStatement("insert into factura (ntrans,nifc) " + "values ((select ntrans from transaccion where ntrans = (select count(ntrans) from transaccion)),\""+NIF+"\")");
		facturaIntro.executeUpdate();
		System.out.println("factura completada");
	}
	}
	
	public void registrarPedido(int numtrans, String fecha, String entrega) throws SQLException {
		
		//hace falta codigo de los productos y cantidad
	conexionbd = DriverManager.getConnection("jdbc:mysql://localhost:33060/reto3","dam","elorrieta"); 
	
	PreparedStatement insert = conexionbd.prepareStatement("insert into pedido" + "values (\""+numtrans+"\",\""+fecha+"\",\""+entrega+"\")");
	insert.executeUpdate();
	
	
	}

public String cambiarFecha(String fecha) {
	String [] fecha2 = modelo.ArraysUtils.separarParaFecha(fecha);
	return fecha = fecha2[0]+"/"+fecha2[1]+"/"+fecha2[2]+"";
}
}