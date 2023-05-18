package com.emanuel.estruturaDeDados.teste;

import java.util.Scanner;

import javafx.scene.media.Media;
import lista.Item;
import lista.LdeItem;
import lista.NoDuploItem;

public class Program {

	public static void main(String[] args) {
		
			/*
	 * 6 - Escreva um programa que, usando métodos, 
	 * preencha uma lista da classe LdeItem, 
	 * calcula a média dos valores da lista e 
	 * imprime tudo na tela. 
	 * 
	 * Observação: você deve fazer um método para preencher, 
	 * outro para calcular a média e outro para imprimir.
	 */

	 /*
	* 8 - Escreva um programa que, usando métodos, 
	* preencha uma lista da classe LdeItem, 
	* recebe um número inteiro e 
	* mostre se ele pertence à lista ou não
	*/
	Scanner scanner = new Scanner(System.in);

	LdeItem lista = new LdeItem();
	NoDuploItem item;
	int num;
	

		preenche(lista, scanner);
		System.out.println("Entre com um numero");
		num = scanner.nextInt();
		System.out.println(lista.toString());
		item = lista.pesquisa(num);
		if (item == null) {
			System.out.println(num + " NÃO ESTA NA LISTA");
		} else {
			System.out.println("o item nao esta na lista");
		}
		

	}

	private static void preenche(LdeItem lista, Scanner scanner) {
	int valor;
	
	System.out.println("Digite um valor inteiro ou 0 para sair");
	valor = scanner.nextInt();
		while (valor != 0) {
		Item elem = new Item(valor);
		lista.insereInicio(elem);
		System.out.println("Digite um valor inteiro ou 0 para sair");
		valor = scanner.nextInt();
		}

	}

	 
}
