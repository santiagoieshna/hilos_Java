package hilos1_CrearHilos.crearThread02;

public class CustomRunnable implements Runnable{

	
	@Override
	public void run() {
		System.out.println("CustomThread");
		System.out.println("ID: "+ Thread.currentThread().getId());
		System.out.println("Nombre: "+ Thread.currentThread().getName());
		System.out.println("Estado: "+ Thread.currentThread().getState());
	}

	

}
