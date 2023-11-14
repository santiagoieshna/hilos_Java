package caja2024clientesColaMArketfuture07;

public class Utiles {
	public static void wasteTime(int i) {
		String cString = "";
		for (int j = 0; j < i; j++) {
			cString += "a";
		}
	}
	
	public static void printMessage(String message) {
		String name = Thread.currentThread().getName();
		String mensaje = String.format("%s : %s",name, message);
		System.out.println(mensaje);
	}
}
