package clinica.dao;

import clinica.model.Paciente;
import clinica.util.ConexaoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public void inserir(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nome_completo, rg, cpf, data_nascimento, telefone, email, rua, numero, complemento, bairro, cidade, estado, cep) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNomeCompleto());
            stmt.setString(2, paciente.getRg());
            stmt.setString(3, paciente.getCpf());
            stmt.setString(4, paciente.getDataNascimento());
            stmt.setString(5, paciente.getTelefone());
            stmt.setString(6, paciente.getEmail());
            stmt.setString(7, paciente.getRua());
            stmt.setString(8, paciente.getNumero());
            stmt.setString(9, paciente.getComplemento());
            stmt.setString(10, paciente.getBairro());
            stmt.setString(11, paciente.getCidade());
            stmt.setString(12, paciente.getEstado());
            stmt.setString(13, paciente.getCep());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> buscarTodos() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";

        try (Connection conn = ConexaoUtil.obterConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNomeCompleto(rs.getString("nome_completo"));
                p.setRg(rs.getString("rg"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNascimento(rs.getString("data_nascimento"));
                p.setTelefone(rs.getString("telefone"));
                p.setEmail(rs.getString("email"));
                p.setRua(rs.getString("rua"));
                p.setNumero(rs.getString("numero"));
                p.setComplemento(rs.getString("complemento"));
                p.setBairro(rs.getString("bairro"));
                p.setCidade(rs.getString("cidade"));
                p.setEstado(rs.getString("estado"));
                p.setCep(rs.getString("cep"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(Paciente paciente) {
        String sql = "UPDATE pacientes SET nome_completo=?, rg=?, cpf=?, data_nascimento=?, telefone=?, email=?, rua=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, cep=? WHERE id=?";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNomeCompleto());
            stmt.setString(2, paciente.getRg());
            stmt.setString(3, paciente.getCpf());
            stmt.setString(4, paciente.getDataNascimento());
            stmt.setString(5, paciente.getTelefone());
            stmt.setString(6, paciente.getEmail());
            stmt.setString(7, paciente.getRua());
            stmt.setString(8, paciente.getNumero());
            stmt.setString(9, paciente.getComplemento());
            stmt.setString(10, paciente.getBairro());
            stmt.setString(11, paciente.getCidade());
            stmt.setString(12, paciente.getEstado());
            stmt.setString(13, paciente.getCep());
            stmt.setInt(14, paciente.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM pacientes WHERE id=?";

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Paciente buscarPorId(int id) {
        String sql = "SELECT * FROM pacientes WHERE id=?";
        Paciente p = null;

        try (Connection conn = ConexaoUtil.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNomeCompleto(rs.getString("nome_completo"));
                p.setRg(rs.getString("rg"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNascimento(rs.getString("data_nascimento"));
                p.setTelefone(rs.getString("telefone"));
                p.setEmail(rs.getString("email"));
                p.setRua(rs.getString("rua"));
                p.setNumero(rs.getString("numero"));
                p.setComplemento(rs.getString("complemento"));
                p.setBairro(rs.getString("bairro"));
                p.setCidade(rs.getString("cidade"));
                p.setEstado(rs.getString("estado"));
                p.setCep(rs.getString("cep"));
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }
}
