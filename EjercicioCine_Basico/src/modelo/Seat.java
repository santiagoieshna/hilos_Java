package modelo;

public class Seat {
	private boolean taken ;

	public Seat() {
		super();
		taken = false;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	

}
