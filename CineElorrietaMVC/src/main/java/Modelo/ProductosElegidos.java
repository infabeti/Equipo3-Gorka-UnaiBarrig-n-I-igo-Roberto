package Modelo;

public class ProductosElegidos {
private Object[] productos = new Object[256];


public ProductosElegidos(){
}

public ProductosElegidos(Object[] productos){
	this.productos = productos;
}
public void setproductos(Object[] productos) {
	this.productos = productos;
}
public Object[] getproductos(Object[] productos) {
	return this.productos;
}
}
