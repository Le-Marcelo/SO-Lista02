package controller;

public class SomaLinhas extends Thread{

	int[] vetor; 
	int linha;
	
	public SomaLinhas(int[] _vetor, int _linha) {
		vetor = _vetor;
		linha = _linha;
	}
	
	public void run() {
		int resultado = 0;
		
		for(int i = 0; i < vetor.length; i++) {
			resultado += vetor[i];
		}
		
		System.out.println("Soma da linha " + (linha + 1) + ": " + resultado);
	}
	
	

}
