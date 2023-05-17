package lista;

import lista.Item;

public class LdeItem {
	private NoDuploItem prim, ult;
	private int quant;
	
	public LdeItem () {
		this.prim = null;
		this.ult = null;
		this.quant=0;
	}

	public int getQuant() {
		return quant;
	}

	public NoDuploItem getPrim() {
		return prim;
	}

	public void setPrim(NoDuploItem prim) {
		this.prim = prim;
	}

	public NoDuploItem getUlt() {
		return ult;
	}

	public void setUlt(NoDuploItem ult) {
		this.ult = ult;
	}
	
	public boolean eVazio () {
		if (this.quant == 0) {
			return true;
		}
		return false;
	}
	
	public void insereInicio (Item item) {
		NoDuploItem novoNo = new NoDuploItem(item);
		
		if (this.eVazio()) {
			this.ult = novoNo;
		}else {
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
		}
		this.prim = novoNo;
		this.quant++;
	}
	
	public void insereUltimo (Item item) {
		NoDuploItem novoNo = new NoDuploItem(item);
		
		if (this.eVazio()) {
			this.prim = novoNo;
		}else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quant++;
	}
	
	public NoDuploItem pesquisa (int num) {
		NoDuploItem aux = this.prim;
		
		while (aux != null) {
			if (aux.getItem().getChave() == num) {
				return aux;
			}
			aux = aux.getProx();
		}
		return aux;
	}
	
	public NoDuploItem remove (int num) {
		NoDuploItem aux = null;
		if (eVazio()) {
			return null;
		}
		if (this.quant == 1) {
			aux = this.prim;
			this.prim = this.prim.getProx();
			this.ult = this.ult.getAnt();
		}else if (this.prim.getItem().getChave()==num) {
			aux = this.prim;
			this.prim = this.prim.getProx();
			this.prim.setAnt(null);
			
		}else if (this.ult.getItem().getChave()==num) {
			aux = this.ult;
			this.ult = this.ult.getAnt();
			this.ult.setProx(null);
		}else {
			aux = pesquisa(num);
			if (aux==null) {
				return null;
			}else {
				NoDuploItem aux2 = aux.getAnt();
				aux2.setProx(aux.getProx());
				aux2 = aux.getProx();
				aux2.setAnt(aux.getAnt());
			}
		}
		this.quant--;
		return aux;
	}
	
	public String toString () {
		String temp="";
		NoDuploItem aux= this.prim;

		while (aux!=null) {
			temp += aux.getItem().getChave()+"  ";
			aux = aux.getProx();
		}
		return temp;
	}
	
	public String toStringInvertido () {
		String temp="";
		NoDuploItem aux= this.ult;

		while (aux!=null) {
			temp += aux.getItem().getChave()+"  ";
			aux = aux.getAnt();
		}
		return temp;
	}
	public NoDuploItem getNo (int pos) {
		NoDuploItem aux = this.prim;
		
		if (pos>=quant || pos<0) {
			return null;
		}
		// andar na lista ate a posicao pos
		for (int i=0; i<pos; i++) {
			aux = aux.getProx();
		}
		return aux;
	}

}
