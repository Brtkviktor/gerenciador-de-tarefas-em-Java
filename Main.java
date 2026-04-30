import java.util.Scanner;

/**
 * Classe principal para interação com o usuário (Menu).
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        int opcao = -1;

        System.out.println("=========================================");
        System.out.println("   Bem-vindo ao Gerenciador de Tarefas   ");
        System.out.println("=========================================");

        while (opcao != 0) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Adicionar nova tarefa");
            System.out.println("2. Listar todas as tarefas");
            System.out.println("3. Filtrar tarefas por status");
            System.out.println("4. Atualizar tarefa");
            System.out.println("5. Remover tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1: // Adicionar Tarefa
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = scanner.nextLine();
                    
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    
                    System.out.print("Digite o status (Ex: Pendente, Em andamento, Concluída): ");
                    String status = scanner.nextLine();
                    
                    gerenciador.adicionarTarefa(titulo, descricao, status);
                    break;

                case 2: // Listar Tarefas
                    System.out.println("\n>>> LISTA DE TAREFAS <<<");
                    gerenciador.listarTarefas();
                    break;

                case 3: // Filtrar por status
                    System.out.print("Digite o status para filtrar (Ex: Pendente): ");
                    String statusFiltro = scanner.nextLine();
                    System.out.println("\n>>> TAREFAS COM STATUS: " + statusFiltro.toUpperCase() + " <<<");
                    gerenciador.listarTarefasPorStatus(statusFiltro);
                    break;

                case 4: // Atualizar Tarefa
                    System.out.print("Digite o ID da tarefa que deseja atualizar: ");
                    int idAtualizar;
                    try {
                        idAtualizar = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: ID deve ser um número inteiro.");
                        break;
                    }
                    
                    System.out.print("Novo título (deixe em branco para NÃO alterar): ");
                    String novoTitulo = scanner.nextLine();
                    
                    System.out.print("Nova descrição (deixe em branco para NÃO alterar): ");
                    String novaDescricao = scanner.nextLine();
                    
                    System.out.print("Novo status (deixe em branco para NÃO alterar): ");
                    String novoStatus = scanner.nextLine();
                    
                    gerenciador.atualizarTarefa(idAtualizar, novoTitulo, novaDescricao, novoStatus);
                    break;

                case 5: // Remover Tarefa
                    System.out.print("Digite o ID da tarefa que deseja remover: ");
                    int idRemover;
                    try {
                        idRemover = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: ID deve ser um número inteiro.");
                        break;
                    }
                    gerenciador.removerTarefa(idRemover);
                    break;

                case 0: // Sair
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Erro: Opção inválida. Tente novamente.");
            }
        }
        
        scanner.close();
    }
}
