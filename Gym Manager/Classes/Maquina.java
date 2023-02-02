package Projeto.Classes;

import java.io.Serializable;

// Classe Maquina comparável
public class Maquina implements Comparable<Maquina>, Serializable {
    // Atributos
    private String nome;
    private int id;
    private String tipo;
    private static int contagem = 0;

    // Construtores
    public Maquina(String nome, String tipo) {
        contagem++;
        this.nome = nome;
        this.id = contagem;
        this.tipo = tipo;
    }

    public Maquina(String nome, int id, String tipo) {
        this.nome = nome;
        this.id = id;
        this.tipo = tipo;
    }

    public Maquina(Maquina m) {
        this.nome = m.getNome();
        this.id = contagem;
        this.tipo = m.getTipo();
        contagem++;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    // Compare maquina
    public int compareTo(Maquina maquina) {
        if (maquina.getId() == this.id) {
            return 0;
        } else if (maquina.getId() > this.id) {
            return -1;
        } else {
            return 1;
        }
    }

    // toString maquina
    public String toString() {
        return this.id + " - " + this.nome + " - " + this.tipo;
    }
}
