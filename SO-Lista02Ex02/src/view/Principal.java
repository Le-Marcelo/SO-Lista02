package view;

import controller.SomaLinhas;

public class Principal {

	public static void main(String[] args) {
		int[][] matriz = new int[3][5];
		
		//Preencher a matriz 3x5 com números entre 0 e 100
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				matriz[i][j] = (int) (Math.random() * 101);
			}
		}
		
		for(int i = 0; i < 3; i++) {
			Thread soma = new SomaLinhas(matriz[i], i);
			soma.start();
		}
	}

}
