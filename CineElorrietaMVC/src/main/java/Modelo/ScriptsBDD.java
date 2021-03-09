package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScriptsBDD {
static Connection conexionbd;
private Modelo modelo;

public void registrarUsuario(String DNI, String Contraseña, String Apellido, String nombre, String NIF) throws SQLException {	
	conexionbd = DriverManager.getConnection("jdbc:mysql://localhost:33060/reto3","dam","elorrieta");  
	PreparedStatement insert = conexionbd.prepareStatement("insert into usuarios " + "values (\""+DNI+"\",\""+nombre+"\",\""+Apellido+"\",\""+Contraseña+"\",\""+NIF+"\")");
	insert.executeUpdate();
}
}
