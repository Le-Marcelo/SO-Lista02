package controller;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class PingSites extends Thread{

	int idSite;
	
	public PingSites(int _idSite) {
		idSite = _idSite;
	}
	
	
	@Override
	public void run() {
		String nomeOs = System.getProperty("os.name");
		String url, nomeSite;
		
		if(nomeOs.contains("Linux")){
			
			switch(idSite) {
				case 1:
					url = "www.uol.com.br";
					nomeSite = "UOL";
					break;
				
				case 2:
					url = "www.terra.com.br";
					nomeSite = "Terra";
					break;
				
				case 3:
					url = "www.google.com.br";
					nomeSite = "Google";
					break;
			}
			
			try {	//TODO : Parte imcompleta 
				//Receber a saída do processo e alocar em um buffer para leitura
				Process processo = Runtime.getRuntime().exec("ping -4 -n 10 " + url);
				InputStream fluxoDados = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxoDados);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				StringBuffer saidaBuffer = new StringBuffer();
				
				while (linha != null) {
					
					if(linha.contains(indicadorMedia)) {
						
						String[] splitLinha = linha.split(separadorMedia);
						int tempo = (int) Double.parseDouble(splitLinha[numSplitMedia]);
						saidaBuffer.append("Tempo médio:" + tempo + fimTexto);
						
					}
					
					linha = buffer.readLine();
				}
				
				//Fechamento dos buffers
				buffer.close();
				leitor.close();
				fluxoDados.close();
				
				JOptionPane.showMessageDialog(null, saidaBuffer.toString());
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.err.println("Sistema Operacional inválido, use em uma distribuição Linux");
		}
	}

}
