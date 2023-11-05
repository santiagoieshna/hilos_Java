package hilos3_Wait;

public class MainWait {
	public static void main(String[] args) throws InterruptedException {
		
		Runnable tarea1 = ()->{
			for (int i = 0; i < 6; i++) {
				System.out.println("Tarea1 "+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread hilo = new Thread(tarea1);
		
		hilo.start();
		
		//.join() para que se espere la ejecucion hasta que termine el hilo
		hilo.join();
		
		System.out.println("Soy main");
		
		
	}
	

}
