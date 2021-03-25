package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDD {
	private Usuarios usuario;
	private Productos[] productos;
	protected static String url = "jdbc:mysql://localhost:33060/reto3";
	protected static String username = "dam";
	protected static String password = "elorrieta";
	protected static Connection conexionbd;

	public BDD() {
	}

	public BDD(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Connection conexion() {

		try {
			conexionbd = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos");
			
		}
		return conexionbd;
	}

	public Productos[] getProductos() throws SQLException {
		PreparedStatement consulta = conexionbd.prepareStatement("select Codigo, nombre, PrecioVent from producto");
		ResultSet result = consulta.executeQuery();

		PreparedStatement numero = conexionbd.prepareStatement("select count(Codigo) from producto");
		ResultSet cantidad = numero.executeQuery();
		int tamArr = 0;
		if (cantidad.next()) {
			String cantCodigo = cantidad.getString("count(Codigo)");
			tamArr = Integer.parseInt(cantCodigo);
		}

		this.productos = new Productos[tamArr];
		int i = 0;
		while (result.next()) {

			try {
				productos[i] = new Productos(result.getString("Codigo"), result.getString("nombre"),
						result.getInt("PrecioVent"));
				i++;
			} catch (Exception E) {
				System.out.println("no se ha introducido el producto");
			}
		}
		return productos;
	}

	public Usuarios LoginUsu(String DNIIntroducido, String ContraIntro) throws SQLException {
		PreparedStatement consulta = conexionbd.prepareStatement(
				"SELECT DNI,Contraseña,Tipo  FROM Usuarios U join Locale L on U.NIFLocal = L.NIF where DNI = \""
						+ DNIIntroducido + "\" and Contraseña = \"" + ContraIntro + "\"");
		ResultSet resultado = consulta.executeQuery();
		if (resultado.next()) {
			usuario = new Usuarios(resultado.getString("DNI"), resultado.getString("Contraseña"),
					resultado.getString("Tipo"));
		}
		return usuario;
	}

	public String getUsuString() {
		String usu = usuario.toString();
		return usu;
	}

	public String[] convertirArrayProductosString() throws SQLException {
		Productos[] productos = getProductos();
		String[] arrayr = new String[productos.length];
		for (int i = 0; i < productos.length; i++) {
			arrayr[i] = productos[i].toString();
		}
		return arrayr;
	}

	public void cerrarSesion() {
		usuario = null;
	}
}
