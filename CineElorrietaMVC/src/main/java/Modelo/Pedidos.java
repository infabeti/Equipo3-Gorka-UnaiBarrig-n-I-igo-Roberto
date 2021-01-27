package Modelo;

public class Pedidos {
	
	private String NumTrans;
	private String fecha;
	private String NomLocal;
	private String Direccion;
	private String[] productos = new String[256];
	
	public void setNumTrans(String Numtrans) {
		this.NumTrans = Numtrans;
	}
	public String getNumTrans() {
		return this.NumTrans;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFecha() {
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
	public void setproductos(String[] productos) {
		this.productos = productos;
	}
	public String[] getproductos(String[] productos) {
		return this.productos;
	}

}
