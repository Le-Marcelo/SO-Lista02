package view;

import controller.CorridaSapos;

public class Principal {

	public static void main(String[] args) {
		int numSapos = 5;
		int distancia = 50;
		int puloMax = 10;
		
		for(int i = 0; i < numSapos; i++) {
			Thread sapo = new CorridaSapos(i, distancia, puloMax);
			sapo.start();
		}

	}

}
