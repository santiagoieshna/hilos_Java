package hilos5_Polling;

import java.util.Iterator;
import java.util.List;

public class MainPolling {

	public static void main(String[] args) throws InterruptedException {
		List<String> messages = List.of("message1", "message2", "message3", "message4", "message5", "message6");
		long patience = 10000;
		
		Runnable task = ()->{
			
			try {
				for (String message : messages) {
					
					Thread.sleep(2000);
					printName(message);
				}
			} catch (InterruptedException e) {
				printName("Hilo interrumpido");
			}
		};
		
		
		Thread.currentThread().setName("MAIN");
		
		long startTime = System.currentTimeMillis();
		
		Thread thread2 = new Thread(task, "thread2");
		thread2.start();
		
		while(thread2.isAlive()) {
			printName("Continuo esperando");
			thread2.join(1000L);
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			
			if(elapsedTime > patience && thread2.isAlive()) {
				printName("No espero mas !");
				thread2.interrupt();
				thread2.join(); // para esperar que termine de pararse, comentar para entender
			}
		}
		printName("Fin");
	}

	
	static void printName(String message) {
		
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
		
	}
	
}
