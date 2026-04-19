package com.krakedev.maquinaAliens.test;

import org.junit.jupiter.api.Test;

import com.krakedev.maquinaAliens.Alien;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
	    
	    @Test
	    public void testAgregarExtremidadesCasosValidos() {
	        // Validación: Verifica que se puedan agregar extremidades dentro del límite permitido.
	        Alien alien = new Alien(15, "Rojo");
	        
	        // Agregar 4 brazos debe retornar true
	        assertTrue(alien.agregarBrazos(4), "Debe permitir agregar 4 brazos.");
	        assertEquals(4, alien.getNumeroBrazos(), "El número de brazos debe ser 4.");
	        
	        // Agregar 2 pies debe retornar true (Total = 6 extremidades)
	        assertTrue(alien.agregarPies(2), "Debe permitir agregar 2 pies.");
	        assertEquals(2, alien.getNumeroPies(), "El número de pies debe ser 2.");
	    }

	    @Test
	    public void testAgregarExtremidadesCasoLimite() {
	        // Validación: Verifica el comportamiento en la frontera exacta (10 extremidades).
	        Alien alien = new Alien(20, "Azul");
	        
	        // Agregar exactamente 10 brazos de una vez debe ser permitido
	        assertTrue(alien.agregarBrazos(10), "Debe permitir alcanzar el límite exacto de 10 brazos.");
	        assertEquals(10, alien.getNumeroBrazos(), "Debe tener 10 brazos asignados.");
	        
	        // Intentar agregar 1 pie extra cuando ya hay 10 extremidades debe fallar
	        assertFalse(alien.agregarPies(1), "No debe permitir exceder el límite de 10 extremidades.");
	        assertEquals(0, alien.getNumeroPies(), "El número de pies debe mantenerse en 0.");
	    }

	    @Test
	    public void testAgregarExtremidadesCasosCombinadosYExceso() {
	        // Validación: Verifica combinaciones que sobrepasan el límite tras varias asignaciones.
	        Alien alien = new Alien(25, "Gris");
	        
	        // 1. Agregamos 6 brazos (Válido)
	        assertTrue(alien.agregarBrazos(6), "Debe permitir agregar 6 brazos.");
	        
	        // 2. Intentamos agregar 5 pies (6 + 5 = 11 -> Inválido)
	        assertFalse(alien.agregarPies(5), "No debe permitir agregar 5 pies si ya hay 6 brazos (supera 10).");
	        
	        // El número de pies no debió alterarse
	        assertEquals(0, alien.getNumeroPies(), "Si falla la asignación, los pies no deben modificarse.");
	        
	        // 3. Agregamos 4 pies para llegar al límite exacto (6 + 4 = 10 -> Válido)
	        assertTrue(alien.agregarPies(4), "Debe permitir agregar 4 pies para completar las 10 extremidades.");
	        assertEquals(4, alien.getNumeroPies(), "Debe tener 4 pies asignados.");
	    }
	    
	    @Test
	    public void testAgregarBrazosExcedeLimite() {
	        // Validación: Verifica que agregarBrazos retorne false si supera el límite.
	        Alien alien = new Alien(15, "Morado");
	        
	        // Preparamos el terreno agregando 8 pies
	        alien.agregarPies(8); 
	        
	        // Acción: Intentamos agregar 3 brazos (8 + 3 = 11 -> Inválido)
	        boolean resultado = alien.agregarBrazos(3);
	        
	        // Verificaciones
	        assertFalse(resultado, "Debe retornar false al intentar superar las 10 extremidades agregando brazos.");
	        assertEquals(0, alien.getNumeroBrazos(), "El número de brazos debe mantenerse en 0 porque la operación falló.");
	    }

	    @Test
	    public void testAgregarOjosRangoPequeno() {
	        // Alien pequeño (5 - 10 cm) -> Límite: 3 ojos
	        Alien alien = new Alien(8, "Blanco");
	        
	        // Agregar 3 ojos debe ser válido
	        assertTrue(alien.agregarOjos(3), "Debe permitir 3 ojos para un alien de 8cm.");
	        // Intentar agregar 1 más debe fallar
	        assertFalse(alien.agregarOjos(1), "No debe permitir más de 3 ojos en tamaño pequeño.");
	    }

	    @Test
	    public void testAgregarOjosRangoMediano() {
	        // Alien mediano (>10 - 20 cm) -> Límite: 5 ojos
	        Alien alien = new Alien(15, "Verde");
	        
	        // Agregar 5 ojos debe ser válido
	        assertTrue(alien.agregarOjos(5), "Debe permitir 5 ojos para un alien de 15cm.");
	        // Intentar agregar 1 más debe fallar
	        assertFalse(alien.agregarOjos(1), "No debe permitir más de 5 ojos en tamaño mediano.");
	    }

	    @Test
	    public void testAgregarOjosRangoGrande() {
	        // Alien grande (>20 - 30 cm) -> Límite: 7 ojos
	        Alien alien = new Alien(25, "Rojo");
	        
	        // Agregar 7 ojos debe ser válido
	        assertTrue(alien.agregarOjos(7), "Debe permitir 7 ojos para un alien de 25cm.");
	        // Intentar agregar 1 más debe fallar
	        assertFalse(alien.agregarOjos(1), "No debe permitir más de 7 ojos en tamaño grande.");
	    }
	    	    
	    
	}
