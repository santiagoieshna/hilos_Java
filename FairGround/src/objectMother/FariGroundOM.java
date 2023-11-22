package objectMother;


import modelAtractions.AbstractProductor;
import modelAtractions.FactoryManager;


import model.park.Park;

public class FariGroundOM {

	public void populatePark(Park parque) throws Exception {
		
		
		for(int i=1; i<14; i++) {
			parque.addFairGround(GetRandomFairGround());
		}
		
	}

	private AbstractProductor GetRandomFairGround() {
	
		return FactoryManager.getRandomFairGround();
	}
	
}
