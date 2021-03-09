package Modelo;

public class Modelo {
public Tickets ticket;
public Pedidos pedidos;
public BDD BDD;
public Productos productos;
public ContadorNumPedido Contador;
public ArraysUtils ArraysUtils;
public ScriptsBDD ScriptsBDD;

public Modelo() {
	this.ticket = new Tickets();
	this.pedidos = new Pedidos();
	this.BDD = new BDD();
	this.productos = new Productos();
	this.Contador = new ContadorNumPedido();
	this.ArraysUtils = new ArraysUtils();
	this.ScriptsBDD = new ScriptsBDD();
}
}
