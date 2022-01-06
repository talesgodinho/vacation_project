package projeto2;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void mostrarMenu(){
        System.out.println("*———————————————————————————————————————————*");
        System.out.println("|  BEM-VINDO AO GERENCIADOR DE PROFESSORES  |");
        System.out.println("*———————————————————————————————————————————*");
        System.out.println("|             Escolha uma opção:            |");
        System.out.println("| 1 - Cadastrar turma                       |");
        System.out.println("| 2 - Cadastrar docentes                    |");
        System.out.println("| 3 - Definir docentes por turma            |");
        System.out.println("| 4 - Listar turmas                         |");
        System.out.println("| 5 - Listar docentes                       |");
        System.out.println("| 6 - Busca única por docente               |");
        System.out.println("| 7 - SAIR                                  |");
        System.out.println("—————————————————————————————————————————————");
        executaMenu();
    }

    public static void executaMenu(){

        int op;

        do {
            System.out.print("     Digite o número da opção desejada: ");
            op = Integer.parseInt(input.nextLine());

            switch (op) {
//                case 1 -> adicionaFunc();
//                case 2 -> obterFunc();
//                case 3 -> demitir();
//                case 4 -> atualizaInfo();
//                case 5 -> listarTodos();
//                case 6 -> listarAtivos();
                case 7 -> System.exit(0);
                default -> System.out.println("   ** Opção inválida, tente novamente **");
            }
        } while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5 && op != 6 && op != 7);
    }

    public static void main(String[] args) {
        mostrarMenu();
    }

}
