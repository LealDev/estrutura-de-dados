package lista;

public class ExercicioAvaliativo {
    public static void main(String[] args) {
        exercicio1();
        exercicio2();
        exercicio3();
        exercicio4();
    }

    public static void exercicio1() {
        LdeItem l1 = new LdeItem();
        LdeItem l2 = new LdeItem();

        // Preencha as listas l1 e l2 com os elementos do exemplo
        l1.insereUltimo(new Item(4));
        l1.insereUltimo(new Item(7));
        l1.insereUltimo(new Item(12));
        l1.insereUltimo(new Item(10));
        l1.insereUltimo(new Item(2));
        l1.insereUltimo(new Item(5));

        l2.insereUltimo(new Item(1));
        l2.insereUltimo(new Item(2));
        l2.insereUltimo(new Item(3));
        l2.insereUltimo(new Item(4));
        l2.insereUltimo(new Item(2));
        l2.insereUltimo(new Item(5));

        LdeItem l3 = obterElementosComuns(l1, l2);
        System.out.println("Elementos comuns às duas listas: " + l3.toString());
    }

    public static LdeItem obterElementosComuns(LdeItem l1, LdeItem l2) {
        LdeItem l3 = new LdeItem();

        NoDuploItem aux = l1.getPrim();
        while (aux != null) {
            if (l2.pesquisa(aux.getItem().getChave()) != null) {
                l3.insereUltimo(new Item(aux.getItem().getChave()));
            }
            aux = aux.getProx();
        }

        return l3;
    }

    public static void exercicio2() {
        // Crie as pessoas usando a classe Pessoa
        Pessoa pessoa1 = new Pessoa("João", "123456789", "987654321");
        Pessoa pessoa2 = new Pessoa("Maria", "987654321", "123456789");

        // Crie os nós de pessoa usando a classe NoPessoa
        NoPessoa noPessoa1 = new NoPessoa(pessoa1);
        NoPessoa noPessoa2 = new NoPessoa(pessoa2);

        // Imprima as informações das pessoas
        System.out.println("Pessoa 1: " + noPessoa1.getPessoa().toString());
        System.out.println("Pessoa 2: " + noPessoa2.getPessoa().toString());
    }

    public static void exercicio3() {
        PilhaPessoa pilha = new PilhaPessoa();

        // Empilhe algumas pessoas na pilha
        pilha.push(new Pessoa("João", "123456789", "987654321"));
        pilha.push(new Pessoa("Maria", "987654321", "123456789"));
        pilha.push(new Pessoa("Pedro", "456789123", "321654987"));

        // Desempilhe uma pessoa da pilha
        Pessoa pessoa = pilha.pop();
        if (pessoa != null) {
            System.out.println("Pessoa desempilhada: " + pessoa.toString());
        }
    }

    public static void exercicio4() {
        FilaPessoa fila = new FilaPessoa();

        // Enfileire algumas pessoas na fila
        fila.enqueue(new Pessoa("João", "123456789", "987654321"));
        fila.enqueue(new Pessoa("Maria", "987654321", "123456789"));
        fila.enqueue(new Pessoa("Pedro", "456789123", "321654987"));

        // Desenfileire uma pessoa da fila
        Pessoa pessoa = fila.dequeue();
        if (pessoa != null) {
            System.out.println("Pessoa desenfileirada: " + pessoa.toString());
        }
    }
}
