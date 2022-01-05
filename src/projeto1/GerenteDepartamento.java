package projeto1;

public class GerenteDepartamento extends Colaborador implements Gerente{

    public GerenteDepartamento(String nome, String matricula, String funcao, Boolean status) {
        super(nome, matricula, funcao, status);
    }

    @Override
    public void gerenciar() {
        System.out.println("Passando tarefas para o líder técnico");
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
