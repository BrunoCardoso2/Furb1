package Q3;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        ArrayList<Produtos> produtosLista = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("\nEscolha uma opção:\n1 Cadastrar\n2 Listar\n3 Alterar" + 
            "\n4 Remover\n5 Pesquisar \n0 Finalizar\nOpção: ");

            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println(cadastrar(produtosLista, teclado));
                    break;
                case "2":
                    listar(produtosLista);
                    break;
                case "3":
                    alterar(produtosLista, teclado);
                    break;
                case "4":
                    System.out.println(remover(produtosLista, teclado));
                    break;
                case "5":
                    pesquisar(produtosLista, teclado);
                    break;
                case "0":
                    System.out.println("Finalizando");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (!opcao.equals("0"));
        
        teclado.close();
    }

    public static String cadastrar(ArrayList<Produtos> listaProdutos, Scanner teclado) {
        try {
            System.out.println("Coloque nome do produto:");
            String nome = teclado.nextLine();
            System.out.println("Coloque o valor do produto:");
            double valor = Double.parseDouble(teclado.nextLine());
            Produtos novoProduto = new Produtos(nome, valor);
            listaProdutos.add(novoProduto);

            return "Produto cadastrado";
        } catch (NumberFormatException e) {
            return "Valor inválido. ";
        }
    }

    public static void pesquisar(ArrayList<Produtos> listaDosProdutos, Scanner teclado) {
        System.out.println("Digite o termo de pesquisa:");
        String termo = teclado.nextLine();
        System.out.println("Resultados da pesquisa:");
        for (Produtos produto : listaDosProdutos) {
            if (produto.getNome().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println("Nome: " + produto.getNome() + ", Valor: " + produto.getValor());
            }
        }
    }

    public static void alterar(ArrayList<Produtos> listaProdutos, Scanner teclado) {
        System.out.println("Digite o nome do produto para altera-lo");
        String nome = teclado.nextLine();
        for (Produtos produto : listaProdutos) {
            
            if (produto.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Digite o nome do novo produto:");
                String novoNome = teclado.nextLine();
                System.out.println("Digite o novo valor do produto:");
                double novoValor;
                try {
                    novoValor = Double.parseDouble(teclado.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido");
                    return;
                }
                produto.setNome(novoNome);
                produto.setValor(novoValor);

                System.out.println("Produto alterado com sucesso!");
                return;
            }
        }
        System.out.println("O Produto não foi encontrado");
    }

    public static String remover(ArrayList<Produtos> listaProdutos, Scanner teclado) {

        System.out.println("Digite o nome do produto para removê-lo:");
        String nome = teclado.nextLine();

        for (int i = 0; i < listaProdutos.size(); i++) {

            if (listaProdutos.get(i).getNome().equalsIgnoreCase(nome)) {
                listaProdutos.remove(i);
                return "Produto removido";
            }
        }
        return "O Produto não foi encontrado";
    }

    public static void listar(ArrayList<Produtos> listaProdutos) {

        System.out.println("Lista de produtos:");

        for (Produtos produto : listaProdutos) {
            System.out.println("Nome do produto: " + produto.getNome() + ", Valor: " + produto.getValor());
        }
    }
}
