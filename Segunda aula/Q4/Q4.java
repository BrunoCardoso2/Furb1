package Q4;

import java.util.LinkedList;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        LinkedList<String> nomes = new LinkedList<>();
        int opcao;
        do {
            System.out.println("Escolha uma opção:\n1. Cadastrar\n2. Listar\n0. Finalizar");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar(teclado, nomes);
                    break;
                case 2:
                    listar(nomes);
                    break;
                case 0:
                    System.out.println("Finalizado");
                    break;
                default:
                    System.out.println("Opção inválida. Tente outra.");
                    break;
            }
        } while (opcao != 0);
        teclado.close(); 
    }

    public static void cadastrar(Scanner teclado, LinkedList<String> listaNomes) {
        System.out.println("Digite o nome:");
        String nome = teclado.nextLine();
        listaNomes.add(nome);
        System.out.println("Nome cadastrado com sucesso!");
    }

    public static void listar(LinkedList<String> listaNomes) {
        if (listaNomes.isEmpty()) {
            System.out.println("Lista vazia.");
        } else {
            System.out.println("Nomes cadastrados:");
            for (String nome : listaNomes) {
                System.out.println(nome);
            }
        }
    }
}
