import java.util.Scanner;
import java.util.Vector;

public class Q1{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Vector<String> vector = new Vector<>();
       String nome = "";
       System.out.println("Escolha uma opção:\n1 Cadastrar\n2 Listar\n3 Pesquisar\n4 Alterar\n5 Remover\n0 Finalizar");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        while (opcao != 0) {
        
        switch (opcao) {
        
            case 1:
            System.out.println(cadastrar(vector, teclado, nome));
                break;
            case 2:
            listar(vector);
                break;
                case 3:
                pesquisar(teclado, vector);
                break;
                case 4:
                alterar(nome, teclado, vector);
                break;
                case 5:
                remover(teclado, nome, vector);
                break;
            default:
            System.out.println("Opção invalida");
                break;
        }
        teclado.nextLine();
        System.out.println("Escolha uma opção:\n1 Cadastrar\n2 Listar\n3 Pesquisar\n4 Alterar\n5 Remover\n0 Finalizar");
        opcao = teclado.nextInt();
        teclado.nextLine();
    }
    }

public static String cadastrar(Vector<String> vector, Scanner teclado,String nome){
    System.out.println("Escreva um nome para cadastra-lo");
    nome = teclado.nextLine();
    
    if (!vector.contains(nome)) {
        vector.add(nome);
        return "cadastrado com sucesso";
    }
    return "nome ja existe no vector";
}

public static void listar( Vector<String> vectors){
    for(String vector : vectors){
            System.out.println(vector);
    }
    if (vectors == null) {
        System.out.println("Não existem nomes no vector");
    }
}

public static void pesquisar(Scanner teclado, Vector<String> vectors){
    System.out.println("Coloque um termo para pesquisa: ");
    String termo = teclado.nextLine();
    for(String vector : vectors){
        if (vector.toLowerCase().contains(termo.toLowerCase())) {
            System.out.println(vector);
        }else{
            System.out.println("não exite elementos com este termo no vector");
        }
    }
    
}

public static void alterar(String nome, Scanner teclado, Vector<String> vectors){
    System.out.println("Digite um nome para altera-lo");
    nome = teclado.nextLine();
    
    for(String vector : vectors){
        if (vector.equals(nome)) {
            System.out.println("Digite o novo nome");
            String novoNome = teclado.nextLine();
            vectors.add(novoNome);
            System.out.println("Nome alterado com sucesso");
        }else{
            System.out.println("Nome não existente");
        }
    }
}

public static void remover(Scanner teclado, String nome, Vector<String> vectors){
System.out.println("Escreva um nome para removelo");
nome = teclado.nextLine();
for(String vector : vectors){
    if (vector.equals(nome)) {
        vector = null;
    }
}
}
}