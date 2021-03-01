package Modelo;

public class Modelo {
public Tickets ticket;
public Pedidos pedidos;
public BDD BDD;
public Productos productos;
public Registrar registrar;
public ContadorNumPedido Contador;
public ArraysUtils ArraysUtils;

public Modelo() {
	this.ticket = new Tickets();
	this.pedidos = new Pedidos();
	this.BDD = new BDD();
	this.productos = new Productos();
	this.registrar = new Registrar();
	this.Contador = new ContadorNumPedido();
	this.ArraysUtils = new ArraysUtils();

}
}
