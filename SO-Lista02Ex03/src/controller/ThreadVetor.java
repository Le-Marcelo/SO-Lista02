package controller;

public class ThreadVetor extends Thread {

	int num;
	int[] vetor;
	
	
	public ThreadVetor(int _num, int[] _vetor) {
		num = _num;
		vetor = _vetor;
	}
	
	public void run() {
		if(num % 2 == 0) {
			double tempoInicial = System.nanoTime();
			for(int i = 0; i < vetor.length; i++) {
				//For vazio para contagem de tempo
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = (tempoFinal - tempoInicial) / 1000000000;
			
			System.out.println("Tempo da estrutura For: " + String.format("%.5f", tempoTotal) + "s ou " + String.format("%.3f", tempoTotal / 1000000) + "ms");
		}else {
			double tempoInicial = System.nanoTime();
			for(int i : vetor) {
				//ForEach vazio para contagem de tempo
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - tempoInicial;
			
			System.out.println("Tempo da estrutura ForEach: " + String.format("%.5f", tempoTotal / 1000000000) + "s ou " + String.format("%.3f", tempoTotal / 1000000) + "ms");
		}
	}

}
