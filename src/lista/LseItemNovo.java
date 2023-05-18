package lista;

public class LseItemNovo {
	private NoItem prim, ult;
	private int quant;
	
	public LseItemNovo () {
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
	
	// Exercicio 1
	public NoItem getNo (int pos) {
		NoItem aux = this.prim;
		
		if (pos>=quant || pos<0) {
			return null;
		}
		// andar na lista ate a posicao pos
		for (int i=0; i<pos; i++) {
			aux = aux.getProx();
		}
		return aux;
	}
	
	// Exercicio 2
	public boolean inserir (int valor, int pos) {
		NoItem ant, atual, novo;
		Item item = new Item(valor);
		int i;
		if (pos<0 || pos>this.quant) {
			return false;
		}
		if (pos ==0) {
			this.insereInicio(item);
		} else if (pos==this.quant) {
			this.insereUltimo(item);
		}else {
			// percorrer a lista até a posicao desejada
			atual = this.getPrim();
			ant = atual;
			// para chegar na posicao
			for (i=0; i!=pos; i++){
				ant = atual;
				atual = atual.getProx();
			}
			novo = new NoItem(item);
			ant.setProx(novo);
			novo.setProx(atual);
			this.quant++;
		}
		return true;
	}
	
	// Exercicio 03
	public boolean removerPosicao (int pos) {
		NoItem atual;
		if (pos<0 || pos>=this.getQuant()) {
			return false;
		}
		atual = getNo(pos);
		if (atual==null) {
			return false;
		}else {
			this.remove(atual.getItem().getChave());
			return true;
		}
	}

	// Exercicio 4
	public void divide (LseItemNovo l1, LseItemNovo l2) {
		int pos = l1.getQuant()/2;
		NoItem ant = l1.getNo(pos-1);
		NoItem atual = ant.getProx();
		l2.prim = atual;
		l2.ult = l1.getUlt();
		l2.quant = l1.quant-pos;
		l1.ult = ant;
		l1.ult.setProx(null);
		l1.quant = pos;
	}



}
