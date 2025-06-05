package clinica.main;
import clinica.dao.FuncionarioDAO;
public class mainClass {
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        int idParaDeletar = 1; // coloque aqui o ID do funcionário que quer apagar
        
        boolean sucesso = funcionarioDAO.deletar(idParaDeletar);
        
        if (sucesso) {
            System.out.println("✅ Funcionário com ID " + idParaDeletar + " deletado com sucesso!");
        } else {
            System.out.println("❌ Falha ao deletar funcionário com ID " + idParaDeletar + ".");
        }
    }
}