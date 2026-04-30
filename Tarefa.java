import java.io.Serializable;

/**
 * Classe que representa o modelo de uma Tarefa no sistema.
 */
public class Tarefa implements Serializable {
    private int id;
    private String titulo;
    private String descricao;
    private String status;

    public Tarefa(int id, String titulo, String descricao, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Converte a tarefa para um formato legível para exibição.
     */
    @Override
    public String toString() {
        return String.format("[%d] %s - %s (Status: %s)", id, titulo, descricao, status);
    }

    /**
     * Converte a tarefa para uma linha CSV (usando ponto e vírgula como separador).
     */
    public String toCSV() {
        // Substituindo possíveis ponto-e-vírgulas nos textos para evitar quebrar o CSV
        String tituloLimpo = titulo.replace(";", ",");
        String descricaoLimpa = descricao.replace(";", ",");
        return id + ";" + tituloLimpo + ";" + descricaoLimpa + ";" + status;
    }

    /**
     * Cria uma instância de Tarefa a partir de uma linha CSV.
     */
    public static Tarefa fromCSV(String csvLine) {
        String[] partes = csvLine.split(";");
        if (partes.length == 4) {
            try {
                int id = Integer.parseInt(partes[0]);
                return new Tarefa(id, partes[1], partes[2], partes[3]);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}
