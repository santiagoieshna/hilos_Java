package hilos1_CrearHilos.crearThread02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomRunnableTest {

	@Test
	void testRun() {
		CustomRunnable task1 = new CustomRunnable();
		Thread hilo1 = new Thread(task1);
		
		hilo1.start();
		assertTrue(hilo1.isAlive());
		
		System.out.println("-----");
		System.out.println("Hilo antual : " + Thread.currentThread().getName());
		System.out.println("-----");
		
		// Polimorfismo para tener un Thread
		Runnable task2 = new CustomRunnable();
		Thread hilo2 = new Thread(task2);
		
		hilo2.run();
		assertFalse(hilo2.isAlive());
	}

}
