package Modelo;

import java.util.Date;

public class Pedidos {
	
	private String NumTrans;
	private Date fecha = new Date();
	private String NomLocal;
	private String Direccion;
	private ProductosElegidos [] productos = new ProductosElegidos[20];
	private double precioCant = 0;
	private double total = 0;
	private String NIF;
	private String Nombre;
	private String Apellido;
	
	public void setNumTrans(String Numtrans) {
		this.NumTrans = Numtrans;
	}
	public String getNumTrans() {
		return this.NumTrans;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFecha() {
		return this.fecha;
	}
	public void setNomLocal(String NomLocal) {
		this.NomLocal = NomLocal;
	}
	public String getNomLocal() {
		return this.NomLocal;
	}
	public void setDireccion(String direccion) {
		this.Direccion = direccion;
	}
	public String getDireccion() {
		return this.Direccion;
	}
	public void setproductos(ProductosElegidos[] productos) {
		this.productos = productos;
	}
	public ProductosElegidos[] getproductos() {
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
