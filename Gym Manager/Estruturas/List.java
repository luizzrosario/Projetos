package Projeto.Estruturas;

import java.io.Serializable;

//Lista encadeada genérica implementando uma interface
public class List<T extends Comparable<T>> implements ListInterface<T>, Serializable {
    // Tamanho da lista
    private int size = 0;
    // Primeiro item
    private Node<T> head;
    // Último item
    private Node<T> tail;

    // Construtor
    public List() {
        this.head = null;
        this.tail = null;
    }

    // Pega tamanho da lista
    public int getSizeList() {
        return this.size;
    }

    // Seta um item como primeiro
    public void setFrontList(T data) {
        T d = data;
        d = data;
        insertFront(d);
    }

    // Seta um item como ultimo
    public void setRearList(T data) {
        T d = data;
        insertRear(d);
    }

    // Inserir em qualquer posição da lista
    public void setInPositionList(T data, int position) {
        T d = data;
        insertInPosition(d, position);
    }

    // Insere um item no começo da lista
    private void insertFront(T data) {
        Node<T> newNode = new Node<T>(data);

        // Caso lista vazia
        if (this.head == null) {
            head = newNode;
            tail = newNode;
            size++;
        }
        // Caso tenha item na lista
        else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
            size++;
        }
    }

    // Inserir em ultimo
    private void insertRear(T data) {
        Node<T> newNode = new Node<T>(data);

        // Caso lista vazia
        if (this.head == null) {
            head = newNode;
            tail = newNode;
            size++;
        }
        // Com item na lista
        else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // Inserir em uma posição específica
    private void insertInPosition(T data, int position) {
        // Se a posição estiver fora do tamanho da lista
        if ((position > this.size) || (position < 1)) {
            System.out.printf("\nPosição inválida!\n");
            return;
        }

        // Se for logo no primeiro slot
        if (position == 1) {
            insertFront(data);
            return;
        }
        // Se for no ultimo slot
        else if (position == size) {
            insertRear(data);
            return;
        }
        // Outra posição
        else {
            Node<T> newNode = new Node<T>(data);
            Node<T> aux = head;

            for (int i = 1; i < (position - 1); i++) {
                aux = aux.next;
            }

            newNode.next = aux.next;
            newNode.prev = aux;
            aux.next.prev = newNode;
            aux.next = newNode;
            size++;
        }
    }

    // Remove primeiro
    @Override
    public T removeFront() {
        // Se estiver vazia
        if (head == null) {
            System.out.println("Lista vazia!");
            System.exit(-1);
        }

        // T temporário
        T temp = head.data;

        // Só 1 na lista
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return temp;
        } else {
            Node<T> aux = head;
            head = aux.next;
            head.prev = tail;
            tail.next = head;
            aux = null;
            size--;
            return temp;
        }
    }

    // Remove ultimo
    @Override
    public T removeRear() {
        if (head == null) {
            System.out.println("Lista vazia!");
            System.exit(-1);
        }

        T temp = tail.data;

        // Se só tiver 1 na lista
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return temp;
        } else {
            Node<T> aux = tail;

            tail = aux.prev;
            tail.next = head;
            head.prev = tail;
            aux = null;
            size--;
            return temp;
        }
    }

    // Remove item na posição dita
    @Override
    public T removeInPosition(int position) {
        if (head == null) {
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        if ((position > size) || (position < 1)) {
            System.out.printf("Error is removeInPosition, ivalid position!!\n");
            System.exit(-1);
        }

        if (position == 1) {
            return removeFront();
        } else if (position == size) {
            return removeRear();
        } else {
            Node<T> aux = head;

            for (int i = 1; i < position; i++) {
                aux = aux.next;
            }
            T temp = aux.data;

            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            aux = null;
            --size;
            return temp;
        }
    }

    // Remove um item específico
    @Override
    public T removeItem(T d) {
        Node<T> item = findNode(head, d);

        if ((getSizeList() == 1) || item == head) {
            return removeFront();
        } else if (item == tail) {
            return removeRear();
        } else {
            T temp = item.data;
            item.prev.next = item.next;
            item.next.prev = item.prev;
            item = null;
            size--;
            return temp;
        }
    }

    public T findNode(T d) {
        return findNode(head, d).data;
    }

    // Procura nó na lista (recursivo)
    private Node<T> findNode(Node<T> node, T d) {
        if (node.data.compareTo(d) == 0) {
            return node;
        }
        if (node == this.tail) {
            System.out.println("Não foi encontrado!");
            System.exit(-1);
        }

        return findNode(node.next, d);
    }

    // Imprime nó
    private void printNode(Node<T> h1, Node<T> h2) {
        if (h1.next == h2) {
            System.out.println(h1.data.toString());
            return;
        }
        System.out.println(h1.data.toString());
        printNode(h1.next, h2);
    }

    // Imprime lista
    public void printList() {
        if (head == null) {
            System.out.println("Lista vazia!");
            System.exit(-1);
        }
        printNode(this.head, this.head);
    }
}
