package Modelo;

public class Usuarios {
	
	private String DNI;
	private String Contraseña;
	
	public Usuarios(){
	}
	
	public Usuarios(String DNI, String Contraseña){
		
		this.DNI = DNI;
		this.Contraseña = Contraseña;
		
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
