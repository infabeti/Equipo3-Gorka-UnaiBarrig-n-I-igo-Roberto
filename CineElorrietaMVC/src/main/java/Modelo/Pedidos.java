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
}
