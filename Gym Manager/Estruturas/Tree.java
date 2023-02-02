package Projeto.Estruturas;

// Arvore binária
public class Tree<T extends Comparable<T>> {
    private NodeTree<T> root;
    private int size;

    // Construtores
    public Tree() {
        root = null;
    }

    public Tree(T data) {
        insertTree(data);
    }

    // Pegar a raíz
    public NodeTree<T> getRoot() {
        return root;
    }

    // Retorna tamanho da arvore
    public int getSizeTree() {
        return this.size;
    }

    // Cria nó na arvore
    private NodeTree<T> createNode(NodeTree<T> node, T i) {
        node.data = i;
        node.father = null;
        node.left = null;
        node.right = null;
        size++;
        return node;
    }

    // Insere um ojeto na arvore
    public void insertTree(T i) {
        if (root == null) {
            NodeTree<T> newNode = new NodeTree<T>();
            newNode = createNode(newNode, i);
            root = newNode;
        } else {
            if (i.compareTo(root.data) == -1) {
                insertLeft(root, i);
            } else if (i.compareTo(root.data) == 1) {
                insertRight(root, i);
            }
        }
    }

    // Inserir a esquerda
    private void insertLeft(NodeTree<T> node, T i) {
        if (node.left == null) {
            NodeTree<T> newNode = new NodeTree<T>();
            newNode = createNode(newNode, i);
            newNode.data = i;
            node.left = newNode;
            newNode.father = node;
            return;
        } else {
            if (i.compareTo(node.left.data) == -1) {
                insertLeft(node.left, i);
            } else if (i.compareTo(node.left.data) == 1) {
                insertRight(node.left, i);
            }
        }
    }

    // Inserir a direita
    private void insertRight(NodeTree<T> node, T i) {
        if (node.right == null) {
            NodeTree<T> newNode = new NodeTree<T>();
            newNode = createNode(newNode, i);
            newNode.data = i;
            node.right = newNode;
            newNode.father = node;
            return;
        } else {
            if (i.compareTo(node.right.data) == 1) {
                insertRight(node.right, i);
            } else if (i.compareTo(node.right.data) == -1) {
                insertLeft(node.right, i);
            }
        }
    }

    // Imprime arvore
    public void printTreeAll() {
        printTree(root);
    }

    // Imprime os nós em ordem
    private void printTree(NodeTree<T> root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.data.toString());
            printTree(root.right);
        }
    }

    // Pega nó pego valor
    public T getNode(T value) {
        T temp = removeNode(value);
        insertTree(temp);
        return temp;
    }

    // Remove um nó específico
    public T removeNode(T value) {
        return removeNode(this.root, value).getData();
    }

    // Encontra nó
    private NodeTree<T> findNode(NodeTree<T> currentNode, T value) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.getData().equals(value)) {
            return currentNode;
        }

        NodeTree<T> nodeAux = new NodeTree<>();
        nodeAux = findNode(currentNode.getLeft(), value);

        if (nodeAux != null) {
            return nodeAux;
        }
        return findNode(currentNode.getRight(), value);
    }

    // Encontrar pelo ID (Comparable)
    public T findNodeID(T value) {
        return findNodeID(this.root, value).getData();
    }

    private NodeTree<T> findNodeID(NodeTree<T> currentNode, T value) {
        if (currentNode == null) {
            return null;
        } else if (currentNode.getData().compareTo(value) == 0) {
            return currentNode;
        } else if (currentNode.getData().compareTo(value) == 1) {
            return findNode(currentNode.left, value);
        } else {
            return findNode(currentNode.getRight(), value);
        }
    }

    // Se contém nele
    public boolean contains(NodeTree<T> currentNode, T value) {
        return !(findNode(currentNode, value) == null);
    }

    // Se é folha
    private boolean isLeaf(NodeTree<T> currentNode) {
        return (currentNode.getLeft() == null && currentNode.getRight() == null);
    }

    // Substituir valor
    private T valueSubstitute(NodeTree<T> currentNode) {
        if (currentNode.getRight() != null) {
            return (valueSubstitute(currentNode.getRight()));
        }
        return currentNode.getData();
    }

    // Se tem 2 filhos
    private boolean hasTwoChild(NodeTree<T> currentNode) {
        return (currentNode.getLeft() != null && currentNode.getRight() != null);
    }

    // Se tem 1 filho
    private boolean hasOneChild(NodeTree<T> currentNode) {
        return (currentNode.getLeft() != null || currentNode.getRight() != null);
    }

    // Remove nó a partir da raiz
    private NodeTree<T> removeNode(NodeTree<T> currentNode, T value) {
        if (contains(currentNode, value)) {
            if (currentNode.getData().compareTo(value) == 1) {
                currentNode.setLeft(removeNode(currentNode.getLeft(), value));
            } else if (currentNode.getData().compareTo(value) == -1) {
                currentNode.setRight(removeNode(currentNode.getRight(), value));
            } else {
                if (isLeaf(currentNode)) {
                    currentNode = null;
                    return currentNode;
                } else if (hasTwoChild(currentNode)) {
                    T substituteValue = valueSubstitute(currentNode.getLeft());
                    currentNode.setData(substituteValue);
                    currentNode.setLeft(removeNode(currentNode.getLeft(), substituteValue));
                } else if (hasOneChild(currentNode)) {
                    if (currentNode.getLeft() == null) {
                        return currentNode.getRight();
                    } else if (currentNode.getRight() == null) {
                        return currentNode.getLeft();
                    }
                }
            }
            return currentNode;
        }
        return null;
    }
}
