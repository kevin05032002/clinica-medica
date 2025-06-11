package clinica.dao;

import clinica.model.Prontuario;
import clinica.util.ConexaoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {

    public void inserir(Prontuario prontuario) throws SQLException {
        String sql = "INSERT INTO prontuarios (consulta_id, queixa_principal, historico_doenca, exame_fisico, diagnostico, conduta, data_registro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexaoUtil.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, prontuario.getConsultaId());
            stmt.setString(2, prontuario.getQueixaPrincipal());
            stmt.setString(3, prontuario.getHistoricoDoenca());
            stmt.setString(4, prontuario.getExameFisico());
            stmt.setString(5, prontuario.getDiagnostico());
            stmt.setString(6, prontuario.getConduta());
            stmt.setTimestamp(7, prontuario.getDataRegistro());

            stmt.executeUpdate();
        }
    }

    public void alterar(Prontuario prontuario) throws SQLException {
        String sql = "UPDATE prontuarios SET consulta_id = ?, queixa_principal = ?, historico_doenca = ?, exame_fisico = ?, diagnostico = ?, conduta = ?, data_registro = ? WHERE id = ?";
        try (Connection con = ConexaoUtil.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, prontuario.getConsultaId());
            stmt.setString(2, prontuario.getQueixaPrincipal());
            stmt.setString(3, prontuario.getHistoricoDoenca());
            stmt.setString(4, prontuario.getExameFisico());
            stmt.setString(5, prontuario.getDiagnostico());
            stmt.setString(6, prontuario.getConduta());
            stmt.setTimestamp(7, prontuario.getDataRegistro());
            stmt.setInt(8, prontuario.getId());

            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM prontuarios WHERE id = ?";
        try (Connection con = ConexaoUtil.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Prontuario buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM prontuarios WHERE id = ?";
        try (Connection con = ConexaoUtil.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Prontuario prontuario = new Prontuario();
                    prontuario.setId(rs.getInt("id"));
                    prontuario.setConsultaId(rs.getInt("consulta_id"));
                    prontuario.setQueixaPrincipal(rs.getString("queixa_principal"));
                    prontuario.setHistoricoDoenca(rs.getString("historico_doenca"));
                    prontuario.setExameFisico(rs.getString("exame_fisico"));
                    prontuario.setDiagnostico(rs.getString("diagnostico"));
                    prontuario.setConduta(rs.getString("conduta"));
                    prontuario.setDataRegistro(rs.getTimestamp("data_registro"));
                    return prontuario;
                }
            }
        }
        return null;
    }

    public List<Prontuario> buscarTodos() throws SQLException {
        List<Prontuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM prontuarios";
        try (Connection con = ConexaoUtil.obterConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Prontuario prontuario = new Prontuario();
                prontuario.setId(rs.getInt("id"));
                prontuario.setConsultaId(rs.getInt("consulta_id"));
                prontuario.setQueixaPrincipal(rs.getString("queixa_principal"));
                prontuario.setHistoricoDoenca(rs.getString("historico_doenca"));
                prontuario.setExameFisico(rs.getString("exame_fisico"));
                prontuario.setDiagnostico(rs.getString("diagnostico"));
                prontuario.setConduta(rs.getString("conduta"));
                prontuario.setDataRegistro(rs.getTimestamp("data_registro"));
                lista.add(prontuario);
            }
        }
        return lista;
    }
}
