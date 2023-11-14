package hilos1_CrearHilos.crearThread01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomThreadTest {

	@Test
	void testRun() {
//		Thread.currentThread().getName()
		CustomThread hilo1 = new CustomThread();
		hilo1.run();
		System.out.println("-------------------");
		hilo1.start();// aqui no entra main
		assertTrue(hilo1.isAlive());
//		System.out.println("Yo ya llegue");
//		
//		System.out.println("-----");
//		System.out.println("Hilo antual : " + Thread.currentThread().getName());
//		System.out.println("-----");
//		
//		// Polimorfismo para tener un Thread
//		Thread hilo2 = new CustomThread();
//		
//		hilo2.run();
//		assertFalse(hilo2.isAlive());
		
	}

}
