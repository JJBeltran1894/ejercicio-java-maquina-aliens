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
	
	
	
	
}
