package Modelo;

import java.util.Date;

public class Productos {
	private String nombreP;
	private int Precio;
	private String codigo;
	private String nombre;
	private double  preciocomp;
	private Date fechacad;
	
	public Productos() {
	}

	public Productos(String nombreP, int precio) {
		this.nombreP = nombreP;
		this.Precio = precio;
	}
	
	public Productos(String codigo, String nombre, int precioVenta) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.Precio = precioVenta;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	public String getNombreP() {
		return this.nombreP;
	}
	public void setPrecio(int Precio) {
		this.Precio = Precio;
	}
	public int getPrecio() {
		return this.Precio;
	}
	
	public void setCodigo(String codigo){
	this.codigo=codigo;
	}

	public String getCodigo(){
	return this.codigo;
	}

	public void setNombre(String nombre){
	this.nombre=nombre;
	}

	public String getNombre(){
	return this.nombre;
	}

	public void setPrecioComp(double preciocomp){
	this.preciocomp=preciocomp;
	}

	public double getPrecioComp(){
	return this.preciocomp;
	}

	public void setfechacad(Date fechacad){
	this.fechacad=fechacad;
	}

	public Date getfechacad(){
	return fechacad;
	}
	public String toString(){
		return this.getNombreP() + "-" + this.getPrecio();
	}
	
	public String[] separar(Object selec) {
		return ((String) selec).split("-") ;
	}
}