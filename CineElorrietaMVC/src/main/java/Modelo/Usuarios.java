package Modelo;

public class Usuarios {
	
	private String NIF;
	private String Contraseņa;
	private String TipoLocal;
	private String Nombre;
	private String Apellido;
	private String nombreLocal;
	
	
	
	public Usuarios() {
	}
	
	public Usuarios(String NIF, String Contraseņa, String nombreLocal, String TipoLocal){
		this.NIF = NIF;
		this.Contraseņa = Contraseņa;
		this.nombreLocal = nombreLocal;
		this.TipoLocal = TipoLocal;
	}
	//SinNombreLocal
	public Usuarios(String NIF, String Contraseņa, String TipoLocal){
		this.NIF = NIF;
		this.Contraseņa = Contraseņa;
		this.TipoLocal = TipoLocal;
	}
	//SinNombreLocal
	public Usuarios(String TipoLocal, String NIF, String Contraseņa, String Apellido, String Nombre){
		this.TipoLocal = TipoLocal;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.NIF = NIF;
		this.Contraseņa = Contraseņa;
	}
	public Usuarios(String TipoLocal, String NIF, String Contraseņa, String Apellido, String Nombre, String nombreLocal){
		this.TipoLocal = TipoLocal;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.NIF = NIF;
		this.Contraseņa = Contraseņa;
		this.nombreLocal = nombreLocal;
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
	public void setContrasena(String Contraseņa) {
		this.Contraseņa = Contraseņa;
	}
	public String getContrasena() {
		return this.Contraseņa;
	}
	public String toString() {
		return getTipoLocal()+","+getNIF()+","+getContrasena()+","+getApellido()+","+getNombre();
	}
	public String getNombreLocal() {
		return nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}
}
