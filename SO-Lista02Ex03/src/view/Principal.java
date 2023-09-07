package view;

import controller.ThreadVetor;

public class Principal {

	public static void main(String[] args) {
		int[] vetor = new int[1000];
		
		for(int i = 0; i < 1000; i++) {
			vetor[i] = (int) (Math.random() * 100 + 1);
		}
		for(int i = 1; i <= 2; i++) {
			Thread tVetor = new ThreadVetor(i, vetor);
			tVetor.start();
		}
	}

}
