package Projeto.Classes;

import java.util.Scanner;

import Projeto.Estruturas.List;
import Projeto.Estruturas.Tree;

// Classe Academia
public class Academia {
    // Atributos basicos
    private String nome;
    List<Aluno> alunos;
    Tree<Maquina> maquinas;

    // Construtores
    public Academia(String nome) {
        this.alunos = new List<Aluno>();
        this.maquinas = new Tree<Maquina>();
        this.nome = nome;
    }

    public Academia() {
        this.alunos = new List<Aluno>();
        this.maquinas = new Tree<Maquina>();
        this.nome = "Sem nome";
    }

    // Muda o Nome da academia
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Adiciona o aluno
    public void addAluno(Aluno a) {
        alunos.setRearList(a);
    }

    // Sobrecarga de addAluno
    public void addAluno(String nome, int cpf, String email, int telefone) {
        Aluno a = new Aluno(nome, cpf, email, telefone);
        alunos.setRearList(a);
    }

    // Adiciona maquina
    public void addMaquina(Maquina m) {
        maquinas.insertTree(m);
    }

    // Sobrecarga de addMaquina
    public void addMaquina(String nome, String tipo) {
        Maquina m = new Maquina(nome, tipo);
        maquinas.insertTree(m);
    }

    // Printa todos os alunos
    public void printAlunos() {
        alunos.printList();
    }

    // Printa todas as maquinas
    public void printMaquinas() {
        maquinas.printTreeAll();
    }

    // Remove aluno
    public void removeAluno(Aluno a) {
        alunos.removeItem(a);
    }

    // Remove aluno por CPF
    public void removeAluno(int cpf) {
        alunos.removeItem(getAluno(cpf));
    }

    // Remove maquina
    public void removeMaquina(Maquina m) {
        maquinas.removeNode(m);
    }

    // Pega aluno usando CPF
    public Aluno getAluno(int cpf) {
        Aluno a = new Aluno("temp", cpf);
        return alunos.findNode(a);
    }

    // Pega maquina usando ID
    public Maquina getMaquina(int id) {
        Maquina m = new Maquina("temp", id, "");
        return maquinas.findNodeID(m);
    }

    // Printa treinos pelo CPF do aluno
    public void printTreinos(int cpf) {
        getAluno(cpf).printTreinos();
    }

    // Printa treino específico por CPF do aluno
    public void printTreino(int cpf, int treino) {
        getAluno(cpf).printTreino(treino);
    }

    // toString para informações básicas da academia
    public String toString() {
        return "@===" + this.nome.toUpperCase() + "===@" + "\nAlunos incritos: " + alunos.getSizeList()
                + "\nQuantia de máquinas: " + maquinas.getSizeTree();
    }

    // MENU E AÇÕES DE MENU
    public int menu() throws Exception {
        // Textinho
        System.out.println("\nSeja Bem-Vindo(a) a academia " + this.nome.toUpperCase() + "!!\n");
        System.out.println("Digite o que deseja fazer:\n");
        System.out.println("1 - Menu aluno");
        System.out.println("2 - Menu academia");
        System.out.println("3 - Matricular-se");
        System.out.println();

        Scanner input = new Scanner(System.in); // Scanner do swich case
        int escolha = input.nextInt();

        // Menu principal
        switch (escolha) {
            case 1:
                menuAluno(); // Função pro menu aluno
                return 1;

            case 2:
                menuAcademia(); // Função pro menu academia
                return 1;

            case 3:
                // Matricula
                System.out.println("Seja Bem-Vindo(a) futuro(a) monstro(a)!!!\n");
                System.out.println("Digite seu nome:");
                Scanner matriculaScanner = new Scanner(System.in);
                System.out.flush();
                String nome = matriculaScanner.nextLine();
                System.out.println("Seu CPF:");
                int cpf = matriculaScanner.nextInt();
                System.out.println("Seu E-mail:");
                System.out.flush();
                String email = matriculaScanner.nextLine();
                System.out.println("Seu Telefone:");
                int telefone = matriculaScanner.nextInt();
                addAluno(nome, cpf, email, telefone); // Insere o aluno
                return 1;
            default:
                System.out.println("\nOpção inválida!\n");
                return 1;
        }
    }

