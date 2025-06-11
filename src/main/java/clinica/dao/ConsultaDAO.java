package clinica.dao;

import clinica.model.Consulta;
import clinica.util.ConexaoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    public void inserir(Consulta consulta) {
        String sql = "INSERT INTO consultas (id_paciente, id_medico, data_consulta, horario, tipo, observacoes) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, consulta.getIdPaciente());
            stmt.setInt(2, consulta.getIdMedico());
            stmt.setString(3, consulta.getDataConsulta());
            stmt.setString(4, consulta.getHorario());
            stmt.setString(5, consulta.getTipo());
            stmt.setString(6, consulta.getObservacoes());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> buscarTodos() {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consultas";

        try (Connection conn = ConexaoUtil.obterConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setId(rs.getInt("id"));
                c.setIdPaciente(rs.getInt("id_paciente"));
                c.setIdMedico(rs.getInt("id_medico"));
                c.setDataConsulta(rs.getString("data_consulta"));
                c.setHorario(rs.getString("horario"));
                c.setTipo(rs.getString("tipo"));
                c.setObservacoes(rs.getString("observacoes"));
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(Consulta consulta) {
        String sql = "UPDATE consultas SET id_paciente=?, id_medico=?, data_consulta=?, horario=?, tipo=?, observacoes=? WHERE id=?";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, consulta.getIdPaciente());
            stmt.setInt(2, consulta.getIdMedico());
            stmt.setString(3, consulta.getDataConsulta());
            stmt.setString(4, consulta.getHorario());
            stmt.setString(5, consulta.getTipo());
            stmt.setString(6, consulta.getObservacoes());
            stmt.setInt(7, consulta.getId());

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
        Consulta c = null;
        String sql = "SELECT * FROM consultas WHERE id=?";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                c = new Consulta();
                c.setId(rs.getInt("id"));
                c.setIdPaciente(rs.getInt("id_paciente"));
                c.setIdMedico(rs.getInt("id_medico"));
                c.setDataConsulta(rs.getString("data_consulta"));
                c.setHorario(rs.getString("horario"));
                c.setTipo(rs.getString("tipo"));
                c.setObservacoes(rs.getString("observacoes"));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }
}

