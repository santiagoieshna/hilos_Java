package modelo;

import java.util.HashMap;

public class Pit {
	public int amountRows = 10;
	private HashMap<Character, Row> rows;
	private char letter = 'a';
	private Integer sillasOcupadas;
	
	public Pit() {
		super();
		sillasOcupadas=0;
		
		rows = new HashMap<Character, Row>();
		for (int i = 0; i < amountRows; i++) {
			rows.put(letter, new Row());
			letter++;
		}
	}

	private Row getRow(char letter) {
		return rows.get(letter);
	}

	public HashMap<Character, Row> getRows() {
		return rows;
	}

	private Seat getSeat(char letra, int seat) {
		return getSeat(getRow(letra), seat);
	}

	private Seat getSeat(Row fila, int seat) {
		return fila.getSeat(seat);
	}

	private void takenSeat(Seat seat) {
		seat.setTaken(true);
	}
	public  boolean takeSeat(Reference reference) {
		return takeSeat(reference.getRow(),reference.getColum());
	}
	
	public synchronized  boolean takeSeat(char letter, int seat) {
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Seat requestedSeat = getSeat(letter, seat);
		if (!requestedSeat.isTaken()) {
			takenSeat(requestedSeat);
			incrementarAsientoOcupado();
			return true;
		}
		return false;
	}

	private void incrementarAsientoOcupado() {
		sillasOcupadas++;
	}
	
	public boolean isFill() {
		return sillasOcupadas>=(amountRows*10);
	}

	public Integer getSillasOcupadas() {
		return sillasOcupadas;
	}
}
