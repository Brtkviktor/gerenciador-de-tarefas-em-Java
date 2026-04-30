import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por gerenciar a lógica de negócios (CRUD) das tarefas.
 */
public class GerenciadorTarefas {
    private List<Tarefa> tarefas;
    private int proximoId;
    private final String ARQUIVO_DADOS = "tarefas.csv"; // Arquivo de persistência

    public GerenciadorTarefas() {
        this.tarefas = new ArrayList<>();
        this.proximoId = 1;
        carregarDoArquivo(); // Tenta carregar dados existentes ao iniciar
    }

    /**
     * Adiciona uma nova tarefa ao sistema.
     */
    public void adicionarTarefa(String titulo, String descricao, String status) {
        Tarefa novaTarefa = new Tarefa(proximoId++, titulo, descricao, status);
        tarefas.add(novaTarefa);
        salvarEmArquivo(); // Salva estado atualizado
        System.out.println("Tarefa adicionada com sucesso! ID: " + novaTarefa.getId());
    }

    /**
     * Lista todas as tarefas cadastradas.
     */
    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada no momento.");
            return;
        }
        for (Tarefa t : tarefas) {
            System.out.println(t);
        }
    }

    /**
     * Lista tarefas filtrando pelo status especificado.
     */
    public void listarTarefasPorStatus(String status) {
        List<Tarefa> filtradas = tarefas.stream()
                .filter(t -> t.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());

        if (filtradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada com o status '" + status + "'.");
            return;
        }
        for (Tarefa t : filtradas) {
            System.out.println(t);
        }
    }

    /**
     * Atualiza os dados de uma tarefa existente.
     */
    public void atualizarTarefa(int id, String titulo, String descricao, String status) {
        Tarefa tarefa = buscarTarefa(id);
        if (tarefa != null) {
            // Apenas atualiza os campos se a string não for vazia
            if (titulo != null && !titulo.trim().isEmpty()) {
                tarefa.setTitulo(titulo);
            }
            if (descricao != null && !descricao.trim().isEmpty()) {
                tarefa.setDescricao(descricao);
            }
            if (status != null && !status.trim().isEmpty()) {
                tarefa.setStatus(status);
            }
            salvarEmArquivo(); // Persiste alteração
            System.out.println("Tarefa atualizada com sucesso!");
        } else {
            System.out.println("Erro: Tarefa com ID " + id + " não foi encontrada.");
        }
    }

    /**
     * Remove uma tarefa pelo seu ID.
     */
    public void removerTarefa(int id) {
        Tarefa tarefa = buscarTarefa(id);
        if (tarefa != null) {
            tarefas.remove(tarefa);
            salvarEmArquivo(); // Persiste alteração
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Erro: Tarefa com ID " + id + " não foi encontrada.");
        }
    }

    /**
     * Método auxiliar para buscar uma tarefa pelo ID.
     */
    private Tarefa buscarTarefa(int id) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    /**
     * Salva a lista atual de tarefas no arquivo CSV.
     */
    private void salvarEmArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_DADOS))) {
            for (Tarefa t : tarefas) {
                bw.write(t.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas no arquivo: " + e.getMessage());
        }
    }

    /**
     * Carrega as tarefas do arquivo CSV para a memória.
     */
    private void carregarDoArquivo() {
        File arquivo = new File(ARQUIVO_DADOS);
        if (!arquivo.exists()) {
            return; // Se o arquivo não existir, inicia vazio
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int maxId = 0;
            while ((linha = br.readLine()) != null) {
                Tarefa t = Tarefa.fromCSV(linha);
                if (t != null) {
                    tarefas.add(t);
                    if (t.getId() > maxId) {
                        maxId = t.getId();
                    }
                }
            }
            // Ajusta o próximo ID baseado no maior ID carregado
            proximoId = maxId + 1;
        } catch (IOException e) {
            System.out.println("Erro ao carregar tarefas do arquivo: " + e.getMessage());
        }
    }
}
