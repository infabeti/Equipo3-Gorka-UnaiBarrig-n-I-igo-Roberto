package Modelo;

import java.util.Arrays;
import java.util.Date;

public class Pedidos {
	
	private String NumTrans;
	private Date fecha = new Date();
	private String NomLocal;
	private String Direccion;
	private ProductosElegidos[] productos = new ProductosElegidos[0];
	private double total = 0;
	private int aumentoDeArr = 0;
	private int arrSelec;
	
	public Pedidos() {
	}
	
	public Pedidos(String NumTrans,Date fecha,String NomLocal,String Direccion,ProductosElegidos [] productos,double total, int arrSelec){
		this.NumTrans = NumTrans;
		this.fecha = fecha;
		this.NomLocal = NomLocal;
		this.Direccion= Direccion;
		this.productos = productos;
		this.total = total;
		this.arrSelec = arrSelec;
	}

	public void setNumTrans(String Numtrans) {
		this.NumTrans = Numtrans;
	}
	public String getNumTrans() {
		return this.NumTrans;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFecha() {
		return this.fecha;
	}
	public void setNomLocal(String NomLocal) {
		this.NomLocal = NomLocal;
	}
	public String getNomLocal() {
		return this.NomLocal;
	}
	public void setDireccion(String direccion) {
		this.Direccion = direccion;
	}
	public String getDireccion() {
		return this.Direccion;
	}
	public void setproductos(ProductosElegidos[] productos) {
		this.productos = productos;
	}
	public ProductosElegidos[] getproductos() {
		return this.productos;
	}
	public void setTotal(double num1,double num2) {
		this.total = num1+num2;
	}
	public String getTotal() {
		this.total = this.total + productos[aumentoDeArr].getPrecioCantidad();
		aumentoDeArr++;
	String total = String.valueOf(this.total);
	return total;
	}
	public void setArrSelec(int arrSelec) {
		this.arrSelec = arrSelec;
	}
	public int getArrSelec() {
		return this.arrSelec;
	}
	public String eliminarTotal() {
		this.total = this.total - productos[getArrSelec()].getPrecioCantidad();
		this.productos = eliminarSelecArr(this.productos, getArrSelec());
		DisminuirArrProductos();
		aumentoDeArr--;
	String total = String.valueOf(this.total);
	return total;
	}
	private ProductosElegidos[] eliminarSelecArr(ProductosElegidos[] array, int index) {
        int i = index;
        for (i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length-1] = null;
		return array;
    }
	public double getCant() {
		return	productos[productos.length-1].getPrecioCantidad();
	}
	public void setProductos(String nombre, double precioProducto, int cant) {
		int value = this.productos.length;
		aumentarArrProductos();
		this.productos[value]=new ProductosElegidos(nombre,precioProducto,cant);
	}
	public void aumentarArrProductos() {
		ProductosElegidos[] temp = new ProductosElegidos[this.productos.length+1];
		for (int i = 0; i<this.productos.length;i++) {
			temp[i] = this.productos[i];
		}
		this.productos = Arrays.copyOf(temp ,this.productos.length+1);
	}
	public void DisminuirArrProductos() {
		ProductosElegidos[] temp = new ProductosElegidos[this.productos.length-1];
		for (int i = 0; i<this.productos.length-1;i++) {
			temp[i] = this.productos[i];
		}
		this.productos = Arrays.copyOf(temp ,this.productos.length-1);
	}
}
