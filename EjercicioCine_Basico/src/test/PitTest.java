package test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import modelo.Pit;
import modelo.Reference;
import modelo.Seat;
import modelo.User;

class PitTest {

	@Ignore
	void test() throws ExecutionException, InterruptedException {
		Pit pit = new Pit();
		
		User user1 = new User("1", pit);
		User user2 = new User("2", pit);
		User user3 = new User("3", pit);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<Reference> submit1 = executor.submit(user1);
		Future<Reference> submit2 = executor.submit(user2);
		Future<Reference> submit3 = executor.submit(user3);
		
		Reference asiento1 = submit1.get();
		Reference asiento2 = submit2.get();
		Reference asiento3 = submit3.get();
		
		System.out.println(asiento1.toString());
		System.out.println(asiento2.toString());
		System.out.println(asiento3.toString());

	}
	
	@Test
	void test2() throws ExecutionException, InterruptedException {
		Long startTime = System.currentTimeMillis();
		Pit pit = new Pit();
		int numeroUsuario = 200;
		
		List<Future<Reference>> referencias = new ArrayList<>();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i= 0; i < numeroUsuario; i++) {
			String id = String.valueOf(i);
			Future<Reference> submit = executor.submit(new User(id, pit));
			referencias.add(submit);
		}

		int numeroReferencia=1;
		for (Future<Reference> referencia : referencias) {
			System.out.format("%s| %s%n",numeroReferencia, referencia.get());
			numeroReferencia++;
		}
		
		// <Character, Row)>  row-> list<Seat>
		long sillasOcupadas = pit.getRows().keySet().stream()
							  .map(letra-> pit.getRows().get(letra))
							  .map(row-> row.getSeats())
							  .flatMap(List::stream).filter(seat->seat.isTaken()).count();
		System.out.println("Silas Ocupadas: "+sillasOcupadas);					  
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime+" segundos papa");
	}
}
