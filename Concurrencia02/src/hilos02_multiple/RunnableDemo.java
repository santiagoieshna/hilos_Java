package hilos02_multiple;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class RunnableDemo {

	public static void main(String[] args) {
		
		// long startTime = System.currentTimeMillis();
		Runnable task = ()->{
			try {
				Thread.sleep(1000);
				System.out.println("Hola Mundo ");
			} catch (InterruptedException e) {
				System.out.println("Me interrumpi");
			}
		};
		
		// Asignamos 3 hilos
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		System.out.println("Begin");
		executor.execute(task);
		executor.execute(task);
		executor.execute(task);
		executor.execute(task);
		executor.execute(task);
		System.out.println("End");
		
		executor.shutdown(); 
		
		System.out.println(executor.isShutdown());
		
		
	}

}
