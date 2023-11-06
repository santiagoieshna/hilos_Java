package modelo;

import java.util.ArrayList;
import java.util.List;

public class Row {
	public int amountSeats = 10;
	public List<Seat> seats;

	public Row() {
		super();
		createSeats();
	}

	private void createSeats() {
		seats = new ArrayList<Seat>();
		for (int i = 0; i < amountSeats; i++) {
			seats.add(new Seat());
		}
	}

	public Seat getSeat(int number) {
		return seats.get(number);
	}
	
	public List<Seat> getSeats(){
		return seats;
	}
}
