package hilos1_CrearHilos.crearThread01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomThreadTest {

	@Test
	void testRun() {
		CustomThread hilo1 = new CustomThread();
		
		hilo1.start();
		assertTrue(hilo1.isAlive());
		
		System.out.println("-----");
		System.out.println("Hilo antual : " + Thread.currentThread().getName());
		System.out.println("-----");
		
		// Polimorfismo para tener un Thread
		Thread hilo2 = new CustomThread();
		
		hilo2.run();
		assertFalse(hilo2.isAlive());
		
	}

}
