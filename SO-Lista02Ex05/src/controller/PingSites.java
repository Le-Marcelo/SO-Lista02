package controller;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PingSites extends Thread{

	int idSite;
	
	public PingSites(int _idSite) {
		idSite = _idSite;
	}
	
	
	@Override
	public void run() {
		String nomeOs = System.getProperty("os.name");
		String url = "", nomeSite = "";
		
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
			
			try { 
				//Receber a saída do processo e alocar em um buffer para leitura
				Process processo = Runtime.getRuntime().exec("ping -4 -c 10 " + url);
				InputStream fluxoDados = processo.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxoDados);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					
					if(linha.contains("time=")) {
						
						String[] splitLinha = linha.split("time=");
						String tempo = splitLinha[1];
						System.out.println(nomeSite + ": " + tempo);
						
					}else if (linha.contains("avg")) {
						
						String[] splitLinha = linha.split("/");
						String tempo = splitLinha[4];
						System.out.println(nomeSite + " - Tempo médio: " + tempo);
						
					}
					
					linha = buffer.readLine();
				}
				
				
				
				//Fechamento dos buffers
				buffer.close();
				leitor.close();
				fluxoDados.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.err.println("Sistema Operacional inválido, use em uma distribuição Linux");
		}
	}

}
