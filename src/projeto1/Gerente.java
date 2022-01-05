package projeto1;

public interface Gerente {

    default void gerenciar(){
        System.out.println("Passando tarefas...");
    }

}
