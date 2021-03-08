package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
public class BDD {

	private Usuarios usuario;
	static String url="jdbc:mysql://localhost:33060/reto3";
	static String username="dam";
	static String password="elorrieta";
	static Connection conexionbd;
	private ArraysUtils ArraysUtils = new ArraysUtils();
	
	public BDD() {
	}

	public BDD(Usuarios usuario) {
		this.usuario = usuario;
	}	
	
	public static void conexion() {

		try{
			conexionbd = DriverManager.getConnection(url,username,password);
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
	public void setUsuarios(String TipoLocal, String DNI, String Contraseña, String apellido, String nombre) {
		/*int value = this.usuario.length;
		this.usuario = ArraysUtils.aumentarArrUsu(this.usuario);
		this.usuario[value]=new Usuarios(TipoLocal,DNI,Contraseña,apellido,nombre);*/
	}
	
	public Usuarios LoginUsu(String DNIIntroducido,String ContraIntro) throws SQLException {
		PreparedStatement consulta = conexionbd.prepareStatement("SELECT DNI,Contraseña,Tipo  FROM Usuarios U join Locale L on U.NIFLocal = L.NIF where DNI = \""+DNIIntroducido+"\" and Contraseña = \""+ContraIntro+"\"");
	    ResultSet resultado=consulta.executeQuery();
	    if(resultado.next()) {
		usuario= new Usuarios(resultado.getString("DNI"),resultado.getString("Contraseña"),resultado.getString("Tipo"));
	    }
		return usuario;
	}
	public String getUsuString() {
		String usu = usuario.toString();
		return usu;
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
