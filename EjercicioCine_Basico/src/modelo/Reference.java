package modelo;

import java.util.Random;

public class Reference {

	private char row;
	private int colum;

	public Reference(char row, int seat) {
		super();
		this.row = row;
		this.colum = seat;
	}

	public char getRow() {
		return row;
	}

	public void setRow(char row) {
		this.row = row;
	}

	public int getColum() {
		return colum;
	}

	public void setColum(int colum) {
		this.colum = colum;
	}

	public static Reference getRandomReference() {
		char letter='a';
		int maximum=10;
		
		char randomChar=(char) ('a'+ new Random().nextInt(maximum));
		int randomNumber=new Random().nextInt(maximum);
		return new Reference(randomChar, randomNumber);
	}

	@Override
	public String toString() {
		return row+" "+colum;
	}
}
