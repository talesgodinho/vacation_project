package projeto2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aulas {

    private String idTurma;
    private String nomeTurma;
    private String assunto;
    private LocalDate dataInicio;
    private String idDocente;
    private String nomeDocente;

    public static List<Aulas> aulas = new ArrayList<>();

    public Aulas(String idTurma, String nomeTurma, String assunto, LocalDate dataInicio, String idDocente, String nomeDocente) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.assunto = assunto;
        this.dataInicio = dataInicio;
        this.idDocente = idDocente;
        this.nomeDocente = nomeDocente;
    }


    public String getNomeTurma() {
        return nomeTurma;
    }

    public String getAssunto() {
        return assunto;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public String getIdDocente() {
        return idDocente;
    }

    @Override
    public String toString() {
        return "Docente " + nomeDocente + " lecionará " + assunto + " para a turma " + nomeTurma + " na semana com início em " + dataInicio;
    }
}
