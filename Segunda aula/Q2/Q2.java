package Q2;
import java.util.Scanner;
import java.util.Vector;

public class Q2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Vector<String> lista = new Vector<>();
        System.out.println("Escolha uma opção:\n1 Cadastrar\n2 Listar\n3 Pesquisar\n4 Alterar\n5 Remover\n0 Finalizar");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println(cadastrar(lista, teclado));
                    break;
                case 2:
                    listar(lista);
                    break;
                case 3:
                    pesquisar(teclado, lista);
                    break;
                case 4:
                    alterar(teclado, lista);
                    break;
                case 5:
                    remover(teclado, lista);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            System.out.println("Escolha uma opção:\n1 Cadastrar\n2 Listar\n3 Pesquisar\n4 Alterar\n5 Remover\n0 Finalizar");
            opcao = teclado.nextInt();
            teclado.nextLine();
        }
        System.out.println("Finalizado");
    }

    public static String cadastrar(Vector<String> lista, Scanner teclado) {
        System.out.println("Escreva um nome para cadastra-lo");
        String nome = teclado.nextLine();

        if (!lista.contains(nome)) {
            lista.add(nome);
            return "Cadastrado com sucesso";
        }
        return "Nome já existe no vetor";
    }

    public static void listar(Vector<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("Não existem nomes no vetor");
        } else {
            for (String elemento : lista) {
                System.out.println(elemento);
            }
        }
    }

    public static void pesquisar(Scanner teclado, Vector<String> lista) {
        System.out.println("Coloque um termo para pesquisa: ");
        String termo = teclado.nextLine();
        boolean encontrado = false;
        for (String elemento : lista) {
            if (elemento.toLowerCase().contains(termo.toLowerCase())) {
                System.out.println(elemento);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Não existem elementos com este termo no vetor");
        }
    }

    public static void alterar(Scanner teclado, Vector<String> lista) {
        System.out.println("Digite um nome para alterá-lo");
        String nome = teclado.nextLine();
        int index = lista.indexOf(nome);
        if (index != -1) {
            System.out.println("Digite o novo nome");
            String novoNome = teclado.nextLine();
            lista.set(index, novoNome);
            System.out.println("Nome alterado com sucesso");
        } else {
            System.out.println("Nome não encontrado");
        }
    }

    public static void remover(Scanner teclado, Vector<String> lista) {
        System.out.println("Escreva um nome para removê-lo");
        String nome = teclado.nextLine();
        if (lista.remove(nome)) {
            System.out.println("Removido com sucesso");
        } else {
            System.out.println("Nome não encontrado");
        }
    }
}
