package view;

import controller.PingSites;

public class Principal {

	public static void main(String[] args) {
		for(int i = 1; i <= 3; i++) {
			Thread ping = new PingSites(i);
			ping.start();
		}

	}

}
