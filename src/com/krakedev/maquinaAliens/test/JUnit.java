package com.krakedev.maquinaAliens.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.maquinaAliens.Alien;

class JUnit {
	@Test
	void testCrearAlienNormal() {
		Alien alien = new Alien(3,"rojo");
		assertEquals(5,alien.getTamanio());
		assertEquals("rojo",alien.getColor());
		assertEquals(1.0,alien.getPrecioCuerpo(),0.01);
		assertEquals(0.5,alien.getPrecioExtremidad(),0.01);
		assertEquals(0.25,alien.getPrecioOjo(),0.01);
		
		Alien alien1 = new Alien(50,"rojo");
		assertEquals(30,alien1.getTamanio());
		assertEquals("rojo",alien1.getColor());
		assertEquals(6.0,alien1.getPrecioCuerpo(),0.01);
		assertEquals(3.0,alien1.getPrecioExtremidad(),0.01);
		assertEquals(1.5,alien1.getPrecioOjo(),0.01);
		
		Alien alien2 = new Alien(20,"rojo");
		assertEquals(20,alien2.getTamanio());
		assertEquals("rojo",alien2.getColor());
		assertEquals(4.0,alien2.getPrecioCuerpo(),0.01);
		assertEquals(2.0,alien2.getPrecioExtremidad(),0.01);
		assertEquals(1.,alien2.getPrecioOjo(),0.01);
		
		alien2.imprimir();
		alien1.toString();
	}
	
}
