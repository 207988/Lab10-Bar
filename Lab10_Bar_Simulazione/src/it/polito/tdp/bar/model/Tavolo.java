package it.polito.tdp.bar.model;

public class Tavolo {

	protected int dimensione;
	protected Gruppo g;
	
	public Tavolo(int dimensione) {
		super();
		this.dimensione = dimensione;
		this.g=null;
	}
	public Gruppo getG() {
		return g;
	}
	public void setG(Gruppo g) {
		this.g = g;
	}
	public int getDimensione() {
		return dimensione;
	}
	
}
