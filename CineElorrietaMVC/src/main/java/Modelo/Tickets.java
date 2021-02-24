package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Tickets{
	private Modelo modelo;
	private String NumTrans;
	Date fecha;
	private String NomLocal;
	private ProductosElegidos [] productos = new ProductosElegidos[0];
	private String nombrePro;
	private double total = 0;
	private String NIF;
	private String Nombre;
	private String Apellido;
	private boolean EsFactura = false;
	private int aumentoDeArr = 0;
	private int arrSelec;
	
	public Tickets(){
	}
	public Tickets(Date fecha,String NomLocal, double total, String NIF, String Nombre, String Apellido, ProductosElegidos[] productos, int arrSelec){
		this.NumTrans = modelo.Contador.getContador();
		this.fecha = fecha;
		this.NomLocal = NomLocal;
		this.productos  = productos;
		this.total = total;
		this.NIF = NIF;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.arrSelec = arrSelec;
	}
	public void setNumTrans(String Numtrans) {
		this.NumTrans = Numtrans;
	}
	public String getNumTrans() {
		return this.NumTrans;
	}
	public void setFecha() {
		this.fecha = Calendar.getInstance().getTime();
	}
	public String getFecha() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha2 = dateFormat.format(this.fecha);
		return fecha2;
	}
	public void setNomLocal(String NomLocal) {
		this.NomLocal = NomLocal;
	}
	public String getNomLocal() {
		return this.NomLocal;
	}
	public void setproductos(ProductosElegidos[] productos) {
		this.productos = productos;
	}
	public ProductosElegidos[] getproductos() {
		return this.productos;
	}
	public String getName() {
		nombrePro = productos[productos.length-1].getNombre();
		return nombrePro;
	}
	
	public String getTotal() {
			this.total = this.total + productos[aumentoDeArr].getPrecioCantidad();
			aumentoDeArr++;
		String total = String.valueOf(this.total);
		return total;
	}
	public void setArrSelec(int arrSelec) {
		this.arrSelec = arrSelec;
	}
	public int getArrSelec() {
		return this.arrSelec;
	}
	public String eliminarTotal() {
		this.total = this.total - productos[getArrSelec()].getPrecioCantidad();
		//this.productos Eliminar fila
		aumentoDeArr--;
	String total = String.valueOf(this.total);
	return total;
	}
	public double getCant() {
		return	productos[productos.length-1].getPrecioCantidad();
	}
	public void setNIF(String NIF) {
		this.NIF = NIF;
	}
	public String getNIF() {
		return this.NIF;
	}
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public String getNombre() {
		return this.Nombre;
	}
	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}
	public String getApellido() {
		return this.Apellido;
	}
	public ProductosElegidos[] getProductos() {
		return this.productos;
	}
	public void setProductos(String nombre, double precioProducto, int cant) {
		int value = this.productos.length;
		aumentarArrProductos();
		this.productos[value]=new ProductosElegidos(nombre,precioProducto,cant);
	}
	public void aumentarArrProductos() {
		ProductosElegidos[] temp = new ProductosElegidos[this.productos.length+1];
		for (int i = 0; i<this.productos.length;i++) {
			temp[i] = this.productos[i];
		}
		this.productos = Arrays.copyOf(temp ,this.productos.length+1);
	}
}

