package hilos4_Stop;


public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable task1 = new CustomTask();
		
		Thread hilo1 = new Thread(task1);
		
		hilo1.start();
		
		Thread.sleep(5000L); //Pauso el hilo principal 5s
		
		if(hilo1.isAlive())
			hilo1.interrupt();;
		
			
		
		
	}
	
}
