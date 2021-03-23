package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tickets {
	Date fecha;
	private ProductosElegidos[] productos = new ProductosElegidos[0];
	private double total = 0;
	private String NIF, Nombre, Apellido, nombrePro, NomLocal, NumTrans;
	private int aumentoDeArr = 0;
	private int arrSelec;
	private ArraysUtils ArraysUtils = new ArraysUtils();

	public Tickets() {
	}

	public Tickets(Date fecha, String NomLocal, double total, String NIF, String Nombre, String Apellido,
			ProductosElegidos[] productos, int arrSelec, Modelo modelo) {
		this.NumTrans = modelo.Contador.getContador();
		this.fecha = fecha;
		this.NomLocal = NomLocal;
		this.productos = productos;
		this.total = total;
		this.NIF = NIF;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.arrSelec = arrSelec;
	}

	public void setNumTrans(String Numtrans) {
		this.NumTrans = Numtrans;
	}

	public String getNumTrans() {
		return this.NumTrans;
	}

	public void setFecha() {
		this.fecha = Calendar.getInstance().getTime();
	}

	public String getFecha() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha2 = dateFormat.format(this.fecha);
		return fecha2;
	}

	public void setNomLocal(String NomLocal) {
		this.NomLocal = NomLocal;
	}

	public String getNomLocal() {
		return this.NomLocal;
	}

	public String getName() {
		nombrePro = productos[productos.length - 1].getNombre();
		return nombrePro;
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

	public void setNIF(String NIF) {
		this.NIF = NIF;
	}

	public String getNIF() {
		return this.NIF;
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

	public ProductosElegidos[] getProductos() {
		return this.productos;
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
		int i = this.productos.length;
		return i;
	}

}
