package Modelo;

import java.util.Date;

public class Tickets{
	private int NumTrans;
	private Date fecha = new Date();
	private String NomLocal;
	private ProductosElegidos [] productos = new ProductosElegidos[20];
	private double precioCant = 0;
	private double total = 0;
	
	
	public Tickets(){
	}
	
	public Tickets(int NumTrans,Date fecha,String NomLocal,ProductosElegidos[] productos,double total,double precioCant){
		this.NumTrans = NumTrans;
		this.fecha = fecha;
		this.NomLocal = NomLocal;
		this.productos = productos;
		this.precioCant = precioCant;
		this.total = total;	
	}
	
	public void setNumTrans(int Numtrans) {
		this.NumTrans = Numtrans;
	}
	public int getNumTrans() {
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
}
