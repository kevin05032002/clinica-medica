package clinica.dao;

import clinica.model.Medico;
import clinica.model.Especialidade;
import clinica.util.ConexaoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    public void inserir(Medico medico) {
        String sql = "INSERT INTO medicos (nome, crm, id_especialidade) VALUES (?, ?, ?)";

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
public int contarMedicos() {
    int total = 0;
    String sql = "SELECT COUNT(*) FROM medicos WHERE ativo = 1";  // Exemplo com filtro de ativo
    try (Connection con = ConexaoUtil.obterConexao();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
            total = rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return total;
}
    public void atualizar(Medico medico) {
        String sql = "UPDATE medicos SET nome = ?, crm = ?, id_especialidade = ? WHERE id = ?";

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
        String sql = "DELETE FROM medicos WHERE id = ?";

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
                     "FROM medicos m JOIN especialidades e ON m.id_especialidade = e.id WHERE m.id = ?";

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
                     "FROM medicos m JOIN especialidades e ON m.id_especialidade = e.id";

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
    
    public List<Medico> buscarPorNome(String nome) {
    List<Medico> lista = new ArrayList<>();

    String sql = "SELECT m.id, m.nome, m.crm, e.id AS id_especialidade, e.nome AS especialidade_nome "
               + "FROM medicos m "
               + "JOIN especialidades e ON m.especialidade_id = e.id "
               + "WHERE m.nome LIKE ?";

    try (Connection conn = ConexaoUtil.obterConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, "%" + nome + "%");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Especialidade especialidade = new Especialidade();
            especialidade.setId(rs.getInt("especialidade_id"));
            especialidade.setDescricao(rs.getString("especialidade_nome"));

            Medico medico = new Medico();
            medico.setId(rs.getInt("id"));
            medico.setNome(rs.getString("nome"));
            medico.setCrm(rs.getString("crm"));
            medico.setEspecialidade(especialidade);

            lista.add(medico);
        }
        rs.close();
    } catch (SQLException e) {
        e.printStackTrace(); // ou use JOptionPane.showMessageDialog(null, ...)
    }

    return lista;
}
}
