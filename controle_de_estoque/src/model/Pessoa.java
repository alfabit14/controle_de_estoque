package model;

public class Pessoa {
    protected String nome;
    protected String cfp;
    protected String telefone;

    public Pessoa(String nome, String cfp, String telefone) {
        this.nome = nome;
        this.cfp = cfp;
        this.telefone = telefone;
    }

    public Pessoa() {

    }

    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", cfp='" + cfp + '\'' +
                ", telefone='" + telefone + '\'' ;
    }
}
