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
	private double precioTotal;

	
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
		this.precioTotal =0.0;
		
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
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	private int sumarExtremidades(int nuevasExtremidades) {
		int extremidades = numeroBrazos + numeroPies + nuevasExtremidades;
		return extremidades;
	}

	public boolean agregarBrazos(int cantidad) {
		if (sumarExtremidades(cantidad) > 10) {
			return false;
		} else {
			this.numeroBrazos += cantidad;
			this.calcularPrecioTotal();
			return true;
		}
	}

	public boolean agregarPies(int cantidad) {
		if (sumarExtremidades(cantidad) > 10) {
			return false;
		} else {
			this.numeroPies += cantidad;
			this.calcularPrecioTotal();
			return true;
		}
	}
	
	private boolean validarNumeroOjos(int ojosNuevos, int limiteOjos) {
		if (numeroOjos + ojosNuevos <= limiteOjos) {
			return true;
		} else {
			return false;
		}
	}

	public boolean agregarOjos(int cantidad) {
		if (tamanio <= 10 && validarNumeroOjos(cantidad, 3)) {
			numeroOjos += cantidad;
			this.calcularPrecioTotal();
			return true;
		} else if (tamanio > 10 && tamanio <= 20 && validarNumeroOjos(cantidad, 5)) {
			numeroOjos += cantidad;
			this.calcularPrecioTotal();
			return true;
		} else if (tamanio > 20 && validarNumeroOjos(cantidad, 7)) {
			numeroOjos += cantidad;
			this.calcularPrecioTotal();
			return true;
		} else {
			return false;
		}

	}
	
	public void calcularPrecioTotal() {
		this.precioTotal = precioCuerpo + (numeroBrazos + numeroPies) * precioExtremidad + numeroOjos * precioOjo;
	}

	@Override
	public String toString() {
		return "Alien [tamanio=" + tamanio + ", color=" + color + ", numeroOjos=" + numeroOjos + ", numeroBrazos="
				+ numeroBrazos + ", numeroPies=" + numeroPies + ", precioExtremidad=" + precioExtremidad
				+ ", precioOjo=" + precioOjo + ", precioCuerpo=" + precioCuerpo +", precioTotal=" + precioTotal + "]";
	}

	public void imprimir() {
		String mensaje = "---------\nTamaño: " + tamanio + "\nColor: " + color + "\nN° Ojos: " + numeroOjos
				+ "\nN° Brazos: " + numeroBrazos + "\nN° Pies: " + numeroPies + "\nPrecio extremidad: "
				+ String.format("%.2f", precioExtremidad) + "\nPrecio Ojo: " + String.format("%.2f", precioOjo)
				+ "\nPrecio Cuerpo: " + String.format("%.2f", precioCuerpo)
				+ "\nPrecio Total: " + String.format("%.2f", precioTotal);

		System.out.println(mensaje);
	}
	
}
