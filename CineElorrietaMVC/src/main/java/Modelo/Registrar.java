package Modelo;

public class Registrar {
	
	private String Nombre;
	private String Apellido;
	private String DNI;
	private String Contrase�a;
	
	public Registrar(){
	}
	
	public Registrar(String Nombre,String Apellido,String DNI, String Contrase�a){
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