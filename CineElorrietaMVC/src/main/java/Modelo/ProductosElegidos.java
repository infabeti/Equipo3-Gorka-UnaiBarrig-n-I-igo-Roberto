package Modelo;

public class ProductosElegidos {
	private String nombre;
	private double precio;
	private double cantidad;
	private double precioCantidad;
	
	public ProductosElegidos() {
	}

	public ProductosElegidos(String separado, double precioProducto, int cant) {
		this.nombre = separado;
		this.precio = precioProducto;
		this.cantidad = cant;
	}

	public ProductosElegidos(String separado, double precioProducto, int cant, double precioCantidad) {
		this.nombre = separado;
		this.precio = precioProducto;
		this.cantidad = cant;
		this.precioCantidad = precioCantidad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public double getPrecioCantidad() {
		this.precioCantidad = this.precio * this.cantidad;
		return this.precioCantidad;
	}
}
