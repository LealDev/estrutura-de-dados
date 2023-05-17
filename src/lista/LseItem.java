package lista;

public class LseItem {
	private NoItem prim, ult;
	private int quant;
	
	public LseItem () {
		this.prim = null;
		this.ult = null;
		this.quant = 0;
	}

	public NoItem getPrim() {
		return prim;
	}

	public void setPrim(NoItem prim) {
		this.prim = prim;
	}

	public NoItem getUlt() {
		return ult;
	}

	public void setUlt(NoItem ult) {
		this.ult = ult;
	}

	public int getQuant() {// retorna o tamanho da lista
		return quant;
	}
	
	public boolean eVazio() {
		if (quant==0) {
			return true;
		}
		return false;
	}
	
	public void insereInicio (Item elem) {
		NoItem novo = new NoItem(elem);
		if (eVazio()) {
			this.ult = novo;
		}else {
			novo.setProx(this.prim);
		}
		this.prim = novo;
		this.quant++;
	}
	
	public void insereUltimo (Item elem) {
		NoItem novoNo = new NoItem(elem);
		if (this.eVazio()) {
			this.prim = novoNo;
		}else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quant++;
	}
	
	public NoItem pesquisa (int num) {
		NoItem aux = this.prim;
		
		while (aux!=null) {
			if (aux.getItem().getChave()==num) {
				return aux;
			}
			aux = aux.getProx(); // vai para o proximo
		}
		return null;
	}
	
	public NoItem remove (int num) {
		NoItem atual, ant;
		if (eVazio()) {
			return null;
		}
		if (quant==1) {
			if (num==this.prim.getItem().getChave()) {
				atual = this.prim;
				this.prim = null;
				this.ult = null;
				quant--;
				return atual;
			} else {
				return null;
			}
		} else {
			atual = this.prim;
			ant = this.prim;
			if (this.prim.getItem().getChave()==num) {
				this.prim = this.prim.getProx();
				quant--;
				return atual;
			}
			while (atual!=null) {
				if (atual.getItem().getChave()==num) {
					ant.setProx(atual.getProx());
					quant--;
					return atual;
				}
				ant = atual;
				atual = atual.getProx();
			}
			return null;
		}
	}
	
	public String toString () {
		String temp="";
		NoItem aux= this.prim;

		while (aux!=null) {
			temp += aux.getItem().getChave()+"  ";
			aux = aux.getProx();
		}
		return temp;
	}
	public NoItem getNo (int pos) {
		NoItem aux;  
		
		if (pos>=quant || pos<0) {
			return null;
		}
		// andar na lista ate a posicao pos
		aux = this.prim;
		for (int i=0; i<pos; i++) {
			aux = aux.getProx();
		}
		return aux;
	}
	
}
