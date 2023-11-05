package hilos1_CrearHilos.crearThread02;

public class UsarTareas {
	public static void main(String[] args) {
		/*
		 * Runnable es una interfazz funcional
		 * podemos crear un thread y crear en el una Task para que la haga
		 * implementando el metodo de Runnable
		 */
		Thread hilo1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Creando una clase anonima Runnable");
				
			}
		});
		
		
		Thread hilo2 = new Thread(()->{
			//Con Lambda se implementa el metodo de la interfaz Runnable
			System.out.println("Task con Lambda");
		});
		
		hilo1.start();
		hilo2.start();
		
	}
}
