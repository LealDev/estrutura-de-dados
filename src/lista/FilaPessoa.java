package lista;

public class FilaPessoa {
    private NoPessoa head;
    private NoPessoa tail;
    private int quant;

    public FilaPessoa() {
        this.head = null;
        this.tail = null;
        this.quant = 0;
    }

    public boolean eVazia() {
        return quant == 0;
    }

    public int tamanho() {
        return quant;
    }

    public NoPessoa getHead() {
        return head;
    }

    public void enqueue(Pessoa pessoa) {
        NoPessoa novoNo = new NoPessoa(pessoa);
        if (eVazia()) {
            head = novoNo;
            tail = novoNo;
        } else {
            tail.setProx(novoNo);
            tail = novoNo;
        }
        quant++;
    }

    public Pessoa dequeue() {
        if (eVazia()) {
            return null;
        }
        NoPessoa aux = head;
        head = head.getProx();
        aux.setProx(null);
        quant--;
        if (head == null) {
            tail = null;
        }
        return aux.getPessoa();
    }
}
