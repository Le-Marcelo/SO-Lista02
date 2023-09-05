package controller;

public class ThreadId extends Thread {

	public ThreadId() {
		super();
	}
	
	public void run() {
		int id = (int) getId();
		System.out.println("ID da Thread: " + id);
		
	}
}
