package clinica.dao;

import clinica.model.Consulta;
import clinica.model.Paciente;
import clinica.model.Medico;
import clinica.model.Convenio;
import clinica.util.ConexaoUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    public void inserir(Consulta consulta) {
    String sql = "INSERT INTO consultas (paciente_id, medico_id, convenio_id, data_consulta, horario, tipo, observacoes) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = ConexaoUtil.obterConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, consulta.getPaciente().getId());
        stmt.setInt(2, consulta.getMedico().getId());

        if (consulta.getConvenio() != null) {
            System.out.println("Convenio ID: " + consulta.getConvenio().getId());
            stmt.setInt(3, consulta.getConvenio().getId());
        } else {
            System.out.println("Convenio é null");
            stmt.setNull(3, Types.INTEGER);
        }
        stmt.setDate(4, Date.valueOf(consulta.getData()));
        stmt.setTime(5, Time.valueOf(consulta.getHora()));
        stmt.setString(6, consulta.getTipo());
        stmt.setString(7, consulta.getObservacoes());

        System.out.println("Data: " + consulta.getData());
        System.out.println("Hora: " + consulta.getHora());
        System.out.println("Tipo: " + consulta.getTipo());
        System.out.println("Obs: " + consulta.getObservacoes());

        int linhas = stmt.executeUpdate();
        System.out.println("Linhas inseridas: " + linhas);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public void atualizar(Consulta consulta) {
        String sql = "UPDATE consultas SET paciente_id=?, medico_id=?, convenio_id=?, data_consulta=?, horario=?, tipo=?, observacoes=? WHERE id=?";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, consulta.getPaciente().getId());
            stmt.setInt(2, consulta.getMedico().getId());

            if (consulta.getConvenio() != null) {
                stmt.setInt(3, consulta.getConvenio().getId());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            stmt.setDate(4, Date.valueOf(consulta.getData()));
            stmt.setTime(5, Time.valueOf(consulta.getHora()));
            stmt.setString(6, consulta.getTipo());
            stmt.setString(7, consulta.getObservacoes());
            stmt.setInt(8, consulta.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM consultas WHERE id=?";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Consulta buscarPorId(int id) {
        String sql = "SELECT * FROM consultas WHERE id=?";
        Consulta consulta = null;

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    consulta = mapearConsulta(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return consulta;
    }

    public List<Consulta> buscarTodos() {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consultas";

        try (Connection conn = ConexaoUtil.obterConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Consulta consulta = mapearConsulta(rs);
                lista.add(consulta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método auxiliar para mapear ResultSet para Consulta
    private Consulta mapearConsulta(ResultSet rs) throws SQLException {
        Consulta consulta = new Consulta();

        consulta.setId(rs.getInt("id"));

        int pacienteId = rs.getInt("paciente_id");
        int medicoId = rs.getInt("medico_id");
        int convenioId = rs.getInt("convenio_id");

        // Buscar os objetos relacionados usando os DAOs
        Paciente paciente = new PacienteDAO().buscarPorId(pacienteId);
        Medico medico = new MedicoDAO().buscarPorId(medicoId);

        Convenio convenio = null;
        if (!rs.wasNull() && convenioId > 0) {
            convenio = new ConvenioDAO().buscarPorId(convenioId);
        }

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setConvenio(convenio);

        consulta.setData(rs.getDate("data_consulta").toLocalDate());
        consulta.setHora(rs.getTime("horario").toLocalTime());
        consulta.setTipo(rs.getString("tipo"));
        consulta.setObservacoes(rs.getString("observacoes"));

        return consulta;
    }
}