package hilos01_single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableDemo {
	
	public static void main(String[] args) {
		/*
		 * El objetivo de esta clase es usar ejecutores de hilos
		 */
		
		Runnable task1 = ()-> System.out.println("Hola Mundo");
		Runnable task2 = ()->{
			for (int i = 0; i < 3; i++) {
				System.out.println("Hola Mundo "+i);
			}
		};
		
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		System.out.println("Begin");
		executor.execute(task1);
		executor.execute(task2);
		executor.execute(task1);
		System.out.println("End");
	//	executor.shutdownNow(); //Termina, hayan acabado las tareas o no
		executor.shutdown(); //Termina cuando acabe de ejecutar todo
		
		
	}
	
	
	
	
	
}
