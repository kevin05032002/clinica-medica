package clinica.dao;

import clinica.model.Usuario;
import clinica.util.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean inserir(Usuario usuario) {
        String sql = "INSERT INTO usuarios (funcionario_id, login, senha, perfil) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getFuncionarioId());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getPerfil());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Usuario usuario) {
        String sql = "UPDATE usuarios SET funcionario_id = ?, login = ?, senha = ?, perfil = ? WHERE id = ?";
        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getFuncionarioId());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getPerfil());
            stmt.setInt(5, usuario.getId());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setFuncionarioId(rs.getInt("funcionario_id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPerfil(rs.getString("perfil"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
  public Usuario validarLogin(String login, String senha) {
    String sql = "SELECT * FROM usuarios WHERE usuario = ?";

    try (Connection conn = ConexaoUtil.obterConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, login);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String senhaBanco = rs.getString("senha");

            if (senhaBanco.equals(senha)) { // Comparação direta (sem hash)
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setFuncionarioId(rs.getInt("id_funcionario")); // nome correto no banco
                usuario.setLogin(rs.getString("usuario")); // nome da coluna no banco
                usuario.setSenha(senhaBanco);
                usuario.setPermissao(rs.getString("permissao")); // nome da coluna no banco
                return usuario;
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

}
