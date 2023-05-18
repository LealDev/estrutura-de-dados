package lista;

public class LCInteiro {
	/**
	 * Deve possuir os seguintes atributos: 
	 * lista (array de inteiros) 
	 * quant (int - quantidade de elementos da lista). 
	 */
	private int[] lista;
	private int quant;
	
	public LCInteiro(int tamanho) {
		this.lista = new int[tamanho];
		this.quant = 0;
	}
	/*
	 * getQuant() => retorna a quantidade de elementos da lista.
	 */
	public int getQuant () {
		return this.quant;
	}
	
	/*
	 * getNum (posição) => retorna o elemento que está na posição (parâmetro). 
	 * Caso a posição não seja válida, retorna null.
	 */
	public Integer getNum (int pos) {
		if (pos>=0 && pos<this.quant) {
			return (this.lista[pos]);
		}
		return null;
	}
	
	/*
	 * tamanho() => retorna o tamanho do vetor
	 */
	public int tamanho () {
		return this.lista.length;
	}
	
	/*
	 * eVazio() => retorna verdadeiro se a lista estiver vazia e 
	 * falso caso contrário.
	 */
	public boolean eVazio () {
		if (this.quant==0) {
			return true;
		}
		return false;
	}
	
	/*
	 * eCheio() => retorna verdadeiro se a lista estiver cheia e 
	 * falso caso contrário.
	 */
	public boolean eCheio () {
		if (this.quant==this.tamanho()) {
			return true;
		}
		return false;
	}
	
	/*
	 * pesquisa (num) => deve fazer uma pesquisa sequencial até 
	 * encontrar num, retornando sua posição. Se ele não existir, 
	 * deve retornar -1
	 */
	public int pesquisa (int num) {
		int pos=0;
		
		while (pos<this.getQuant()) {
			if (this.lista[pos] == num) {
				return pos;
			}
			pos++;
		}
		return -1;
	}
	
	 /*
	  * insereFim (num) => insere um número no final da lista e retorna 0. 
	  * Se ela estiver cheia, não deve inserir e deve retornar -1.
	  */
	public int insereFim (int num) {
		if (this.eCheio()) {
			return -1;
		}
		this.lista[this.getQuant()] = num;
		this.quant++;
		return 0;
	}
	
	/*
	 * insere (num, posicao) => insere um número em uma posição da lista, 
	 * deslocando todos os elementos que estiverem após essa posição para 
	 * o índice seguinte, retornando 0 (zero). Se a lista estiver cheia, 
	 * não deve inserir e deve retornar -1. Se a posição for inválida, 
	 * deve retornar -2.
	 */
	public int insere (int num, int pos) {
		if (this.eCheio()) {
			return -1;
		}
		if (pos<0 || pos>quant) {// posicao invalida
			return -2;
		}
		for (int i=quant-1; i>=pos; i--) {
			this.lista[i+1] = this.lista[i];
		}
		this.lista[pos] = num;
		this.quant++;
		return 0;
	}
	
	/*
	 * remove (num) => deve remover um elemento da lista. Se conseguir, 
	 * deve retornar true, se não conseguir, retorna false.
	 */
	public boolean remove (int num) {
		int pos = this.pesquisa(num);
		if (pos==-1) {
			return false;
		}
		this.lista[pos] = this.lista[this.quant-1];
		this.quant--;
		return true;
	}
	
	public String toString() {
		String temp="";
		for (int i=0; i<this.quant; i++) {
			temp += this.lista[i]+"   ";
		}
		return temp;
	}
}







