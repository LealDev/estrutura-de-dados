package lista;

public class NoPessoa {
    private NoPessoa prox;
    private Pessoa pessoa;

    public NoPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.prox = null;
    }

    public NoPessoa getProx() {
        return prox;
    }

    public void setProx(NoPessoa prox) {
        this.prox = prox;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
