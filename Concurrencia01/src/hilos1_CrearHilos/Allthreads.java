package hilos1_CrearHilos;

public class Allthreads {

	public static void main(String[] args) {
		
		Thread.getAllStackTraces().keySet().forEach(thread->{
			System.out.println("ID: "+thread.getId());
			System.out.println("Nombre: "+thread.getName());
			System.out.println("Estado: "+thread.getState());
			System.out.println("Alive: "+thread.isAlive());
			System.out.println("Daemon: "+thread.isDaemon());
			System.out.println("Interrupte: "+thread.isInterrupted());
			System.out.println("===============");
			
		});
		

	}

}
