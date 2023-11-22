package objectMother;

import model.park.Park;

import java.util.ArrayList;
import java.util.List;

import model.customer.BiasCustomer;

public class CustomersOM {
	
	public List<BiasCustomer> customers(int cantidadVisitante, Park parque) {
		int numeroMontadas = 5;
		List<BiasCustomer> visitantes = new ArrayList<>();
		
		for(int i= 0 ; i < cantidadVisitante; i++) {
			BiasCustomer visitante = new BiasCustomer(numeroMontadas, parque.getFairGrounds());
			visitantes.add(visitante);
		}
		return visitantes;
	}
	
}
