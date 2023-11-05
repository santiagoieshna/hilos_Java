package hilos01_single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Await {

    public static void main(String[] args) throws InterruptedException {
    	
    	ExecutorService executor = Executors.newSingleThreadExecutor();
    	
    	Runnable tareita = ()->{
    		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
    		System.out.println("Obeniendo Datos");
    	};
    	
    	try {
    		executor.execute(tareita);
    		executor.execute(tareita);
    		executor.execute(tareita);
    	}finally {
			executor.shutdown();
		}
    	
    	executor.awaitTermination(4000, TimeUnit.MILLISECONDS);
    	saveInMySQL();
    	
    }

    
    
	private static void saveInMySQL() {
		System.out.println("Guardando datos en BD");
	}
}