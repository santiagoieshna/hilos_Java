package concurriencia01;

public class Allthreads {

	public static void main(String[] args) {
		
		Thread.getAllStackTraces().keySet().forEach(thread->{
			System.out.println(thread.getId());
			System.out.println(thread.getName());
			System.out.println(thread.getState());
		});

	}

}
