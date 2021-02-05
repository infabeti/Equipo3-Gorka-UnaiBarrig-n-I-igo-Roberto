package Modelo;

import java.util.Date;

public class Facturas extends Tickets{
	private String NIF;
	private String Nombre;
	private String Apellido;

	public Facturas() {
	}
	
	public Facturas(int NumTrans,Date fecha,String NomLocal,ProductosElegidos[] productos,double total,double precioCant,String NIF,String Nombre,String Apellido) {
		super(NumTrans,fecha,NomLocal,productos,total,precioCant);
		this.NIF = NIF;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
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
