package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScriptsBDD {
	private Modelo modelo;

	ScriptsBDD(Modelo modelo) {
		this.modelo = modelo;
	}

	public void registrarUsuario(String DNI, String Contraseña, String Apellido, String nombre, String NIF)
			throws SQLException {
		Connection conexionbd = modelo.BDD.conexion();
		PreparedStatement insert = conexionbd.prepareStatement("insert into usuarios " + "values (\"" + DNI + "\",\""
				+ nombre + "\",\"" + Apellido + "\",\"" + Contraseña + "\",\"" + NIF + "\")");
		insert.executeUpdate();
	}

	public void registrarTicketFacts(String ntrans, String NIF, String Apellido, String Nombre, boolean factura)
			throws SQLException {
		Connection conexionbd = modelo.BDD.conexion();
		boolean b = true;
		if (factura == false) {

			PreparedStatement insert = conexionbd.prepareStatement("insert into transaccion " + "values ()");
			insert.executeUpdate();
			
			insertarProductosElegidos(b);
		} else if (factura == true) {
			PreparedStatement ticket = conexionbd.prepareStatement("insert into transaccion " + "values ()");
			ticket.executeUpdate();
			PreparedStatement NIFCheck = conexionbd
					.prepareStatement("select nifc from comprador where NIFC= \"" + NIF + "\"");
			ResultSet resultNIF = NIFCheck.executeQuery();
			if (resultNIF.next()) {
				PreparedStatement facturaIntro = conexionbd.prepareStatement("insert into factura (ntrans,nifc) "
						+ "values ((select ntrans from transaccion where ntrans = (select count(ntrans) from transaccion)),\""
						+ NIF + "\")");
				facturaIntro.executeUpdate();
				insertarProductosElegidos(b);
			} else {
				PreparedStatement comprador = conexionbd
						.prepareStatement("insert into comprador (nifc,ApellidoC,NombreC) " + "values (\"" + NIF
								+ "\",\"" + Apellido + "\",\"" + Nombre + "\")");
				comprador.executeUpdate();

				PreparedStatement facturaIntro = conexionbd.prepareStatement("insert into factura (ntrans,nifc) "
						+ "values ((select ntrans from transaccion where ntrans = (select count(ntrans) from transaccion)),\""
						+ NIF + "\")");
				facturaIntro.executeUpdate();
				insertarProductosElegidos(b);
			}
			System.out.println("factura completada");
		}
	}

	public void registrarPedido(String entrega) throws SQLException {
		boolean b = false;
		if(entrega.length()<=0) {
			
			entrega = "Local";
		}
		
		Connection conexionbd = modelo.BDD.conexion();
		PreparedStatement ticket = conexionbd.prepareStatement("insert into transaccion " + "values ()");
		ticket.executeUpdate();
		PreparedStatement insert = conexionbd.prepareStatement("insert into pedido "
				+ "values ((select ntrans from transaccion where ntrans = (select count(ntrans) from transaccion)),\""
				+ entrega + "\")");
		insert.executeUpdate();
		insertarProductosElegidos(b);
		System.out.println("pedido completado");

	}

	public String NTrans() throws SQLException {
		Connection conexionbd = modelo.BDD.conexion();
		PreparedStatement ntrans = conexionbd.prepareStatement("select count(ntrans) from transaccion");
		ResultSet resultrans = ntrans.executeQuery();
		String numtrans = null;
		if (resultrans.next()) {

			numtrans = resultrans.getString("count(ntrans)");
		}
		return numtrans;
	}

	public String cambiarFecha(String fecha) {
		String[] fecha2 = modelo.ArraysUtils.separarParaFecha(fecha);
		return fecha = fecha2[0] + "/" + fecha2[1] + "/" + fecha2[2] + "";
	}

	public String getNombreLocal(String NIF) throws SQLException {
		String DNI = NIF;
		Connection conexionbd = modelo.BDD.conexion();
		PreparedStatement ntrans = conexionbd.prepareStatement(
				"select Nombre from locale where NIF = (select NIFLocal from usuarios where DNI = \"" + DNI + "\")");
		ResultSet resultrans = ntrans.executeQuery();
		String nombre = "";
		if (resultrans.next()) {
			
			nombre = resultrans.getString("Nombre");
			return nombre;
		}
		else {
			
			System.out.println("No se ha podido conseguir el nombre del local");
		}
		
		return nombre;
	}

	
	
	public void insertarProductosElegidos(boolean b) throws SQLException{
		
		Connection conexionbd = modelo.BDD.conexion();
		
		//b == true (ticket)
		//b == false (ticket)
		
		if (b==true) {
			
			ProductosElegidos[] productoTicket = new ProductosElegidos[modelo.ticket.getLongitudArr()];
			productoTicket = modelo.ticket.getProductos();
			for (int i = 0; i < productoTicket.length; i++) {
				PreparedStatement ntrans = conexionbd.prepareStatement("insert into contenido (NTrans,Codigo,Cantidad,PVP) "
						+ " values((select count(NTrans) from transaccion),\"" + productoTicket[i].getCodigoProducto()
						+ "\",\"" + productoTicket[i].getCantidad() + "\",\"" + productoTicket[i].getPrecio() + "\")");
				ntrans.executeUpdate();
			}
		}
		else if (b==false) {
			
			ProductosElegidos[] productoPedido = new ProductosElegidos[modelo.pedidos.getLongitudArr()];
			productoPedido = modelo.pedidos.getproductos();
			for (int i = 0; i < productoPedido.length; i++) {
				PreparedStatement ntrans = conexionbd.prepareStatement("insert into contenido (NTrans,Codigo,Cantidad,PVP) "
						+ " values((select count(NTrans) from transaccion),\"" + productoPedido[i].getCodigoProducto()
						+ "\",\"" + productoPedido[i].getCantidad() + "\",\"" + productoPedido[i].getPrecio() + "\")");
				ntrans.executeUpdate();
			}
		}
	}



}