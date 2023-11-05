package hilos01_single;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		int vueltas = 3;
		
		var executor = Executors.newSingleThreadExecutor();
		
		Callable<Integer> task = ()-> 50 + 50;
		
		Future<Integer> future1= executor.submit(task);
		Future<Integer> future2 = executor.submit(taskLoop(vueltas));
		
		Integer resultado1 = future1.get();
		System.out.println(resultado1);
		
		Integer resultado2 = future2.get(2, TimeUnit.SECONDS);// Si se supera Throw --> TimeoutException
		System.out.println(resultado2);

		
		
	}
	
	
	static Callable<Integer> taskLoop(int vueltas) {
		return ()->{
			Integer suma = 0;
			//Thread.sleep(3000); // descomentar para ver como salta la TimeoutException
			for (int i = 0; i < vueltas; i++) {
				suma+=i;
			}
			return suma;
		};
	}
	
}
