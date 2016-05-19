package it.polito.tdp.bar.simulazione;

import it.polito.tdp.bar.model.Gruppo;

public class Evento implements Comparable<Evento>{
	public enum TipoEvento {
		ARRIVO_GRUPPO_CLIENTI, USCITA_GRUPPO_CLIENTI
	}

	
	protected TipoEvento tipo;	
	protected long tempo;
	Gruppo g;
	public Evento(TipoEvento tipo, Gruppo g,long t) {
		super();
		this.tipo = tipo;
		this.tempo=t;
		this.g = g;
	}
	
	@Override
	public int compareTo(Evento arg0) {		
		return Long.compare(this.tempo, arg0.tempo);
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public long getTempo() {
		return tempo;
	}

	public Gruppo getG() {
		return g;
	}

	@Override
	public String toString() {
		return "Evento [tipo=" + tipo + ", tempo=" + tempo + ", g=" + g + "]";
	}
	
	
	
	
	
	
}
