import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class AtvAvaliativa {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Queue<String> filaTarefas = new LinkedList<>();
        System.out.println("Escolha uma opção:\n1 Adicionar\n2 Remover\n3 Proxima tarefa\n0 Finalizar");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        while (opcao != 0){
            switch (opcao) {
                case 1:
                    adicionar(filaTarefas, teclado);
                    break;
                case 2:
                  remover(filaTarefas, teclado);
                    break;
                case 3:
                    proximaTarefa(filaTarefas);
                    break;                
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            System.out.println("-------------------------");
            System.out.println("Escolha uma opção:\n1 Adicionar\n2 Remover\n3 Proxima tarefa\n0 Finalizar");
            opcao = teclado.nextInt();
            teclado.nextLine();
            
}
        System.out.println("Finalizado");
     teclado.close();      
}

public static void adicionar(Queue<String> filaTarefas, Scanner teclado){
    System.out.println("Digite uma nova tarefa");
    String tarefa = teclado.nextLine();
    if (tarefa.isEmpty()) {
        System.out.println("Nenhuma tarefa foi adicionada");
    }else{
        filaTarefas.offer(tarefa);
        System.out.println("A terefa foi adicionada");
    }
    
}

public static void remover(Queue<String> filaTarefas, Scanner teclado){
    String tarefaRemovida = filaTarefas.poll();

        if (tarefaRemovida != null) {
            System.out.println("Tarefa removida: " + tarefaRemovida);
        } else {
            System.out.println("Não existem tarefas na lista para serem removidas.");
        }
    }

    public static void proximaTarefa(Queue<String> filaDeTarefas){
        String proximaTarefa = filaDeTarefas.peek();
        if (proximaTarefa != null) {
            System.out.println("A próxima tarefa é: " + proximaTarefa);
        } else {
            System.out.println("Não existem mais tarefas a serem feitas. Parabéns :)");
        }
    }
}
