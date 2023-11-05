package hilos4_Stop;

public class CustomTask implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 13; i++) {
			System.out.println("Aqui estoy " + i);

			if (Thread.interrupted()) {
				System.out.println("Salgo viendo que esta interrumpido");
				return;
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.out.println("Salgo desde Catch");
				return;
			}

		}

	}

}
