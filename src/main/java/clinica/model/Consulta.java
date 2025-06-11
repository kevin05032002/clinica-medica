package clinica.model;

public class Consulta {
    private int id;
    private int idPaciente;
    private int idMedico;
    private String dataConsulta;
    private String horario;
    private String tipo;          // no lugar de tipoConsulta
    private String observacoes;   // no lugar de status, agora tem o significado de observações mesmo

    public Consulta() {}

    public Consulta(int id, int idPaciente, int idMedico, String dataConsulta, String horario, String tipo, String observacoes) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.tipo = tipo;
        this.observacoes = observacoes;
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }

    public int getIdMedico() { return idMedico; }
    public void setIdMedico(int idMedico) { this.idMedico = idMedico; }

    public String getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(String dataConsulta) { this.dataConsulta = dataConsulta; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}

