package br.com.waldson.aula12;

public class Pessoa{
    private String nome;
    private int idade;


    public Pessoa(String nome, int idade) {
        this.nome  = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade,  FilaBanco fila) {
        this.idade = idade;
        fila.manutencaoPrioriade(0);
    }

    public String getPesoa(){
        return this.nome + " - " + this.idade;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.idade;
    }
}
