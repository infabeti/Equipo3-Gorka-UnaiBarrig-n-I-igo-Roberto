package Modelo;

public class Usuarios {
	
	private String DNI;
	private String Contraseña;
	private String TipoLocal;
	
	public Usuarios(){
	}
	
	public Usuarios(String TipoLocal, String DNI, String Contraseña){
		this.TipoLocal = TipoLocal;
		this.DNI = DNI;
		this.Contraseña = Contraseña;
	}
	
	public void setTipoLocal(String TipoLocal) {
		this.TipoLocal = TipoLocal;
	}
	public String getTipoLocal() {
		return this.TipoLocal;
	}
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	public String getDNI() {
		return this.DNI;
	}
	public void setContraseña(String Contraseña) {
		this.Contraseña = Contraseña;
	}
	public String getContraseña() {
		return this.Contraseña;
	}
	

}
