package caja2024clientesColaMArketfuture07;

import java.util.ArrayDeque;
import java.util.Optional;

public class Cola {
	public ArrayDeque<Cliente> clientes = new ArrayDeque<>();
	private int totalClientes = 0;
	private final int CANTIDAD_CLIENTES = 20;
	
	private boolean push(Optional<Cliente> randomClient) {
		randomClient.ifPresent((cliente) -> {
			clientes.add(cliente);
			totalClientes++;
		});
		return randomClient.isPresent();
	}

	public boolean isBigger(int i) {
		return clientes.size() > 10;
	}

	public synchronized Cliente get() throws InterruptedException {
		while (clientes.isEmpty() && !totalClientesAlcanzado()) {
			
			Utiles.printMessage("Me duermo");
			wait();
			Utiles.printMessage("Me despierto");
		}
		if (!clientes.isEmpty())
			return clientes.poll();
		return null;
	}

	public boolean totalClientesAlcanzado() {
		
		return totalClientes > this.CANTIDAD_CLIENTES;
	}

	public synchronized void put(Optional<Cliente> optional) {
		if (push(optional)) {
			
			notify();}
	}

	public int size() {
		return clientes.size();
	}

	public boolean isEmpty() {
		return clientes.isEmpty();
	}

	public int getTotalClientes() {
		return totalClientes;
	}

	public synchronized void end() {
		notifyAll();
	}
}
