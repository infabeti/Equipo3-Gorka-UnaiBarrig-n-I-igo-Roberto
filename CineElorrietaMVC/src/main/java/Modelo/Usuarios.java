package Modelo;

public class Usuarios {
	
	private String NIF;
	private String Contraseña;
	private String TipoLocal;
	private String Nombre;
	private String Apellido;
	
	public Usuarios(){
	}
	
	public Usuarios(String TipoLocal, String NIF, String Contraseña, String Apellido, String Nombre){
		this.TipoLocal = TipoLocal;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.NIF = NIF;
		this.Contraseña = Contraseña;
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
	public void setNIF(String NIF) {
		this.NIF = NIF;
	}
	public String getNIF() {
		return this.NIF;
	}
	public void setContrasena(String Contraseña) {
		this.Contraseña = Contraseña;
	}
	public String getContrasena() {
		return this.Contraseña;
	}
	public String toString() {
		return getTipoLocal()+","+getNIF()+","+getContrasena()+","+getApellido()+","+getNombre();
	}
}
