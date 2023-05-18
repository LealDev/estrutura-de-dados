package lista;

public class LdeItemNovo {
	private NoDuploItem prim, ult;
	private int quant;
	
	public LdeItemNovo () {
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
	// Exercicio 1 - retornar o no da posicao pos
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

	// Exercicio 2 - inserir um no na posicao k
	public boolean inserir (int num, int pos) {
		Item item = new Item(num);
		if (pos==0) {
			insereInicio(item);
		}else if (pos==quant) {
			insereUltimo(item);
		}else {
			NoDuploItem atual = this.getNo(pos);
			if (atual == null) {
				return false;
			}
			NoDuploItem ant = atual.getAnt();
			NoDuploItem novoNo  = new NoDuploItem(item);
			ant.setProx(novoNo);
			novoNo.setAnt(ant);
			novoNo.setProx(atual);
			atual.setAnt(novoNo);
			this.quant++;
		}
		return true;
	}
	
	// Exercicio 3 - remover o no da posicao pos
	public NoDuploItem removePosicao (int pos) {
		NoDuploItem aux = this.getNo(pos);
		if (aux==null) {
			return null;
		}
		int valor = aux.getItem().getChave();
		return (this.remove(valor));
		
	}
	// Exercício 4
	public void concatena (LdeItemNovo l1) {
		l1.prim.setAnt(this.ult);
		this.ult.setProx(l1.prim);
		this.ult = l1.ult;
		this.quant += l1.quant;
	}
	
	// Exercicio 5
	public void divide (LdeItemNovo l1, LdeItemNovo l2) {
		int pos = quant/2;
		NoDuploItem meio = this.getNo(pos);
		NoDuploItem ant = meio.getAnt();
		l2.prim = meio;
		meio.setAnt(null);
		ant.setProx(null);
		l2.ult = l1.ult;
		l1.ult = ant;
		l2.quant = l1.quant-pos;
		l1.quant = pos;
	}
}
