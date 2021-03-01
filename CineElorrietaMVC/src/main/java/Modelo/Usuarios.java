package Modelo;

public class Usuarios {
	
	private String DNI;
	private String Contrase�a;
	private String TipoLocal;
	private String Nombre;
	private String Apellido;
	
	public Usuarios(){
	}
	
	public Usuarios(String TipoLocal, String DNI, String Contrase�a, String Apellido, String Nombre){
		this.TipoLocal = TipoLocal;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.DNI = DNI;
		this.Contrase�a = Contrase�a;
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
