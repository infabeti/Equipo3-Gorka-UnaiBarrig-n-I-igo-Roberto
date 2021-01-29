package Modelo;

public class Tickets{
	private String NumTrans;
	private String fecha;
	private String NomLocal;
	private String[] productos = new String[256];
	
	public Tickets(){
	}
	
	public Tickets(String NumTrans,String fecha,String NomLocal,String[] productos){
		this.NumTrans = NumTrans;
		this.fecha = fecha;
		this.NomLocal = NomLocal;
		this.productos = productos;
	}
	
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
	public void setproductos(String[] productos) {
		this.productos = productos;
	}
	public String[] getproductos(String[] productos) {
		return this.productos;
	}
}
