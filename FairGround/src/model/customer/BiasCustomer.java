package model.customer;

import java.util.List;
import java.util.Random;

import control.WorkingDay;
import model.park.Fraction;
import model.park.Statistics;
import modelAtractions.FairGround;

public class BiasCustomer {
	// las ganas que tiene de montarse en otra atraccion depende de lo bien
	// que se lo este pasando, aunque todo tiene un limite de X veces
	private int maxRides;
	private int actualRides = 0;
	private float maxRate = 10;
	private float minimumEnjoyment = 5f;
	private Fraction currentEnjoyment = new Fraction();
	private long breakTime = 1000;
	private WorkingDay workingDay;
	private List<FairGround> fairGrounds;

	public BiasCustomer(int maxRides, WorkingDay workingDay) {
		super();
		this.maxRides = maxRides;
		// Al principio tiene muchas ganas
		currentEnjoyment.incrementOneValoration(10);
		this.workingDay = workingDay;
	}

	public BiasCustomer(int maxRides, List<FairGround> fairGrounds) {
		super();
		this.maxRides = maxRides;
		// Al principio tiene muchas ganas
		currentEnjoyment.incrementOneValoration(10);
		this.fairGrounds = fairGrounds;

	}

	public CustomerCard takeRide() {
		FairGround atraccion = getRandomFairGround();
		CustomerCard valoracion = new CustomerCard(atraccion, new Random().nextFloat(11f));
		changeEnjoyment(valoracion.getRate());
		return valoracion;
	}

	private void changeEnjoyment(float rate) {
		this.currentEnjoyment.incrementOneValoration(rate);
	}

	private FairGround getRandomFairGround() {
		return getFairGrounds().get(new Random().nextInt(countFairGrounds()));
	}

	public float getCurrentValue() {
		return currentEnjoyment.getCurrentValue();
	}

	public boolean isStillExcited() {
		return this.currentEnjoyment.getCurrentValue() >= minimumEnjoyment;
	}

	private List<FairGround> getFairGrounds() {
		return workingDay.getFairGrounds();
	}
	

	private List<FairGround> getThisFairGrounds() {
		return this.fairGrounds;
	}

	private int countFairGrounds() {
		return workingDay.getFairGrounds().size();
	}

}
