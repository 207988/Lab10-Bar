package it.polito.tdp.bar.model;

public class Gruppo {
	protected int id;	
	protected int numPersone;
	protected int durata;
	protected float tolleranza;
	
	public Gruppo(int id, int numPersone, int durata, float tolleranza) {
		super();
		this.id = id;		
		this.numPersone = numPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}

	public int getId() {
		return id;
	}

	public int getNumPersone() {
		return numPersone;
	}

	public int getDurata() {
		return durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gruppo other = (Gruppo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gruppo [id=" + id + ", numPersone=" + numPersone + ", durata=" + durata + ", tolleranza=" + tolleranza
				+ "]";
	}

	
	
	
	
}
