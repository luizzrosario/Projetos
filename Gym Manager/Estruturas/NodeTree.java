package Projeto.Estruturas;

// Nó de uma arvore
public class NodeTree<T> {
    // Conteúdo
    T data;
    NodeTree<T> father;
    NodeTree<T> left;
    NodeTree<T> right;

    // Construtor
    public NodeTree() {
        this.data = null;
        this.father = null;
        this.left = null;
        this.right = null;
    }

    // Getters
    public NodeTree<T> getLeft() {
        return left;
    }

    public NodeTree<T> getRight() {
        return right;
    }

    public NodeTree<T> getFather() {
        return father;
    }

    public T getData() {
        return data;
    }

    // Setters
    public void setLeft(NodeTree<T> left) {
        this.left = left;
    }

    public void setRight(NodeTree<T> right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }
}
