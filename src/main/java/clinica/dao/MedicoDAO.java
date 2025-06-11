package clinica.dao;

import clinica.model.Medico;
import clinica.model.Especialidade;
import clinica.util.ConexaoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    public void inserir(Medico medico) {
        String sql = "INSERT INTO medico (nome, crm, id_especialidade) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setInt(3, medico.getEspecialidade().getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir médico: " + ex.getMessage(), ex);
        }
    }

    public void atualizar(Medico medico) {
        String sql = "UPDATE medico SET nome = ?, crm = ?, id_especialidade = ? WHERE id = ?";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setInt(3, medico.getEspecialidade().getId());
            stmt.setInt(4, medico.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar médico: " + ex.getMessage(), ex);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM medico WHERE id = ?";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir médico: " + ex.getMessage(), ex);
        }
    }

    public Medico buscarPorId(int id) {
        String sql = "SELECT m.id, m.nome, m.crm, e.id AS esp_id, e.descricao " +
                     "FROM medico m JOIN especialidade e ON m.id_especialidade = e.id WHERE m.id = ?";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Especialidade esp = new Especialidade(rs.getInt("esp_id"), rs.getString("descricao"));
                    return new Medico(rs.getInt("id"), rs.getString("nome"), rs.getString("crm"), esp);
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar médico por ID: " + ex.getMessage(), ex);
        }
        return null;
    }

    public List<Medico> buscarTodos() {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT m.id, m.nome, m.crm, e.id AS esp_id, e.descricao " +
                     "FROM medico m JOIN especialidade e ON m.id_especialidade = e.id";

        try (Connection conn = ConexaoUtil.obterConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Especialidade esp = new Especialidade(rs.getInt("esp_id"), rs.getString("descricao"));
                Medico medico = new Medico(rs.getInt("id"), rs.getString("nome"), rs.getString("crm"), esp);
                lista.add(medico);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar médicos: " + ex.getMessage(), ex);
        }

        return lista;
    }
}
