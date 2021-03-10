package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScriptsBDD {
	private Modelo modelo;
	static Connection conexionbd;
	
	public void registrarUsuario(String DNI, String Contraseña, String Apellido, String nombre, String NIF) throws SQLException {	
	conexionbd = DriverManager.getConnection("jdbc:mysql://localhost:33060/reto3","dam","elorrieta");  
	PreparedStatement insert = conexionbd.prepareStatement("insert into usuarios " + "values (\""+DNI+"\",\""+nombre+"\",\""+Apellido+"\",\""+Contraseña+"\",\""+NIF+"\")");
	insert.executeUpdate();
	}
	
	public void registrarTicketFacts(String ntrans, String fecha, String NIF, String Apellido, String Nombre, boolean factura) throws SQLException {
	conexionbd = DriverManager.getConnection("jdbc:mysql://localhost:33060/reto3","dam","elorrieta");
	
	fecha = cambiarFecha(fecha);
	if (factura == false) {
		
		PreparedStatement insert = conexionbd.prepareStatement("insert into transacción" + "values (\""+ntrans+"\",\""+fecha+"\")");
		insert.executeUpdate();
		
	} else if (factura == true) {
		PreparedStatement insert = conexionbd.prepareStatement("insert into transacción" + "values (\""+ntrans+"\",\""+fecha+"\",\""+NIF+"\",\""+Apellido+"\",\""+Nombre+"\")");
		insert.executeUpdate();
	}
	}
	
	public void registrarPedido(int numtrans, String fecha, String entrega) throws SQLException {
	conexionbd = DriverManager.getConnection("jdbc:mysql://localhost:33060/reto3","dam","elorrieta"); 
	
	PreparedStatement insert = conexionbd.prepareStatement("insert into pedido" + "values (\""+numtrans+"\",\""+fecha+"\",\""+entrega+"\")");
	insert.executeUpdate();
	
	
	}

public String cambiarFecha(String fecha) {
	String [] fecha2 = modelo.ArraysUtils.separarParaFecha(fecha);
	return fecha = fecha2[0]+"/"+fecha2[1]+"/"+fecha2[2]+"";
}
}