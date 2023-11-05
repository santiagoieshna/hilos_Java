package hilos1_CrearHilos.crearThread01;

public class CustomThread extends Thread {
	
	
	@Override
	public void run() {
		System.out.println("CustomThread");
		System.out.println("ID: "+ this.getId());
		System.out.println("Nombre: "+ this.getName());
		System.out.println("Estado: "+ this.getState());
	}



}
