package Modelo;

public class ContadorNumPedido {
	private String contador = "1";

	public String getContador() {
		return this.contador;
	}

	public void setContador(String contador) {
		int contador1 = Integer.parseInt(contador);
		contador1 = contador1 + 1;
		String contador2 = String.valueOf(contador1);
		this.contador = contador2;
	}
}
