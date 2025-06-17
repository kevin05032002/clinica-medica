package clinica.model;

public class Especialidade {
    private int id;
    private String descricao;
    
    public Especialidade() {}

    public Especialidade( String descricao) {
        this.descricao = descricao;
    }

    public Especialidade(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;}
    public void setDescricao(String descricao) {
        this.descricao = descricao;}
    
    public String toString() {
    return descricao;
}
}

