package projeto1;

import java.util.ArrayList;
import java.util.Scanner;

public class Colaborador {

    private String nome;
    private String matricula;
    private String funcao;
    private Boolean status;

    public static ArrayList<Colaborador> colaboradores = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public Colaborador(String nome, String matricula, String funcao, Boolean status) {
        this.nome = nome;
        this.matricula = matricula;
        this.funcao = funcao;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {

        String statusColab;

        if (status)
            statusColab = "Ativo";
        else
            statusColab = "Desligado";


        return "Colaborador{" +
               "nome='" + nome + '\'' +
               ", matricula='" + matricula + '\'' +
               ", função='" + funcao + '\'' +
               ", status=" + statusColab +
               '}';
    }
}
