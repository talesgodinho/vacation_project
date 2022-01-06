package projeto2;

import java.time.LocalDate;

public class Turma {

    private String idTurma;
    private String nomeTurma;
    private int numAlunos;
    private String assunto;
    private LocalDate dataInicio;

    public Turma(String idTurma, String nomeTurma, int numAlunos, String assunto, LocalDate dataInicio) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.numAlunos = numAlunos;
        this.assunto = assunto;
        this.dataInicio = dataInicio;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public int getNumAlunos() {
        return numAlunos;
    }

    public void setNumAlunos(int numAlunos) {
        this.numAlunos = numAlunos;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "idTurma='" + idTurma + '\'' +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", numAlunos=" + numAlunos +
                ", assunto='" + assunto + '\'' +
                ", dataInicio=" + dataInicio +
                '}';
    }
}
