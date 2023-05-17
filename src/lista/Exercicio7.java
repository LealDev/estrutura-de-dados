package lista;
import java.util.Scanner;

/*
 * 8 - Escreva um programa que, usando métodos, 
 * preencha uma lista da classe LdeItem, 
 * recebe um número inteiro e 
 * mostre se ele pertence à lista ou não
 */
public class Exercicio7 {
	
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		LdeItem lista = new LdeItem();
		NoDuploItem item;
		int num;
		
		inserir(lista, scanner);
		System.out.println("Entre com um número");
		num = scanner.nextInt();
		System.out.println(lista.toString());
		item = lista.pesquisa(num);
		if (item == null) {
			System.out.println(num + " NAO ESTA NA LISTA");
		} else {
			System.out.println(num + " ESTA NA LISTA");
		}
	}
	
	public static void inserir(LdeItem lista, Scanner scanner) {
		int valor;
		System.out.println("Digite um valor inteiro ou zero para terminar:");
		valor = scanner.nextInt();
		while (valor != 0) {
			Item elem = new Item(valor);
			lista.insereUltimo(elem);
			System.out.println("Digite um valor inteiro ou zero para terminar:");
			valor = scanner.nextInt();
		}
	}
}
