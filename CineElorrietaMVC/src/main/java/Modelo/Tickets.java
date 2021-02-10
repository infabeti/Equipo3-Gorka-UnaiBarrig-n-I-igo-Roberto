package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tickets{
	private int NumTrans;
	Date fecha;
	private String NomLocal;
	private ProductosElegidos [] productos = new ProductosElegidos[20];
	private double precioCant = 0;
	private double total = 0;
	private String NIF;
	private String Nombre;
	private String Apellido;
	private boolean EsFactura = false;
	
	public Tickets(){
	}
	public Tickets(int NumTrans,Date fecha,String NomLocal,ProductosElegidos[] productos,double total,double precioCant, String NIF, String Nombre, String Apellido){
		this.NumTrans = NumTrans;
		this.fecha = fecha;
		this.NomLocal = NomLocal;
		this.productos = productos;
		this.precioCant = precioCant;
		this.total = total;
		this.NIF = NIF;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
	}
	public void setNumTrans(int Numtrans) {
		this.NumTrans = Numtrans;
	}
	public int getNumTrans() {
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
	public ProductosElegidos[] getproductos(ProductosElegidos[] productos) {
		return this.productos;
	}
	public void setTotal(double num1,double num2) {
		this.total = num1+num2;
	}
	public double getTotal() {
		return this.total;
	}
	public void setCant(double num1,double num2) {
		this.precioCant = num1*num2;
	}
	public double getCant() {
		return this.precioCant;
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
}
