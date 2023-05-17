package lista;

import lista.Item;
public class NoDuploItem {
	private NoDuploItem prox, ant;
	private Item item;
	
	public NoDuploItem(Item item) {
		this.item = item;
		this.prox = null;
		this.ant = null;
	}

	public NoDuploItem getProx() {
		return prox;
	}

	public void setProx(NoDuploItem prox) {
		this.prox = prox;
	}

	public NoDuploItem getAnt() {
		return ant;
	}

	public void setAnt(NoDuploItem ant) {
		this.ant = ant;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public String toString ()
	{
		return (item.toString());
	}
	

}
