package it.polito.tdp.bar.simulazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

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
		Evento e=listaEventi.remove();		
		switch(e.getTipo()){
		case ARRIVO_GRUPPO_CLIENTI:
			this.aggiungiGruppo(e);
			int servizio=this.serviGruppo(e.getG());
			if(servizio==1||servizio==0)
				stat.aggiungiClientiSoddisfatti(e.getG().getNumPersone());
			else
				stat.aggiungiClientiInsoddisfatti(e.getG().getNumPersone());
			break;
		case USCITA_GRUPPO_CLIENTI:
			this.liberaTavolo(e.getG());
			break;
		default:
			break;
		
		}
		System.out.println(e.toString());
		
	}
	
	public String simula(){
		while(!listaEventi.isEmpty())
			this.passo();
		return stat.toString();
	}
	
	
	/**
	 * @param g Gruppo che cerca tavolo
	 * @return 
	 * 1 se trova tavolo
	 * 0 se soddisfatti bancone
	 *  -1 se insoddisfatti
	 */
	public int serviGruppo(Gruppo g){
		int d=g.getNumPersone();
		Random random=new Random();
		for(Tavolo t:listaTavoli){
			//provo a trovare un tavolo al gruppo
			if(t.getG()==null){
				if(d>=(t.getDimensione()/2)){
					t.setG(g);
					return 1;
				}
			}	
			
		}
		//provo a far accomodare al bancone il gruppo
		if(((float)random.nextInt(9)/10)<g.getTolleranza())
			return 0;
		else
			return -1;
	}
	
	public void liberaTavolo(Gruppo g){
		for(Tavolo t:listaTavoli){
			if(t.getG()!=null){
				if(t.getG()==g)
					t.setG(null);
			}
		}
	}
	
	public void clear(){
		gruppi.clear();
		listaEventi.clear();
		listaTavoli.clear();
		stat=new Statistiche();
	}
}
