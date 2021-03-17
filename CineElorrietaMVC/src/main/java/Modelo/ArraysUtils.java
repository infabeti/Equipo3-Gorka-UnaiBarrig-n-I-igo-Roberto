package Modelo;

import java.util.Arrays;

public class ArraysUtils {
	public ProductosElegidos[] aumentarArrProductos(ProductosElegidos[] productos) {
		ProductosElegidos[] temp = new ProductosElegidos[productos.length+1];
		for (int i = 0; i<productos.length;i++) {
			temp[i] = productos[i];
		}
		return productos = Arrays.copyOf(temp ,productos.length+1);
	}
	public ProductosElegidos[] DisminuirArrProductos(ProductosElegidos[] productos) {
		ProductosElegidos[] temp = new ProductosElegidos[productos.length-1];
		for (int i = 0; i<productos.length-1;i++) {
			temp[i] = productos[i];
		}
		return productos = Arrays.copyOf(temp ,productos.length-1);
	}
	public Usuarios[] aumentarArrUsu(Usuarios[] Usuario) {
		Usuarios[] temp = new Usuarios[Usuario.length+1];
		for (int i = 0; i<Usuario.length;i++) {
			temp[i] = Usuario[i];
		}
		return Usuario = Arrays.copyOf(temp ,Usuario.length+1);
	}
	public String[] separarParaUsu(Object selec) {
		return ((String) selec).split(",") ;
	}
	public String[] separarParaFecha(Object selec) {
		return ((String) selec).split("-") ;
	}
	public Productos[] aumentarArrProductos1(Productos[] productos) {
		Productos[] temp = new Productos[productos.length+1];
		for (int i = 0; i<productos.length;i++) {
			temp[i] = productos[i];
		}
		return productos = Arrays.copyOf(temp ,productos.length+1);
		
	}
}