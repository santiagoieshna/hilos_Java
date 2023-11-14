package caja2024clientesColaMArketfuture07;

import java.time.Instant;
import java.util.concurrent.Callable;

//solo hay una caja
public class Caja implements Callable<Integer> {

	private String nombre;
	private Cola cola;
	private int clientesAtendidos;
	
	
	public Caja(String nombre, Cola cola) {
		this.nombre = nombre;
		this.cola = cola;
		clientesAtendidos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void procesarCompra(Cliente cliente, int timeStamp) {
		Instant older = Instant.now();
//		System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
//				+ cliente.getNombre() + " EN EL TIEMPO: " + older.getEpochSecond() + "seg");

//		esperarXsegundos(timeStamp);
		Utiles.wasteTime(5000);
//		System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + cliente.getNombre()
//		 + " EN EL TIEMPO: " + Duration.between(older, Instant.now()) + "seg");

	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 100);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public Integer call() {
		int procesamiento=0;
		Cliente cliente = null;
		do {
			try {
				cliente = cola.get();
				if (cliente != null) {
					procesarCompra(cliente, 1);
					Utiles.printMessage("Atiento a Cliente");
					incrementarClientesCajero();
					procesamiento++;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} while (!cola.totalClientesAlcanzado());
		return procesamiento;
	}

	public int getClientesAtendidos() {
		return clientesAtendidos;
	}
	
	private void incrementarClientesCajero() {
		this.clientesAtendidos++;
	}

}