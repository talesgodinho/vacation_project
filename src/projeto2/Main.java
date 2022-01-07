package projeto2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static List<Turma> turmas = new ArrayList<>();
    public static List<Docente> docentes = new ArrayList<>();

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
                case 1 -> newTurma();
                case 2 -> newDocente();
                case 3 -> defineAulas();
                case 4 -> listarTurmas();
                case 5 -> listarDocentes();
                case 6 -> buscaDocente();
                case 7 -> System.exit(0);
                default -> System.out.println("   ** Opção inválida, tente novamente **");
            }
        } while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5 && op != 6 && op != 7);
    }

    public static void retornaMenu(){
        System.out.println("\nVocê será redirecionado ao menu inicial...");
        mostrarMenu();
    }

    public static void newTurma(){

        boolean valida = true;
        String id = null;

        do {
            valida = true;
            System.out.print("Informe o ID da turma: ");
            id = input.nextLine();

            for (Turma turma : turmas) {
                if (turma.getIdTurma().equals(id)) {
                    valida = false;
                    System.out.println("ID já existente! Insira um difernete.");
                    break;
                }
            }
        }while (!valida);

        System.out.print("Informe o nome da turma: ");
        String nome = input.nextLine();

        System.out.print("Informe o número de alunos: ");
        int numAlunos = Integer.parseInt(input.nextLine());

        System.out.print("Informe a data de início da turma (no formato dd/MM/yyyy): " );
        String dataInicio = input.nextLine();
        LocalDate dataInicioCV = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        MenuAssuntos.mostraAssuntos();
        String assunto = "";

        int op;

        do {
            System.out.print("     Digite o número da opção desejada: ");
            op = Integer.parseInt(input.nextLine());

            switch (op) {
                case 1 -> assunto = "C#";
                case 2 -> assunto = "C/C++";
                case 3 -> assunto = "Assembly";
                case 4 -> assunto = "JAVA";
                case 5 -> mostrarMenu();
                default -> System.out.println("   ** Opção inválida, tente novamente **");
            }
        } while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5);

        turmas.add(new Turma(id,nome,numAlunos, assunto ,dataInicioCV));
        System.out.println("Turma " + nome + " adicionada com sucesso");
        retornaMenu();
    }

    public static void newDocente(){

        boolean valida = true;
        String id = null;

        do {
            valida = true;
            System.out.print("Informe o ID do docente: ");
            id = input.nextLine();

            for (Docente docente : docentes) {
                if (docente.getIdDocente().equals(id)) {
                    valida = false;
                    System.out.println("ID já existente! Insira um difernete.");
                    break;
                }
            }
        }while (!valida);


        System.out.print("Informe o nome do docente: ");
        String nome = input.nextLine();

        docentes.add(new Docente(id,nome));
        System.out.println("Docente " + nome + " adicionado com sucesso");
        retornaMenu();
    }

    public static void defineAulas(){
        System.out.print("Informe o ID da turma que você deseja atribuir o docente: ");
        String idTurma = input.nextLine();

        System.out.print("Informe o ID do docente que lecionará na semana desta turma: ");
        String idDocente = input.nextLine();

        String nomeTurma = null;
        String assunto = null;
        LocalDate dataInicio = null;

        for (Turma turma : turmas) {
            if (turma.getIdTurma().equals(idTurma)) {
                nomeTurma = turma.getNomeTurma();
                assunto = turma.getAssunto();
                dataInicio = turma.getDataInicio();
            }
        }

        String nomeDocente = null;

        for (Docente docente : docentes) {
            if (docente.getIdDocente().equals(idDocente)) {
                nomeDocente = docente.getNomeDocente();
            }
        }

        Aulas.aulas.add(new Aulas(idTurma, nomeTurma, assunto, dataInicio, idDocente, nomeDocente));
        System.out.println("Docente " + nomeDocente + " atribuído com sucesso à turma " + nomeTurma);
        retornaMenu();
    }

    public static void listarTurmas(){
        System.out.println("Lista de turmas já definidas com docente, assunto e semana:");
        for (Aulas aulas :  Aulas.aulas){
            System.out.println("- Turma " + aulas.getNomeTurma() + " na semana do dia " + aulas.getDataInicio() + " terá aula de "
                    + aulas.getAssunto() + " com o docente " + aulas.getNomeDocente() + ".");
        }
        retornaMenu();
    }

    public static void listarDocentes(){
        for (Docente docente : docentes) {
            System.out.println(docente.toString());
        }
        retornaMenu();
    }

    public static void buscaDocente(){
        System.out.print("Informe o ID do docente que você deseja pesquisar: ");
        String idDocente = input.nextLine();

        for (int i = 0; i < Aulas.aulas.size(); i++){
            if (Aulas.aulas.get(i).getIdDocente().equals(idDocente)){
                System.out.println(Aulas.aulas.get(i).toString());
            }
        }
        retornaMenu();
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}
