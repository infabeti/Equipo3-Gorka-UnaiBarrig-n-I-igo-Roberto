package TestModelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Usuarios;

public class TestUsuarios {
	private Usuarios usuario = new Usuarios ("TipoLocal","NIF","Contrasena","Apellido", "Nombre", "nombreLocal");
	private Usuarios usuario1 = new Usuarios ();
 
	@Test
	public void TestClaseUsuTipoLocal() {
		assertEquals("TipoLocal",usuario.getTipoLocal());
		usuario1.setTipoLocal("TipoLocal2");
		assertEquals("TipoLocal2",usuario1.getTipoLocal());
}
	@Test
	public void TestClaseUsuNIF() {
		assertEquals("NIF",usuario.getNIF());
		usuario1.setNIF("NIF");
		assertEquals("NIF",usuario1.getNIF());
}
	@Test
	public void TestClaseUsuContrasena() {
 		assertEquals("Contrasena",usuario.getContrasena());
 		usuario1.setContrasena("Contrasena2");
 		assertEquals("Contrasena2",usuario1.getContrasena());
 }
	@Test
	public void TestClaseUsuApellido() {
 		assertEquals("Apellido",usuario.getApellido());
 		usuario1.setApellido("Apellido2");
 		assertEquals("Apellido2",usuario1.getApellido());
 }
 	@Test
	public void TestClaseUsuNombre() {
 		assertEquals("Nombre",usuario.getNombre());
 		usuario1.setNombre("Gorka");
 		assertEquals("Gorka",usuario1.getNombre());
 }
	@Test
	public void TestClaseUsuNombreLocal() {
 		assertEquals("nombreLocal",usuario.getNombreLocal());
 		usuario1.setNombreLocal("NombreLocal2");
 		assertEquals("NombreLocal2",usuario1.getNombreLocal());
 }
	@Test
	public void TestClaseUsuToString() {
 		assertEquals("TipoLocal,NIF,Contrasena,Apellido,Nombre",usuario.toString());
 }
 	
}
