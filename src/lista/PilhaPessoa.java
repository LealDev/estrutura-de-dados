package lista;

public class PilhaPessoa {
    private NoPessoa top;
    private int quant;

    public PilhaPessoa() {
        this.top = null;
        this.quant = 0;
    }

    public boolean eVazia() {
        return quant == 0;
    }

    public int tamanho() {
        return quant;
    }

    public NoPessoa getTop() {
        return top;
    }

    public void push(Pessoa pessoa) {
        NoPessoa novoNo = new NoPessoa(pessoa);
        novoNo.setProx(top);
        top = novoNo;
        quant++;
    }

    public Pessoa pop() {
        if (eVazia()) {
            return null;
        }
        NoPessoa aux = top;
        top = top.getProx();
        aux.setProx(null);
        quant--;
        return aux.getPessoa();
    }
}
