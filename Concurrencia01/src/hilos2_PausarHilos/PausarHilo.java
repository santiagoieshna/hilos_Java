package hilos2_PausarHilos;

public class PausarHilo {

	public static void main(String[] args) {
		// .sleep() -> metodo que "duerme" pausa por un tiempo el hilo
		
		Runnable tarea1 = ()->{
			for (int i = 0; i < 6; i++) {
				System.out.println("Tarea1 "+i);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(tarea1).start();
		
	}
}
