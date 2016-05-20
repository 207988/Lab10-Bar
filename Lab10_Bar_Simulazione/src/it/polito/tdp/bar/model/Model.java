package it.polito.tdp.bar.model;

import java.util.Random;

import it.polito.tdp.bar.simulazione.Core;
import it.polito.tdp.bar.simulazione.Evento;
import it.polito.tdp.bar.simulazione.Evento.TipoEvento;

public class Model {
	Core simulatore=new Core();

	public Core getSimulatore() {
		return simulatore;
	}
	
	public void load(){
		simulatore.clear();
		int id=0;
		long tempo=0;
		Random random=new Random();
		
		for(int i=0;i<=2000;i++){			
			Gruppo g=new Gruppo(id++,random.nextInt(10)+1,random.nextInt(61)+60,((float)random.nextInt(9)/10));
			tempo+=(random.nextInt(10)+1);
			Evento e=new Evento(TipoEvento.ARRIVO_GRUPPO_CLIENTI,g,tempo);
			simulatore.aggiungiEvento(e);
		}
		
		
		simulatore.aggiungiTavolo(new Tavolo(10));
		simulatore.aggiungiTavolo(new Tavolo(10));
		
		simulatore.aggiungiTavolo(new Tavolo(8));
		simulatore.aggiungiTavolo(new Tavolo(8));
		simulatore.aggiungiTavolo(new Tavolo(8));
		simulatore.aggiungiTavolo(new Tavolo(8));
		
		simulatore.aggiungiTavolo(new Tavolo(6));
		simulatore.aggiungiTavolo(new Tavolo(6));
		simulatore.aggiungiTavolo(new Tavolo(6));
		simulatore.aggiungiTavolo(new Tavolo(6));
		
		simulatore.aggiungiTavolo(new Tavolo(4));
		simulatore.aggiungiTavolo(new Tavolo(4));
		simulatore.aggiungiTavolo(new Tavolo(4));
		simulatore.aggiungiTavolo(new Tavolo(4));
		simulatore.aggiungiTavolo(new Tavolo(4));	
		
		
		
	}

	public String simula(){
		return simulatore.simula();
	}
}
