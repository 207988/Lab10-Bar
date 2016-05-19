package it.polito.tdp.bar.simulazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import it.polito.tdp.bar.model.Gruppo;
import it.polito.tdp.bar.model.Statistiche;
import it.polito.tdp.bar.model.Tavolo;
import it.polito.tdp.bar.simulazione.Evento.TipoEvento;

public class Core {

	private Map<Integer,Gruppo>gruppi=new HashMap<Integer,Gruppo>();
	private Queue<Evento> listaEventi = new PriorityQueue<Evento>();
	private List<Tavolo> listaTavoli=new ArrayList<Tavolo>();
	private Statistiche stat=new Statistiche();
	
	public void aggiungiEvento(Evento e){
		listaEventi.add(e);
	}
	
	public void aggiungiGruppo(Evento e){
		gruppi.put(e.getG().getId(), e.getG());
		listaEventi.add(new Evento(TipoEvento.USCITA_GRUPPO_CLIENTI,e.getG(),e.getTempo()+e.getG().getDurata()));
	}
	
	public void aggiungiTavolo(Tavolo t){
		listaTavoli.add(t);
	}

	public Queue<Evento> getListaEventi() {
		return listaEventi;
	}
	public void passo(){
		//TODO
		
	}
	
	public String simula(){
		while(!listaEventi.isEmpty())
			this.passo();
		return stat.toString();
	}
}
