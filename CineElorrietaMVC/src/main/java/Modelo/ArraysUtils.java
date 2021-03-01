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
}