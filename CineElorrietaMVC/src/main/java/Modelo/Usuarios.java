package Modelo;

public class Usuarios {
	
	private String DNI;
	private String Contrase�a;
	
	public Usuarios(){
	}
	
	public Usuarios(String DNI, String Contrase�a){
		
		this.DNI = DNI;
		this.Contrase�a = Contrase�a;
		
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
