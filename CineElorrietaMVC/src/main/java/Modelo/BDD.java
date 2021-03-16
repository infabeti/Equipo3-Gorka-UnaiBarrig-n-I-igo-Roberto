package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
public class BDD {

	private Usuarios usuario;
	private Productos [] productos;
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
	
	public Connection conexion() {

		try{
			conexionbd = DriverManager.getConnection(url,username,password);
			System.out.println("Conectado correctamente.");
		}catch(SQLException e){
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
		return conexionbd;
	}
	public Productos[]  getProductos() throws SQLException {
		
		PreparedStatement consulta = conexionbd.prepareStatement("select count(Codigo) from producto");
		ResultSet resultado=consulta.executeQuery();
		String cantidad2 = null;
		if(resultado.next()) {
			cantidad2 = resultado.getString("count(Codigo)");
			
		}
		
		int cantidad = Integer.parseInt(cantidad2);
		productos = new Productos[cantidad];
		for(int i = 0;cantidad>i;i++) {
			int x = i+1;           
			PreparedStatement consulta2 = conexionbd.prepareStatement("select Codigo, nombre, PrecioVent from producto where Codigo = "+x);
			ResultSet result=consulta2.executeQuery();
			productos[i] = new Productos(result.getString("Código"),result.getString("nombre"),result.getInt("PrecioVent"));
		}

		return productos;
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
		
	public String[]  convertirArrayProductosString() throws SQLException{
		Productos[] productos = getProductos();
		String [] arrayr=new String[productos.length];
		for(int i=0; i<productos.length; i++) {
			arrayr[i]=productos[i].toString();
		}
		return  arrayr;
	}
public void cerrarSesion() {
	usuario=null;
}
}
