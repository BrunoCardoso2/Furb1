package Q5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Map<String, Aluno> alunos = new HashMap<>();

        int opcao;
        do {
            System.out.println("\nEscolha uma opção: \n 1. Cadastrar Aluno\n2. Listar Alunos\n"
            + "3. Alterar Aluno\n4. Excluir Aluno\n5. Estatísticas\n0. Sair");
          
            opcao = teclado.nextInt();
            teclado.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrar(teclado, alunos);
                    break;
                case 2:
                    listar(teclado, alunos);
                    break;
                case 3:
                    alterar(teclado, alunos);
                    break;
                case 4:
                    excluir(teclado, alunos);
                    break;
                case 5:
                    estatisticas(alunos);
                    break;
                case 0:
                    System.out.println("Finalizado");
                    break;
                default:
                    System.out.println("Opção inválida. Tente outra");
                    break;
            }
        } while (opcao != 0);
    }

    public static void cadastrar(Scanner teclado, Map<String, Aluno> alunos) {
        System.out.println("Digite o nome");
        String nome = teclado.nextLine();
        System.out.println("Digite a nota");
        double nota = teclado.nextDouble();
        teclado.nextLine(); 

        Aluno aluno = new Aluno(nome, nota);
        alunos.put(nome, aluno);
        System.out.println("Aluno cadastrado.");
    }

    public static void listar(Scanner teclado, Map<String, Aluno> alunos) {
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : alunos.values()) {
            System.out.println("Nome: " + aluno.getNome() + " Nota: " + aluno.getNota());
            System.out.println();
        }
    }

    public static void alterar(Scanner teclado, Map<String, Aluno> alunos) {
        System.out.println("Digite o nome");
        String nome = teclado.nextLine();
    
        if (alunos.containsKey(nome)) {
            System.out.println("Digite a nova nota:");
            String novaNotaStr = teclado.nextLine();
            double novaNota;
            try {
                novaNota = Double.parseDouble(novaNotaStr);
            } catch (NumberFormatException e) {
                System.out.println("Nota inválida. Digite outra");
                return;
            }
    
            Aluno aluno = alunos.get(nome);
            aluno.setNota(novaNota);
            System.out.println("Nota atualizada");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
    
    public static void estatisticas(Map<String, Aluno> alunos) {
        int totalA = alunos.size();
        int aprovado = 0;
        int reprovado = 0;

        for (Aluno aluno : alunos.values()) {
            if (aluno.getNota() >= 5.0) {
                aprovado++;
            } else {
                reprovado++;
            }
        }

        System.out.println("Estatísticas:");
        System.out.println("Total de alunos registrados: " + totalA + "\nAlunos aprovados: " + aprovado + "\nAlunos reprovados: " + reprovado);

    }
    public static void excluir(Scanner teclado, Map<String, Aluno> alunos) {
        System.out.println("Digite o nome do aluno:");
        String nome = teclado.nextLine();

        if (alunos.containsKey(nome)) {
            alunos.remove(nome);
            System.out.println("Aluno removido.");
        } else {
            System.out.println("Aluno não existe.");
        }
    }

    
}


