package Modelo;

import java.util.Arrays;
import java.util.Date;

public class Pedidos {

	private Modelo modelo;
	private String NumTrans;
	private Date fecha = new Date();
	private String NomLocal;
	private String Direccion;
	private ProductosElegidos[] productos = new ProductosElegidos[0];
	private double total = 0;
	private int aumentoDeArr = 0;
	private int arrSelec;
	private ArraysUtils ArraysUtils = new ArraysUtils();

	public Pedidos() {
	}

	public Pedidos(String NumTrans, Date fecha, String NomLocal, String Direccion, ProductosElegidos[] productos,
			double total, int arrSelec) {
		this.NumTrans = NumTrans;
		this.fecha = fecha;
		this.NomLocal = NomLocal;
		this.Direccion = Direccion;
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

	public void setTotal(double num1, double num2) {
		this.total = num1 + num2;
	}

	public String getTotal() {
		this.total = 0;
		for (int i = 0; i < this.productos.length; i++) {
			this.total = this.total + productos[i].getPrecioCantidad();

		}
		String total = String.valueOf(this.total);
		return total;
	}

	public void borrarTotal() {
		this.total = 0;
		this.productos = new ProductosElegidos[0];
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
		this.productos = ArraysUtils.DisminuirArrProductos(this.productos);
		aumentoDeArr--;
		String total = String.valueOf(this.total);
		return total;
	}

	private ProductosElegidos[] eliminarSelecArr(ProductosElegidos[] array, int index) {
		int i = index;
		for (i = index; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = null;
		return array;
	}

	public String getCant() {

		double precioCant = productos[productos.length - 1].getPrecioCantidad();
		String precioCant1 = String.valueOf(precioCant);
		return precioCant1;
	}

	public ProductosElegidos[] setProductos(String codigo, String nombre, String precioProducto, int cant) {
		double PrecioProducto = Double.parseDouble(precioProducto);
		int value = this.productos.length;
		if (this.productos.length > 0) {
			boolean encontrado = false;
			for (int i = 0; i <= this.productos.length - 1; i++) {
				if (codigo.equalsIgnoreCase(this.productos[i].getCodigoProducto())) {
					double cantidad = this.productos[i].getCantidad();
					int cantidadSelec = (int) cantidad;
					cant = cant + cantidadSelec;
					this.productos[i].setCantidad(cant);
					encontrado = true;
					break;
				}
			}
			if (encontrado == false) {
				this.productos = ArraysUtils.aumentarArrProductos(this.productos);
				this.productos[value] = new ProductosElegidos(codigo, nombre, PrecioProducto, cant);
			}
			
		} else {
			this.productos = ArraysUtils.aumentarArrProductos(this.productos);
			this.productos[value] = new ProductosElegidos(codigo, nombre, PrecioProducto, cant);
		}
		return this.productos;
	}

	public int getLongitudArr() {
		return this.productos.length;
	}
}
