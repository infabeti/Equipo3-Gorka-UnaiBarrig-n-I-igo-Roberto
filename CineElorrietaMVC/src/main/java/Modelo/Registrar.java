package Modelo;

public class Registrar {
	
	private String Nombre;
	private String Apellido;
	private String DNI;
	private String Contraseña;
	private String Local;
	
	
	public Registrar(){
	}
	
	public Registrar(String Nombre,String Apellido,String DNI, String Contraseña, String local){
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.DNI = DNI;
		this.Contraseña = Contraseña;
		this.Local = local;
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
	public void setLocal(String Local) {
		this.Local = Local;
	}
	public String getLocal() {
		return this.Local;
	}
	
	

}
