package it.polito.tdp.bar.model;

public class Statistiche {

	protected int totaleClienti;
	protected int clientiSoddisfatti;
	protected int clientiInsoddisfatti;
	
	
	
	public Statistiche() {
		super();
		totaleClienti=0;
		clientiSoddisfatti=0;
		clientiInsoddisfatti=0;
	}

	public int getTotaleClienti() {
		return totaleClienti;
	}
	
	public int getClientiSoddisfatti() {
		return clientiSoddisfatti;
	}
	
	public int getClientiInsoddisfatti() {
		return clientiInsoddisfatti;
	}
	
	public void aggiungiClientiSoddisfatti(int n){
		clientiSoddisfatti+=n;
		totaleClienti+=n;
	}
	
	public void aggiungiClientiInsoddisfatti(int n){
		clientiInsoddisfatti+=n;
		totaleClienti+=n;
	}

	@Override
	public String toString() {
		return "Statistiche Bar: \nTotaleClienti = " + totaleClienti + "\nclientiSoddisfatti = " + clientiSoddisfatti
				+ "\nclientiInsoddisfatti = " + clientiInsoddisfatti ;
	}
	
	
	
	
}
