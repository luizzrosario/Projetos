package Projeto;

import Projeto.Classes.Academia;

public class Main {
    public static void main(String[] args) throws Exception {
        Academia Olympia = new Academia("Olympia");
        int any = 1;
        Academia.baseDeTeste(Olympia);

        try {
            while (any != -1) {
                any = Olympia.menu();
            }
        } catch (Exception exc) {
            while (any != -1) {
                any = Olympia.menu();
            }
        }
    }
}
