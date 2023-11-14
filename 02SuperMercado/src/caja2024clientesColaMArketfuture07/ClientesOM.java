package caja2024clientesColaMArketfuture07;

import java.util.Optional;
import java.util.Random;

public class ClientesOM {
	private static int NUMERO_CLIENTE=0;
	public static Optional<Cliente> getRandomClient() {
		NUMERO_CLIENTE ++;
		return Optional.of(new Cliente("cliente "+NUMERO_CLIENTE, new int[] {1,1,1}));
	}
	public static Optional<Cliente> getRandomClientOptionalNullable() {
		Cliente retorno=new Cliente("cliente "+new Random().nextInt(100), new int[] {1,1,1});
		return new Random().nextBoolean()?Optional.ofNullable(retorno):Optional.ofNullable(null);
	}
}
