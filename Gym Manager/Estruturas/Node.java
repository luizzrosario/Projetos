package Projeto.Estruturas;

import java.io.Serializable;

// Nó genérico
public class Node<T> implements Serializable {
    public T data; // T é o dado genérico no nó
    public Node<T> next;
    public Node<T> prev;

    // Construtor
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Getters
    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrev() {
        return this.prev;
    }
}
