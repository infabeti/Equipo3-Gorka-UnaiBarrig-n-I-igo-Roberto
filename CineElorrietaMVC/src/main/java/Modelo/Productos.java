package Modelo;

public class Productos {
	private String nombreP;
	private int Precio;
	
	public Productos() {
	}

	public Productos(String nombreP, int precio) {
		this.nombreP = nombreP;
		this.Precio = precio;
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
	 
	public String toString()
	{
		return this.getNombreP() + "-" + this.getPrecio();
	}
}