package controller;

import java.util.concurrent.atomic.AtomicInteger;

public class CorridaSapos extends Thread {

	int numSapo, distanciaMax, puloMax, colocacao;
	static AtomicInteger posicao = new AtomicInteger(1);
	
	public CorridaSapos(int _numSapo, int _distanciaMax, int _puloMax) {
		numSapo = _numSapo;
		distanciaMax = _distanciaMax;
		puloMax = _puloMax;
	}
	
	@Override
	public void run() {
		int distanciaAtual = 0, pulo;
		
		try {
			while(distanciaAtual < distanciaMax) {
				pulo = (int) (Math.random() * (puloMax + 1));
				distanciaAtual += pulo;
				System.out.println("Sapo #" + numSapo + ": " + distanciaAtual);
				
				sleep(1000);
			}
			
			colocacao = posicao.getAndIncrement();
			System.out.println("Sapo #" + numSapo + " chegou em " + colocacao + "º lugar");
			
		} catch (Exception e) {
			
		}
		

	}

}
