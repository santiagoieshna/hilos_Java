package hilos1_CrearHilos.crearThread01;

public class CustomThread extends Thread {
	
	
	@Override
	public void run() {
		try {
			this.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("CustomThread");
		System.out.println("ID: "+ this.getId());
		System.out.println("Nombre: "+ this.getName());
		System.out.println("Estado: "+ this.getState());
		System.out.println("Vivo: "+this.isAlive());
	}



}
