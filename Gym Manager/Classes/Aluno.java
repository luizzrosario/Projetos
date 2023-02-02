package Projeto.Classes;

import java.io.Serializable;

// Classe aluno comparável
public class Aluno implements Comparable<Aluno>, Serializable {
    // Atributos do aluno
    private String nome;
    private String email;
    private int cpf;
    private int telefone;
    // Contagem de treinos totais
    private int contagemTreino = 0;
    // Vetor para armazenar os treinos (Max 7)
    private Treino[] treinos = new Treino[7];

    // Construtores
    public Aluno(String nome, int cpf, String email, int telefone) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Aluno(String nome, int cpf, String email) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = 0;
    }

    public Aluno(String nome, int cpf, int telefone) {
        this.nome = nome;
        this.email = "Sem email";
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Aluno(String nome, int cpf) {
        this.nome = nome;
        this.email = "Sem email";
        this.cpf = cpf;
        this.telefone = 0;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getCpf() {
        return cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public int getContagemTreino() {
        return contagemTreino;
    }

    public Treino[] getTreinos() {
        return treinos;
    }

    public String getNomeTreinos(int i) {
        return treinos[i].getNomeDoTreino();
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    // Adiciona um treino
    public void addTreino(Treino t) {
        treinos[contagemTreino] = t;
        contagemTreino++;
    }

    // Adiciona exercício em um treino
    public void addExercicioEm(Exercicio e, int t) {
        treinos[t].addExercicio(e);
    }

    // Printa todos os treinos
    public void printTreinos() {
        for (int i = 0; i < (contagemTreino); i++) {
            treinos[i].printTreino();
        }
    }

    // Printa um treino específico
    public void printTreino(int i) {
        treinos[i - 1].printTreino();
    }

    // Comparable do aluno
    @Override
    public int compareTo(Aluno a) {
        if (this.cpf == a.getCpf()) {
            return 0;
        } else if (this.cpf < a.getCpf()) {
            return -1;
        } else {
            return 1;
        }
    }

    // toString do aluno
    public String toString() {
        return "Nome: " + this.nome + " | CPF: " + this.cpf + " | Telefone: " + this.telefone + " | Email: "
                + this.email;
    }
}
