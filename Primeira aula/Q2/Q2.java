package Q2;
import java.util.Scanner;

public class Q2 {

public static void main(String[] args) {
    String[] lista = new String[10];
        Scanner teclado = new Scanner(System.in);
    String continuar;
    do {
        System.out.println("\nEscolha uma opção:\n1 Cadastrar\n2 Listar todos os nomes\n3 Alterar" + 
        "\n4 Remover\n0 Finalizar\nOpção: ");
        continuar = teclado.nextLine();

        switch (continuar) {
            case "1":
                System.out.println(cadastrar(lista, teclado)); 
                break;
            case "2":
                listar(lista);
                break;
            case "3":
                System.out.println(alterar(lista, teclado));;
                break;
            case "4":
                System.out.println(remover(lista, teclado));;
                break;
            case "0":
                System.out.println("Finalizado");
                break;
            default:
                System.out.println("Opção inválida");
        }
    } while (!continuar.equals("0"));
}
public static String cadastrar(String[] lista, Scanner teclado) {
    System.out.println("Digite o nome para cadastra-lo");
    String nome = teclado.nextLine();
    for (int i = 0; i < lista.length; i++) {
        if (lista[i] == null) {

            lista[i] = nome;
           
            return "Cadastrado";
        }
    }
    return "Lista cheia. Remova algum nome antes de cadastrar um novo nome";
}

public static String alterar(String[] lista, Scanner teclado) {
    System.out.println("Digite o nome para alterar");
    String nomeAnterior = teclado.nextLine();
    System.out.println("Digite o novo nome");
    String nome = teclado.nextLine();

    for (int i = 0; i < lista.length; i++) {

        if (lista[i] != null && lista[i].equals(nomeAnterior)) {
            lista[i] = nome;
            return "O Nome foi alterado";

        }
    }
    return"O Nome não foi encontrado";
}


public static String remover(String[] lista, Scanner teclado) {

    System.out.println("Digite o nome que deseja remover:");
    String RemoverNome = teclado.nextLine();

    for (int i = 0; i < lista.length; i++) {

        if (lista[i] != null && lista[i].equals(RemoverNome)) {
            lista[i] = null;
            return "O Nome foi removido com sucesso!";
        }
    }
    return "O Nome não foi encontrado na lista.";
}

public static void listar(String[] lista) {

    System.out.println("Lista com todos os nomes:");
    for (String nome : lista) {
        if (nome != null) {
            System.out.println(nome);
        }
    }
}
}


     
