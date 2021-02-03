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
	public Productos[]  getProductos() {
		Productos producto[]=new Productos[6];
		producto[0]=new Productos("kass",5);
		producto[1]=new Productos("cocacola",5);
		producto[2]=new Productos("cafe",5);
		producto[3]=new Productos("pintxos",5);
		producto[4]=new Productos("pastel",5);
		producto[5]=new Productos("pistachos",5);
		return producto;
	}
	public Productos[]  getProductosP() {
		Productos producto[]=new Productos[6];
		producto[0]=new Productos("Arroz",5);
		producto[1]=new Productos("Macarrones",5);
		producto[2]=new Productos("Lentejas",5);
		producto[3]=new Productos("bainas",5);
		producto[4]=new Productos("pastel",5);
		producto[5]=new Productos("tarta",5);
		return producto;
	}
	public Usuarios[] getUsuarios()
	{
		Usuarios usuario[] =new Usuarios[3];
		usuario[0]= new Usuarios("Restaurante","79171053Q", "12345678");
		usuario[1]= new Usuarios("Bar","79171053Q", "12345678");
		usuario[2]= new Usuarios("Cafeteria","79171053Q", "12345678");
		

		return usuario;
	}
	
	
	
}
