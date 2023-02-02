package Projeto.Classes;

import java.io.Serializable;

// Classe comparável exercício
public class Exercicio implements Comparable<Exercicio>, Serializable {
    // Atributos
    private String nomeExercicio;
    private int sets;
    private int reps;
    private double peso;
    private Maquina maquina;

    // Construtores
    public Exercicio(Maquina maquina, String nomeExercicio, int sets, int reps, double peso) {
        this.maquina = maquina;
        this.nomeExercicio = nomeExercicio;
        this.sets = sets;
        this.reps = reps;
        this.peso = peso;
    }

    public Exercicio(String nome, String tipo, String nomeExercicio, int sets, int reps, double peso) {
        this.maquina = new Maquina(nome, tipo);
        this.nomeExercicio = nomeExercicio;
        this.sets = sets;
        this.reps = reps;
        this.peso = peso;
    }

    // Getters
    public String getNomeExercicio() {
        return this.nomeExercicio;
    }

    public int getSets() {
        return this.sets;
    }

    public int getReps() {
        return this.reps;
    }

    public double getPeso() {
        return this.peso;
    }

    public Maquina getMaquina() {
        return this.maquina;
    }

    // Compare exercício
    @Override
    public int compareTo(Exercicio ex) {
        return this.maquina.compareTo(ex.getMaquina());
    }

    // toString exercício
    @Override
    public String toString() {
        return maquina.toString() + " | " + this.nomeExercicio + " | Sets: " + this.sets + " - Reps: " + this.reps
                + " - Peso (kg): " + this.peso;
    }
}
