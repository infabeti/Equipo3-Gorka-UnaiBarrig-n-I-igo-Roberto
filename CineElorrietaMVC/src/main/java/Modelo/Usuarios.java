package Modelo;

public class Usuarios {
	
	private String DNI;
	private String Contrase�a;
	private String TipoLocal;
	
	public Usuarios(){
	}
	
	public Usuarios(String TipoLocal, String DNI, String Contrase�a){
		this.TipoLocal = TipoLocal;
		this.DNI = DNI;
		this.Contrase�a = Contrase�a;
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
	public void setContrase�a(String Contrase�a) {
		this.Contrase�a = Contrase�a;
	}
	public String getContrase�a() {
		return this.Contrase�a;
	}
	

}