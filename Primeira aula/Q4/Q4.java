/*  A melhor opção é a fila por causa do seu comportamento, deixa o codigo mais facil de manipular para atender aos requisitos,
graças ao seu modelo de funcionamento que elimina o primeiro a entrar na fila*/
package Q4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner teclado = new Scanner(System.in);
        
        int executar = 1;
        while (executar != 0) {
            System.out.println("Selecione uma das opções:\n1 Cadastrar\n2 Remover\n3 Checar lista\n0 Finalizar");
            int opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Escreva o nome da pessoa para cadastra-la");
                    String nome = teclado.nextLine();
                    fila.offer(nome); 
                    System.out.println("Atendimento cadastrado");
                    break;
                case 2:
                    if (!fila.isEmpty()) {
                        String atendimentoRemovido = fila.poll();
                        System.out.println("Atendimento removido: " + atendimentoRemovido);
                    } else {
                        System.out.println("A fila não possui atendimentos");
                    }
                    break;
                    case 3:
                    listar(fila);
                    break;
                case 0:
                    System.out.println("Encerrando");
                    executar = 0;
                    break;
                   
                default:
                    System.out.println("Opção inválida");
            }
        }


        teclado.close();
    }

    public static void listar(Queue<String> fila) {
        if (!fila.isEmpty()) {
            System.out.println("Fila de atendimentos:");

            for (String atendimento : fila) {
                System.out.println(atendimento);
            }
        } else {
            System.out.println("não existe atendimentos na fila");
        }
    }
}

