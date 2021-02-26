package Modelo;

public class Modelo {
public Tickets ticket;
public Pedidos pedidos;
public BDD BDD;
public Productos productos;

public Modelo() {
	this.ticket = new Tickets();
	this.pedidos = new Pedidos();
	this.BDD = new BDD();
	this.productos = new Productos();

}
}