    // Menu aluno
    public void menuAluno() {
        System.out.println("\nPrimeiro, digite seu CPF:\n");
        Scanner cpfScanner = new Scanner(System.in); // Scanner para o CPF
        int cpfAluno = cpfScanner.nextInt();

        // Textinho
        System.out.println("\nMenu Aluno:\n");
        System.out.println("Olá, " + getAluno(cpfAluno).getNome());
        System.out.println("1 - Imprimir treino específico");
        System.out.println("2 - Imprimir treinos");
        System.out.println("3 - Adicionar exercício a um treino");
        System.out.println();

        // Scanner switch case
        Scanner std = new Scanner(System.in);
        int escolha1 = std.nextInt();
        switch (escolha1) {
            case 1:
                // Printar os nomes dos treinos e índice
                for (int i = 0; i < (getAluno(cpfAluno).getContagemTreino()); i++) {
                    System.out.println((i + 1) + " - " + getAluno(cpfAluno).getNomeTreinos(i));
                }
                System.out.println("Digite qual treino deseja imprimir: (Numero)");
                Scanner alunoInfo = new Scanner(System.in);
                int id = alunoInfo.nextInt();
                printTreino(cpfAluno, id);
                break;

            case 2:
                System.out.println("Seus Treinos:\n");
                printTreinos(cpfAluno);
                break;

            case 3:
                printTreinos(cpfAluno); // Printa todos os treinos do aluno
                // Pega todos os dados pro exercício
                System.out.println("\nDeseja acrescentar em qual treino?\n");
                int idTreino = std.nextInt();
                System.out.println("Qual defina seu exercício:");
                System.out.println("Máquinas:");
                maquinas.printTreeAll();
                System.out.println("Nome da maquina:");
                System.out.flush();
                String nomeMaq = std.nextLine();
                System.out.println("Tipo da maquina:");
                System.out.flush();
                String tipo = std.nextLine();
                System.out.println("Nome do exercicio:");
                System.out.flush();
                String nomeEx = std.nextLine();
                System.out.println("Sets:");
                int sets = std.nextInt();
                System.out.println("Reps:");
                int reps = std.nextInt();
                System.out.println("Peso:");
                int peso = std.nextInt();
                Exercicio e = new Exercicio(nomeMaq, tipo, nomeEx, sets, reps, peso);
                getAluno(cpfAluno).addExercicioEm(e, idTreino);
                break;

            default:
                System.out.println("\nOpção inválida!\n");
                break;
        }
    }

    // Menu academia
    public void menuAcademia() {
        // Textos
        System.out.println("\nMenu Academia\n");
        System.out.println("1 - Imprimir todos os alunos");
        System.out.println("2 - Imprimir todas as máquinas");
        System.out.println("3 - Remover aluno");
        System.out.println("4 - Remover máquina");
        System.out.println("5 - Adicionar máquina");
        System.out.println();

        // Scanner switch case
        Scanner input2 = new Scanner(System.in);
        int escolha2 = input2.nextInt();
        switch (escolha2) {
            case 1:
                // Printa todos os alunos
                System.out.println("Alunos da academia");
                printAlunos();
                break;
            case 2:
                // Printa todas as maquinas
                System.out.println("Máquinas da academia:");
                printMaquinas();
                break;
            case 3:
                // Remove aluno pelo CPF
                Scanner cpfScanner = new Scanner(System.in);
                int cpf = cpfScanner.nextInt();
                removeAluno(cpf);
                break;
            case 4:
                // Remove máquina
                System.out.println("Deseja remover qual máquina?");
                maquinas.printTreeAll();
                System.out.println("Nome da maquina:");
                System.out.flush();
                Scanner maqScanner = new Scanner(System.in);
                String nomeMaq = maqScanner.nextLine();
                System.out.println("Tipo da maquina:");
                System.out.flush();
                String tipo = maqScanner.nextLine();
                Maquina m = new Maquina(nomeMaq, tipo);
                removeMaquina(m);
                break;
            case 5:
                // Adiciona nova máquina
                Scanner maqScanner2 = new Scanner(System.in);
                String nm = maqScanner2.nextLine();
                System.out.println("Tipo da maquina:");
                System.out.flush();
                String t = maqScanner2.nextLine();
                addMaquina(nm, t);
                break;
            default:
                System.out.println("\nOpção inválida!\n");
                break;
        }
    }

