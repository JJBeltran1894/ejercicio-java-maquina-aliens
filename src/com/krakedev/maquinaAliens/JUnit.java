package com.krakedev.maquinaAliens;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JUnit {
	@Test
	void testCrearAlienNormal() {
		Alien alien = new Alien(3,"rojo");
		assertEquals(5,alien.getTamanio());
		assertEquals("rojo",alien.getColor());
		assertEquals(1.0,alien.getPrecioCuerpo(),0.01);
		assertEquals(0.5,alien.getPrecioExtremidad(),0.01);
		assertEquals(0.25,alien.getPrecioOjo(),0.01);
	}
	
}
