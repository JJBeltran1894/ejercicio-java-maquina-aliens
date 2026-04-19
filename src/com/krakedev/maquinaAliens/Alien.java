package com.krakedev.maquinaAliens;

public class Alien {
	private int tamanio;
	private String color;
	private int numeroOjos;
	private int numeroBrazos;
	private int numeroPies;
	private double precioExtremidad;
	private double precioOjo;
	private double precioCuerpo;

	
	public Alien(int tamanio, String color) {
		if (tamanio<5) {
			this.tamanio=5;
		}else if(tamanio>30) {
			this.tamanio=30;
		}else {
			this.tamanio=tamanio;
		}
		
		this.color = color;
		this.precioCuerpo = this.tamanio*0.2;
		this.precioExtremidad = this.tamanio*0.1;
		this.precioOjo = this.tamanio*.05;

		
	}

	public int getTamanio() {
		return tamanio;
	}

	public String getColor() {
		return color;
	}

	public int getNumeroOjos() {
		return numeroOjos;
	}

	public int getNumeroBrazos() {
		return numeroBrazos;
	}

	public int getNumeroPies() {
		return numeroPies;
	}

	public double getPrecioExtremidad() {
		return precioExtremidad;
	}

	public double getPrecioOjo() {
		return precioOjo;
	}

	public double getPrecioCuerpo() {
		return precioCuerpo;
	}
	


	@Override
	public String toString() {
		return "Alien [tamanio=" + tamanio + ", color=" + color + ", numeroOjos=" + numeroOjos + ", numeroBrazos="
				+ numeroBrazos + ", numeroPies=" + numeroPies + ", precioExtremidad=" + precioExtremidad
				+ ", precioOjo=" + precioOjo + ", precioCuerpo=" + precioCuerpo + "]";
	}

	public void imprimir() {
		String mensaje = "---------\nTamaño: " + tamanio + "\nColor: " + color + "\nN° Ojos: " + numeroOjos
				+ "\nN° Brazos: " + numeroBrazos + "\nN° Pies: " + numeroPies + "\nPrecio extremidad: "
				+ String.format("%.2f", precioExtremidad) + "\nPrecio Ojo: " + String.format("%.2f", precioOjo)
				+ "\nPrecio Cuerpo: " + String.format("%.2f", precioCuerpo);

		System.out.println(mensaje);
	}
	
}