    // Função estática para colocar os dados
    public static void baseDeTeste(Academia academia) {
        Treino t1 = new Treino("Peito e biceps");
        Treino t2 = new Treino("Costas");
        Treino t3 = new Treino("Ombros e tríceps");
        Treino t4 = new Treino("Pernas");
        Maquina m1 = new Maquina("Legpress", "perna");
        Maquina m2 = new Maquina("Supino", "peito");
        Maquina m3 = new Maquina("Remada curvada", "costas");
        Maquina m4 = new Maquina("Mesa scott", "braço");
        Exercicio e1 = new Exercicio(m1, "Leg 45", 4, 12, 260);
        Exercicio e2 = new Exercicio(m2, "Supino Reto", 3, 12, 70);
        Exercicio e3 = new Exercicio(m3, "Costas isolado", 4, 10, 55);
        Exercicio e4 = new Exercicio(m4, "Bíceps scott", 5, 10, 35);
        Aluno a = new Aluno("Luiz", 1234, "luiz@gmail.com", 988888888);
        Aluno b = new Aluno("bruna", 1235, "brun@gmail.com", 923874832);
        Aluno c = new Aluno("carlos", 1236, "carlos@gmail.com", 923874523);
        Aluno d = new Aluno("daniela", 1237, "dan@gmail.com", 923567932);
        Aluno e = new Aluno("jose", 1238, "j@gmail.com", 49348378);
        Aluno f = new Aluno("alberto", 1239, "alb@gmail.com", 43384374);
        Aluno g = new Aluno("marcos", 12310, "marc@gmail.com", 343492834);
        Aluno h = new Aluno("maria", 123723, "mary@gmail.com", 434542324);

        t1.addExercicio(e1);
        t1.addExercicio(e3);
        t1.addExercicio(e2);
        t1.addExercicio(e4);

        t2.addExercicio(e4);
        t2.addExercicio(e2);
        t2.addExercicio(e3);
        t2.addExercicio(e1);

        t3.addExercicio(e2);
        t3.addExercicio(e2);
        t3.addExercicio(e3);
        t3.addExercicio(e1);

        t4.addExercicio(e1);
        t4.addExercicio(e2);
        t4.addExercicio(e3);
        t4.addExercicio(e4);

        a.addTreino(t1);
        a.addTreino(t2);
        a.addTreino(t3);
        a.addTreino(t4);

        b.addTreino(t1);
        b.addTreino(t2);
        b.addTreino(t3);
        b.addTreino(t4);

        c.addTreino(t1);
        c.addTreino(t2);
        c.addTreino(t3);
        c.addTreino(t4);

        d.addTreino(t1);
        d.addTreino(t2);
        d.addTreino(t3);
        d.addTreino(t4);

        academia.addMaquina(m4);
        academia.addMaquina(m1);
        academia.addMaquina(m3);
        academia.addMaquina(m2);

        academia.addAluno(a);
        academia.addAluno(e);
        academia.addAluno(c);
        academia.addAluno(h);
        academia.addAluno(g);
        academia.addAluno(d);
        academia.addAluno(f);
        academia.addAluno(b);
    }
}
