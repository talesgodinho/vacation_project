package projeto1;

public class LiderTecnico extends Colaborador{

    public LiderTecnico(String nome, String matricula, String funcao, Boolean status) {
        super(nome, matricula, funcao, status);
    }

    public void liderar(){
        System.out.println("Distribuindo atividades para os colaboradores");
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setMatricula(String matricula) {
        super.setMatricula(matricula);
    }

    @Override
    public String getMatricula() {
        return super.getMatricula();
    }

    @Override
    public void setStatus(Boolean status) {
        super.setStatus(status);
    }

    @Override
    public Boolean getStatus() {
        return super.getStatus();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
