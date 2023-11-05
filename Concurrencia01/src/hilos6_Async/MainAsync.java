package hilos6_Async;

public class MainAsync {
	public static void main(String[] args) {
		
		Thread hilo1 = new Thread(()-> System.out.println("Hola1"), "hilo1");
		Thread hilo2 = new Thread(()-> System.out.println("Hola2"), "hilo2");
		Thread hilo3 = new Thread(()-> System.out.println("Hola3"), "hilo3");
		
		//ASINCRONO -> cada uno va a su bola
		System.out.println("Inicio Asincrono");
		hilo1.start();
		hilo2.start();
		hilo3.start();
		System.out.println("Fin Asincrono");

		//SINCRONO --> El hilo principal queda bloqueado hasta que terminen los hilos
//		System.out.println("Inicio Sincrono");
//		hilo1.run();
//		hilo2.run();
//		hilo3.run();
//		System.out.println("Fin Sincrono");

	}
}
