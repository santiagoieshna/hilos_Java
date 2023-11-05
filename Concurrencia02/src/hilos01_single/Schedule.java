package hilos01_single;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Schedule {
	public static void main(String[] args) {
		
		Callable<String> taskAPI_1 = () -> {
			talkHilo("Api_1 despierta");
			return "Obteniendo Datos de API_1";
		};
		
		Callable<String> taskAPI_2 = () ->{
//			Thread.sleep(3000);
			talkHilo("Api_2 despierta");
			return  "Obteniendo Datos de API_2 ";
		};
		
		Runnable finish = ()-> {
			System.out.println("Fin con delay");
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getState());
		};
		
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		
		ScheduledFuture<String> futureApi_1 =executor.schedule(taskAPI_1, 5, TimeUnit.SECONDS);
		
		ScheduledFuture<String> futureApi_2 =executor.schedule(taskAPI_2, 1, TimeUnit.SECONDS);
		
		// se ejecuta cada 5 segundos.
		executor.scheduleWithFixedDelay(finish, 1, 5, TimeUnit.SECONDS); 
			
		try {
			Thread.sleep(15000);
			
			String resultadoApi_1 = futureApi_1.get();
			String resultadoApi_2 = futureApi_2.get();
			
			System.out.println(resultadoApi_1);
			System.out.println(resultadoApi_2);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally {
			executor.shutdown();
		}
		
		talkHilo("Acabe");

		
	}
	
	
	static void talkHilo(String string) {
		String threadName = Thread.currentThread().getName();
		String mensaje = String.format("%s: %s",threadName, string);
		System.out.println(mensaje);
	}
	
}
