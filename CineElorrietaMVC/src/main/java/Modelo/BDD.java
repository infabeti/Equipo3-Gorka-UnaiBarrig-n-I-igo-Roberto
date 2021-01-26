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
			e.printStackTrace();
			
		}
	}
	public static Productos[]  getProductos() {
		Productos producto[]=new Productos[256];
		producto[0]=new Productos("kass",5);
		producto[1]=new Productos("cocacola",5);
		producto[2]=new Productos("cafe",5);
		producto[3]=new Productos("pintxos",5);
		producto[4]=new Productos("pastel",5);
		producto[5]=new Productos("pistachos",5);
		return producto;
	}
}
