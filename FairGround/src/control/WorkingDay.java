package control;

import java.util.ArrayList;
import java.util.List;

import model.customer.BiasCustomer;
import model.park.Park;
import modelAtractions.FairGround;

public class WorkingDay {

	private Park park;
	private ArrayList<BiasCustomer> customers=new ArrayList<>();
	private int happyCustomers;
	private int totalCustomers;
	
	public List<FairGround> getFairGrounds() {
		return park.getFairGrounds();
	}
	
	
	public WorkingDay() {
		super();
	}

	public WorkingDay(Park park) {
		super();
		this.park = park;
	}
	public WorkingDay(Park park, ArrayList<BiasCustomer> customers) {
		super();
		this.park = park;
		this.customers = customers;
	}


	public Park getPark() {
		return park;
	}


	public void setPark(Park park) {
		this.park = park;
	}


	public ArrayList<BiasCustomer> getCustomers() {
		return customers;
	}


	public void setCustomers(ArrayList<BiasCustomer> customers) {
		this.customers = customers;
	}


	public int getHappyCustomers() {
		return happyCustomers;
	}


	public void setHappyCustomers(int happyCustomers) {
		this.happyCustomers = happyCustomers;
	}


	public int getTotalCustomers() {
		return totalCustomers;
	}


	public void setTotalCustomers(int totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	
	
	
	
	
}
