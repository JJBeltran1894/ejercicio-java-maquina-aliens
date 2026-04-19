package com.krakedev.maquinaAliens.test;

import org.junit.jupiter.api.Test;

import com.krakedev.maquinaAliens.Alien;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

	public class TestAlienAI {

	    // Tolerancia para las aserciones de valores double
	    private static final double DELTA = 0.001;

	    @Test
	    public void testConstructorTamanioNormal() {
	        // Validación: Verifica que un tamaño dentro del rango (5 - 30) se asigne correctamente y calcule los precios.
	        Alien alien = new Alien(15, "Verde");

	        // El tamaño debe ser el ingresado
	        assertEquals(15, alien.getTamanio(), "El tamaño dentro del rango debe asignarse sin modificaciones.");
	        assertEquals("Verde", alien.getColor(), "El color debe asignarse correctamente.");
	        
	        // Verificación de cálculos matemáticos de precios base
	        // Precio Cuerpo: 20% de 15 = 3.0
	        assertEquals(3.0, alien.getPrecioCuerpo(), DELTA, "El precio del cuerpo debe ser el 20% del tamaño.");
	        // Precio Extremidad: 10% de 15 = 1.5
	        assertEquals(1.5, alien.getPrecioExtremidad(), DELTA, "El precio de la extremidad debe ser el 10% del tamaño.");
	        // Precio Ojo: 5% de 15 = 0.75
	        assertEquals(0.75, alien.getPrecioOjo(), DELTA, "El precio del ojo debe ser el 5% del tamaño.");
	        
	        // Verificamos que las partes del cuerpo inicialicen en 0 (por defecto en Java para int)
	        assertEquals(0, alien.getNumeroOjos(), "El alien debe inicializarse con 0 ojos.");
	        assertEquals(0, alien.getNumeroBrazos(), "El alien debe inicializarse con 0 brazos.");
	        assertEquals(0, alien.getNumeroPies(), "El alien debe inicializarse con 0 pies.");
	    }

	    @Test
	    public void testConstructorTamanioMenorAlMinimo() {
	        // Validación: Verifica la restricción inferior. Si se ingresa un tamaño < 5, debe ajustarse a 5.
	        Alien alien = new Alien(2, "Rojo");

	        // El tamaño debe auto-ajustarse al mínimo permitido (5)
	        assertEquals(5, alien.getTamanio(), "Si el tamaño es menor a 5, debe ajustarse automáticamente a 5.");
	        
	        // Los precios deben calcularse en base al nuevo tamaño ajustado (5)
	        assertEquals(1.0, alien.getPrecioCuerpo(), DELTA, "El precio del cuerpo debe calcularse sobre el tamaño ajustado de 5.");
	        assertEquals(0.5, alien.getPrecioExtremidad(), DELTA, "El precio de la extremidad debe calcularse sobre el tamaño ajustado de 5.");
	        assertEquals(0.25, alien.getPrecioOjo(), DELTA, "El precio del ojo debe calcularse sobre el tamaño ajustado de 5.");
	    }

	    @Test
	    public void testConstructorTamanioMayorAlMaximo() {
	        // Validación: Verifica la restricción superior. Si se ingresa un tamaño > 30, debe ajustarse a 30.
	        Alien alien = new Alien(50, "Azul");

	        // El tamaño debe auto-ajustarse al máximo permitido (30)
	        assertEquals(30, alien.getTamanio(), "Si el tamaño es mayor a 30, debe ajustarse automáticamente a 30.");
	        
	        // Los precios deben calcularse en base al nuevo tamaño ajustado (30)
	        assertEquals(6.0, alien.getPrecioCuerpo(), DELTA, "El precio del cuerpo debe calcularse sobre el tamaño ajustado de 30.");
	        assertEquals(3.0, alien.getPrecioExtremidad(), DELTA, "El precio de la extremidad debe calcularse sobre el tamaño ajustado de 30.");
	        assertEquals(1.5, alien.getPrecioOjo(), DELTA, "El precio del ojo debe calcularse sobre el tamaño ajustado de 30.");
	    }

	    @Test
	    public void testConstructorTamanioLimiteMinimoExacto() {
	        // Validación: Verifica el comportamiento en la frontera exacta inferior (5).
	        Alien alien = new Alien(5, "Amarillo");

	        // Al ser un límite válido, debe mantenerse en 5
	        assertEquals(5, alien.getTamanio(), "El tamaño exacto de 5 es válido y no debe modificarse.");
	    }

	    @Test
	    public void testConstructorTamanioLimiteMaximoExacto() {
	        // Validación: Verifica el comportamiento en la frontera exacta superior (30).
	        Alien alien = new Alien(30, "Morado");

	        // Al ser un límite válido, debe mantenerse en 30
	        assertEquals(30, alien.getTamanio(), "El tamaño exacto de 30 es válido y no debe modificarse.");
	    }
	    
	    @Test
	    public void testImprimirYToString() {
	        // Preparación del Alien
	        Alien alien = new Alien(10, "Gris");

	        // --------------------------------------------------------
	        // 1. Validar el método toString()
	        // --------------------------------------------------------
	        String resultadoToString = alien.toString();
	        
	        // Usamos assertTrue con .contains() para verificar que el texto tenga los valores correctos
	        assertTrue(resultadoToString.contains("tamanio=10"), "El toString debe contener el tamaño asignado.");
	        assertTrue(resultadoToString.contains("color=Gris"), "El toString debe contener el color asignado.");
	        assertTrue(resultadoToString.contains("numeroOjos=0"), "El toString debe mostrar los ojos inicializados.");

	        // --------------------------------------------------------
	        // 2. Validar el método imprimir()
	        // --------------------------------------------------------
	        
	        // Guardamos la salida original de la consola para no dañarla
	        PrintStream consolaOriginal = System.out;
	        
	        // Creamos un interceptor (stream) para capturar el texto
	        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(salidaCapturada)); // Redirigimos la consola aquí

	        try {
	            // Acción: Ejecutamos el método (ahora imprimirá en nuestro interceptor en lugar de la pantalla)
	            alien.imprimir(); 
	            
	            // Convertimos lo que capturó a un String
	            String textoImpreso = salidaCapturada.toString();
	            
	            // Validaciones: Verificamos que la consola haya recibido las líneas correctas
	            assertTrue(textoImpreso.contains("Tamaño: 10"), "La consola debe imprimir el tamaño correcto.");
	            assertTrue(textoImpreso.contains("Color: Gris"), "La consola debe imprimir el color correcto.");
	            assertTrue(textoImpreso.contains("Precio Ojo:"), "La consola debe imprimir la etiqueta de precio del ojo.");
	            assertTrue(textoImpreso.contains("---------"), "La consola debe imprimir el separador visual.");
	            
	        } finally {
	            // Limpieza (Teardown): 
	            // MUY IMPORTANTE, restauramos la consola a su estado normal pase lo que pase
	            System.setOut(consolaOriginal);
	        }
	    }
	    
	    
	    
	}
