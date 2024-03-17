package Q3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Produto {
    private String nome;
    private String segmento;
    private List<String> caracteristicas;

    public Produto(String nome, String segmento, List<String> caracteristicas) {
        this.nome = nome;
        this.segmento = segmento;
        this.caracteristicas = caracteristicas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        String caracteristicaS = "";
        if (caracteristicas != null && caracteristicas.size() > 0) {
            caracteristicaS = "";
            for (String caracteristica : caracteristicas) {
                caracteristicaS += caracteristica + ", ";
            }
            caracteristicaS = caracteristicaS.substring(0, caracteristicaS.length() - 2);
        }

        return "Nome: " + nome + "\n" + "Segmento: " + segmento + "\n" + "Características : " + caracteristicaS;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        Map<String, Integer> segmentos = new HashMap<>();
        int opcao;
        do {
            System.out.println("Escolha uma opção: \n1. Cadastrar\n2. Listar todos os registros" +
                    "\n3. Quantidade de segmentos\n4. Alterar dados\n5. Remoção\n0. Finalizar");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar(teclado, produtos, segmentos);
                    break;
                case 2:
                    listar(produtos);
                    break;
                case 3:
                    qtdSegmentos(segmentos);
                    break;
                case 4:
                    alterar(teclado, produtos);
                    break;
                case 5:
                    remover(teclado, produtos, segmentos);
                    break;
                case 0:
                    System.out.println("Finalizado");
                    break;
                default:
                    System.out.println("Opção inválida. Tente outra");
                    break;
            }
        } while (opcao != 0);

        teclado.close();
    }

    public static void cadastrar(Scanner teclado, ArrayList<Produto> produtos, Map<String, Integer> segmentos) {
        System.out.println("Nome do produto");
        String nome = teclado.nextLine();

        System.out.println("Segmento do produto");
        String segmento = teclado.nextLine();

        System.out.println("Deseja adicionar características? S/N");
        String resposta = teclado.nextLine().toUpperCase();

        List<String> caracteristicas = new ArrayList<>();
        if (resposta.equals("S")) {
            String caracteristica;
            do {
                System.out.println("Digite uma característica (digite 'F' para parar):");
                caracteristica = teclado.nextLine();
                if (!caracteristica.equalsIgnoreCase("F")) {
                    caracteristicas.add(caracteristica);
                }
            } while (!caracteristica.equalsIgnoreCase("F"));
        }

        Produto produto = new Produto(nome, segmento, caracteristicas);
        produtos.add(produto);

        segmentos.put(segmento, segmentos.getOrDefault(segmento, 0) + 1);

        System.out.println("Produto cadastrado com sucesso.");
    }

    public static void listar(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Não existem produtos cadastrados.");
        } else {
            System.out.println("Produtos cadastrados");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public static void qtdSegmentos(Map<String, Integer> segmentos) {
        System.out.println("Quantidade de produtos em cada segmento:");
        for (Map.Entry<String, Integer> entry : segmentos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void alterar(Scanner teclado, ArrayList<Produto> produtos) {
        System.out.println("Digite o nome do produto que deseja alterar:");
        String nome = teclado.nextLine();

        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getNome().equals(nome)) {
                System.out.println("Digite o novo nome:");
                String novoNome = teclado.nextLine();
                System.out.println("Digite o novo segmento:");
                String novoSegmento = teclado.nextLine();

                produto.setNome(novoNome);
                produto.setSegmento(novoSegmento);

                System.out.println("Produto alterado com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void remover(Scanner teclado, ArrayList<Produto> produtos, Map<String, Integer> segmentos) {
        System.out.println("Digite o nome do produto que deseja remover:");
        String nome = teclado.nextLine();

        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getNome().equals(nome)) {
                produtos.remove(i);

                String segmento = produto.getSegmento();
                segmentos.put(segmento, segmentos.get(segmento) - 1);

                System.out.println("Produto removido");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}
