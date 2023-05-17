package com.emanuel.estruturaDeDados.classes;

import java.util.Iterator;

public class Vetor {

	private String[] elementos;
	private int tamanho;
	
	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}

	/*
	 	public void adiciona(String elemento) {
		for (int i = 0; i < elementos.length; i++) {
			if (elementos[i]==null) {
				elementos[i] = elemento;
				break;
			}
			
		}
	}
	 */
	
	
	/*public void adiciona(String elemento) throws Exception {
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;	
		}else {
			throw new Exception("O vetor esta cheio, não foi possivel adicionar um novo vetor");
		}
		
	}*/
	
	public boolean adiciona(String elemento) {
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;	
			return true;
		}
		return false;
	}
}
