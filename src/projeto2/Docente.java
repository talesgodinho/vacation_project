package projeto2;

public class Docente {

    private String idDocente;
    private String nomeDocente;
    private String turmaAtual;

    public Docente(String idDocente, String nomeDocente) {
        this.idDocente = idDocente;
        this.nomeDocente = nomeDocente;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public void setNomeDocente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
    }

    public String getTurmaAtual() {
        return turmaAtual;
    }

    public void setTurmaAtual(String turmaAtual) {
        this.turmaAtual = turmaAtual;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "idDocente='" + idDocente + '\'' +
                ", nomeDocente='" + nomeDocente + '\'' +
                '}';
    }
}
