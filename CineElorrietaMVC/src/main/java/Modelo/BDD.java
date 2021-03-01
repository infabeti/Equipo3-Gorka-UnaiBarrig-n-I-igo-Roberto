package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
public class BDD {

	private Usuarios usuario[] =new Usuarios[3];
	static String url="jdbc:mysql://localhost:33060/reto3";
	static String username="dam";
	static String password="elorrieta";
	
	public BDD() {
	}

	public BDD(Usuarios[] usuario) {
		this.usuario = usuario;
	}	
	
	public static void conexion() {

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
	public void setUsuarios(String TipoLocal, String DNI, String cant) {
		int value = this.usuario.length;
		aumentarArrProductos();
		this.usuario[value]=new Usuarios(TipoLocal,DNI,cant);
	}
	public Usuarios[] getUsuarios() {
		return usuario;
	}
	public void aumentarArrProductos() {
		Usuarios[] temp = new Usuarios[this.usuario.length+1];
		for (int i = 0; i<this.usuario.length;i++) {
			temp[i] = this.usuario[i];
		}
		this.usuario = Arrays.copyOf(temp ,this.usuario.length+1);
	}
	public void usuariosPrueba() {
		usuario[0]= new Usuarios("Restaurante","79171053Q", "12345678");
		usuario[1]= new Usuarios("Bar","79171053Q", "12345678");
		usuario[2]= new Usuarios("Cafeteria","79171053Q", "12345678");
	}
		
	public String[]  convertirArrayProductosString(){
		Productos[] productos = getProductos();
		String [] arrayr=new String[productos.length];
		for(int i=0; i<productos.length; i++) {
			arrayr[i]=productos[i].toString();
		}
		return  arrayr;
	}
}
