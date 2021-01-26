package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class BDD {
	
	public static void conexion() {
		
		String url="jdbc:mysql://localhost:3306/reto3";
		String username="dam";
		String password="elorrieta";



		try{

		Connection conexionbd = DriverManager.getConnection(url,username,password);
			System.out.println("Conectado correctamente.");
		}catch(SQLException e){

			System.out.println("No se ha podido conectar a la base de datos");
			
		}
	}

}
