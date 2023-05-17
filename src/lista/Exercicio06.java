package lista;

import java.util.Scanner;

public class Exercicio06 {
	public static void main(String[] args) {
		LseItem lse = new LseItem();
		double media;

		inserir(lse);
		media = media(lse);
		System.out.println("Lista digitada");
		System.out.println(lse.toString());
		System.out.println("Media de seus elementos = " + media);

	}

	public static void inserir(LseItem lse) {
		int valor;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite um valor inteiro ou zero para terminar:");
		valor = scanner.nextInt();
		while (valor != 0) {
			Item elem = new Item(valor);
			lse.insereUltimo(elem);
			System.out.println("Digite um valor inteiro ou zero para terminar:");
			valor = scanner.nextInt();
		}

		scanner.close();
	}

	public static double media(LseItem lse) {
		NoItem aux = lse.getPrim();
		double total = 0;
		int quant = 0;

		while (aux != null) {
			total += aux.getItem().getChave();
			quant++;
			aux = aux.getProx();
		}
		if (quant == 0) {
			return 0;
		} else {
			return (total / quant);
		}
	}
}
