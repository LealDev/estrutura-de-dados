package lista;

import java.util.Scanner;

public class Exercicio6 {
	/*
	 * 6 - Escreva um programa que, usando métodos, 
	 * preencha uma lista da classe LdeItem, 
	 * calcula a média dos valores da lista e 
	 * imprime tudo na tela. 
	 * 
	 * Observação: você deve fazer um método para preencher, 
	 * outro para calcular a média e outro para imprimir.
	 */
	public static void main(String[] args) {
		LdeItem lista = new LdeItem();
		double media;
		
		inserir(lista);
		media = calcMedia(lista);
		System.out.println("LISTA ORIGINAL");
		System.out.println(lista.toString());
		System.out.println("MEDIA = " + media);

	}

	private static double calcMedia(LdeItem lista) {
		double total = 0;
		
		for (int i = 0; i < lista.getQuant(); i++) {
			total += lista.getNo(i).getItem().getChave();
		}
		
		if (lista.getQuant() == 0) {
			return 0;
		} else {
			return (total / lista.getQuant());
		}
	}

	private static void inserir(LdeItem lista) {
		int valor;
		Item item;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite um valor inteiro ou zero para terminar:");
		valor = scanner.nextInt();
		while (valor != 0) {
			item = new Item(valor);
			lista.insereInicio(item);
			System.out.println("Digite um valor inteiro ou zero para terminar:");
			valor = scanner.nextInt();
		}
		
		scanner.close();
	}
}
