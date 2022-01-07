package projeto1;

//Desenvolva um algoritmo em JAVA para implementar um “Sistema de Gerenciamento de Funcionários”

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void mostrarMenu(){
        System.out.println("*————————————————————————————————————————————*");
        System.out.println("|  BEM-VINDO AO GERENCIADOR DE FUNCIONÁRIOS  |");
        System.out.println("*————————————————————————————————————————————*");
        System.out.println("|              Escolha uma opção:            |");
        System.out.println("| 1 - Adicionar Funcionário                  |");
        System.out.println("| 2 - Ver detalhes de um funcionário         |");
        System.out.println("| 3 - Demitir funcionário                    |");
        System.out.println("| 4 - Atualizar informações de funcionário   |");
        System.out.println("| 5 - Listar todos os funcionários           |");
        System.out.println("| 6 - Listar funcionário ativos              |");
        System.out.println("| 7 - Listar funcionário desligados          |");
        System.out.println("| 8 - SAIR                                   |");
        System.out.println("——————————————————————————————————————————————");
        executaMenu();
    }

    public static void executaMenu(){

        int op;

        do {
            System.out.print("Digite o número da opção desejada: ");
            op = Integer.parseInt(input.nextLine());

            switch (op) {
                case 1 -> adicionaFunc();
                case 2 -> obterFunc();
                case 3 -> demitir();
                case 4 -> atualizaInfo();
                case 5 -> listarTodos();
                case 6 -> listarAtivos();
                case 7 -> listarDesligados();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida, tente novamente");
            }
        } while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5 && op != 6 && op != 7 && op != 8);
    }

    public static void adicionaFunc(){
        System.out.println("\n--- Gerência de funcionários | Adicionar ---");

        System.out.print("Informe o nome do(a) funcionário(a): ");
        String nome = input.nextLine();

        System.out.print("Informe o número da matrícula: ");
        String matricula = input.nextLine();

        System.out.println("\nEm qual cargo você deseja adicionar?\n");

        System.out.println("*————————————————————————————————————————————*");
        System.out.println("|             CARGOS DISPONÍVEIS             |");
        System.out.println("*————————————————————————————————————————————*");
        System.out.println("|              Escolha uma opção:            |");
        System.out.println("| 1 - Gerente Geral                          |");
        System.out.println("| 2 - Gerente de departamento                |");
        System.out.println("| 3 - Líder Técnico                          |");
        System.out.println("| 4 - Colaborador                            |");
        System.out.println("| 5 - VOLTAR                                 |");
        System.out.println("——————————————————————————————————————————————");

        int op;

        do {
            System.out.print("Digite o número da opção desejada: ");
            op = Integer.parseInt(input.nextLine());

            switch (op) {
                case 1 -> {
                    GerenteGeral.colaboradores.add(new Colaborador(nome,matricula,"Gerente Geral",true));
                    System.out.println("Gerente Geral " + nome + " foi incluído(a) com sucesso no sistema!");
                    retornaMenu();
                }
                case 2 -> {
                    GerenteDepartamento.colaboradores.add(new Colaborador(nome,matricula,"Gerende de Departamento" ,true));
                    System.out.println("Gerente de departamento " + nome + " foi incluído(a) com sucesso no sistema!");
                    retornaMenu();
                }
                case 3 -> {
                    LiderTecnico.colaboradores.add(new Colaborador(nome,matricula,"Líder técnico" ,true));
                    System.out.println("Líder " + nome + " foi incluído(a) com sucesso no sistema!");
                    retornaMenu();
                }
                case 4 -> {
                    Colaborador.colaboradores.add(new Colaborador(nome,matricula,"Colaborador(a)",true));
                    System.out.println("Colaborador(a) " + nome + " foi incluído(a) com sucesso no sistema!");
                    retornaMenu();
                }
                case 5 -> mostrarMenu();
                default -> System.out.println("Opção inválida, tente novamente");
            }
        } while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5);
    }

    public static void obterFunc(){
        System.out.print("Informe a matrícula do funcionário para obter detalhes: ");
        String matricula = input.nextLine();

        while (validaMatricula(matricula)){
            System.out.print("Matrícula não encontrada. Insira uma diferente ou digite VOLTAR: ");
            matricula = input.nextLine();
        if (matricula.equals("VOLTAR") || matricula.equals("voltar")) mostrarMenu();
        }

        for (int i = 0; i < Colaborador.colaboradores.size(); i++){
            if (Colaborador.colaboradores.get(i).getMatricula().equals(matricula)){
                System.out.println(Colaborador.colaboradores.get(i).toString());
            }
        }
        retornaMenu();
    }

    public static void demitir(){
        System.out.print("Informe a matrícula do funcionário que deseja demitir: ");
        String matricula = input.nextLine();

        while (validaMatricula(matricula)){
            System.out.print("Matrícula não encontrada. Insira uma diferente ou digite VOLTAR: ");
            matricula = input.nextLine();
            if (matricula.equals("VOLTAR") || matricula.equals("voltar")) mostrarMenu();
        }

        for (int i = 0; i < Colaborador.colaboradores.size(); i++){
            if (Colaborador.colaboradores.get(i).getMatricula().equals(matricula)){
                System.out.println("Deseja confirmar a demissão de " + Colaborador.colaboradores.get(i).getNome() + "? S/N");
                String confirma = input.nextLine();
                if (confirma.equals("S") || confirma.equals("s")){
                    Colaborador.colaboradores.get(i).setStatus(false);
                    System.out.println("O funcionário " + Colaborador.colaboradores.get(i).getNome() + " foi desligado com sucesso!");
                } else
                    System.out.println("O funcionário " + Colaborador.colaboradores.get(i).getNome() + " permanece ativo.");
            }
        }
        retornaMenu();
    }

    public static boolean validaMatricula(String matricula){

        boolean valida = false;

        for (int i = 0; i < Colaborador.colaboradores.size(); i++){
            if (Colaborador.colaboradores.get(i).getMatricula().equals(matricula)) {
                valida = true;
                break;
            }
        }
        return !valida;
    }

    public static void atualizaInfo(){
        System.out.print("Informe a matrícula do funcionário para atualizar informações: ");
        String matricula = input.nextLine();

        while (validaMatricula(matricula)){
            System.out.print("Matrícula não encontrada. Insira uma diferente ou digite VOLTAR: ");
            matricula = input.nextLine();
            if (matricula.equals("VOLTAR") || matricula.equals("voltar")) mostrarMenu();
        }

        System.out.println("Qual informação você deseja atualizar?");
        System.out.println("""
                1 - Nome
                2 - Matrícula
                3 - Nome e matrícula
                4 - Função
                5 - Recontratar funcionário
                6 - VOLTAR""");

        int op;

        do {
            System.out.print("Digite o número da opção desejada: ");
            op = Integer.parseInt(input.nextLine());

            switch (op) {
                case 1 -> {
                    System.out.print("Insira o novo nome: ");
                    String nome = input.nextLine();
                    for (int i = 0; i < Colaborador.colaboradores.size(); i++){
                        if (Colaborador.colaboradores.get(i).getMatricula().equals(matricula)){
                            Colaborador.colaboradores.get(i).setNome(nome);
                        }
                    }
                    System.out.println("O nome foi alterado com sucesso para: " + nome);
                    retornaMenu();
                }
                case 2 -> {
                    System.out.print("Insira a nova matrícula: ");
                    String newMat = input.nextLine();

                    for (int i = 0; i < Colaborador.colaboradores.size(); i++){
                        if (Colaborador.colaboradores.get(i).getMatricula().equals(matricula)){
                            Colaborador.colaboradores.get(i).setMatricula(newMat);
                        }
                    }
                    System.out.println("A matrícula foi alterada com sucesso para: " + newMat);
                    retornaMenu();
                }
                case 3 -> {
                    System.out.print("Insira o novo nome: ");
                    String nome = input.nextLine();

                    System.out.print("Insira a nova matrícula: ");
                    String newMat = input.nextLine();

                    for (int i = 0; i < Colaborador.colaboradores.size(); i++){
                        if (Colaborador.colaboradores.get(i).getMatricula().equals(matricula)){
                            Colaborador.colaboradores.get(i).setMatricula(newMat);
                            Colaborador.colaboradores.get(i).setNome(nome);
                        }
                    }
                    System.out.println("O nome foi alterado com sucesso para: " + nome + " e a matrícula para: " + newMat);
                    retornaMenu();
                }
                case 4 -> {
                    System.out.println("*** Não é possível alterar a função do funcionário no mesmo contrato/matrícula. Cadastre como novo funcionário! ***");
                }
                case 5 -> {
                    for (int i = 0; i < Colaborador.colaboradores.size(); i++){
                        if (Colaborador.colaboradores.get(i).getMatricula().equals(matricula)){
                            if (!Colaborador.colaboradores.get(i).getStatus()) {
                                System.out.println("Deseja confirmar a readmissão de " + Colaborador.colaboradores.get(i).getNome() + "? S/N");
                                String confirma = input.nextLine();
                                if (confirma.equals("S") || confirma.equals("s")) {
                                    Colaborador.colaboradores.get(i).setStatus(true);
                                    System.out.println("O funcionário " + Colaborador.colaboradores.get(i).getNome() + " foi readmitido com sucesso!");
                                } else
                                    System.out.println("O funcionário " + Colaborador.colaboradores.get(i).getNome() + " permanece desligado.");
                            } else
                                System.out.println("O colaborador já está ativo!");
                        }
                    }
                    retornaMenu();
                }
                case 6 -> mostrarMenu();
                default -> System.out.println("Opção inválida, tente novamente");
            }
        } while (op != 1 && op != 2 && op != 3 && op != 4);
        
        retornaMenu();
    }

    public static void listarTodos(){
        System.out.println(" --- Listando todos os funcionários --- ");
        for (int i = 0; i < Colaborador.colaboradores.size(); i++){
                System.out.println(Colaborador.colaboradores.get(i).toString());
        }
        retornaMenu();
    }

    public static void listarAtivos(){
        System.out.println(" --- Listando todos os funcionários ativos --- ");
        for (int i = 0; i < Colaborador.colaboradores.size(); i++){
            if (Colaborador.colaboradores.get(i).getStatus()){
                System.out.println(Colaborador.colaboradores.get(i).toString());
            }
        }
        retornaMenu();
    }

    public static void listarDesligados(){
        System.out.println(" --- Listando todos os funcionários demitidos --- ");
        for (int i = 0; i < Colaborador.colaboradores.size(); i++){
            if (!Colaborador.colaboradores.get(i).getStatus()){
                System.out.println(Colaborador.colaboradores.get(i).toString());
            }
        }
        retornaMenu();
    }

    public static void retornaMenu(){
        System.out.println("\nVocê será redirecionado ao menu inicial...");
        mostrarMenu();
    }

    public static void main(String[] args) {
        mostrarMenu();
    }

}
