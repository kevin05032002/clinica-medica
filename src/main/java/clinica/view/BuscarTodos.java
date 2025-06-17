package clinica.view;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import clinica.dao.FuncionarioDAO;
import clinica.model.Funcionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BuscarTodos extends javax.swing.JFrame {

    private CadastroUsuario telaCadastroUsuario;
    private boolean modoSelecao = false;
    private Funcionario funcionarioSelecionado;

    public BuscarTodos() {
        initComponents();
        carregarFuncionarios();
        btnSelecionar.setVisible(false); // Oculta o botão por padrão
    }

    public BuscarTodos(CadastroUsuario telaCadastroUsuario) {
        this();
        this.telaCadastroUsuario = telaCadastroUsuario;
        this.modoSelecao = true;
        btnSelecionar.setVisible(true);
    }

    public Funcionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    private void carregarFuncionarios() {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.buscarTodos();
        carregarTabela(lista);
    }

    private void carregarTabela(List<Funcionario> funcionarios) {
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNomeCompleto));

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nome Completo");
        modelo.addColumn("RG");
        modelo.addColumn("CPF");
        modelo.addColumn("Rua");
        modelo.addColumn("Número");
        modelo.addColumn("Complemento");
        modelo.addColumn("Bairro");
        modelo.addColumn("Cidade");
        modelo.addColumn("Estado");
        modelo.addColumn("CEP");
        modelo.addColumn("Telefone Fixo");
        modelo.addColumn("Telefone Celular");
        modelo.addColumn("CTPS");
        modelo.addColumn("PIS");

        for (Funcionario f : funcionarios) {
            modelo.addRow(new Object[]{
                f.getId(),
                f.getNomeCompleto(),
                f.getRg(),
                f.getCpf(),
                f.getRua(),
                f.getNumero(),
                f.getComplemento(),
                f.getBairro(),
                f.getCidade(),
                f.getEstado(),
                f.getCep(),
                f.getTelefoneFixo(),
                f.getTelefoneCelular(),
                f.getCtps(),
                f.getPis()
            });
        }

        tabelaFuncionarios.setModel(modelo);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TextCPF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setText("CPF");

        btnBuscar.setBackground(new java.awt.Color(0, 0, 0));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnListarTodos.setBackground(new java.awt.Color(0, 0, 0));
        btnListarTodos.setForeground(new java.awt.Color(255, 255, 255));
        btnListarTodos.setText("Listar todos");
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(0, 0, 0));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(0, 0, 0));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        tabelaFuncionarios.setBackground(new java.awt.Color(0, 0, 0));
        tabelaFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Funcionarios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionarios);

        btnSelecionar.setBackground(new java.awt.Color(0, 0, 0));
        btnSelecionar.setForeground(new java.awt.Color(255, 255, 255));
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("Buscar Funcionario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnListarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelecionar)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 575, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addGap(2, 2, 2))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1292, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosActionPerformed

    FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.buscarTodos();
        carregarTabela(lista);
    
    }//GEN-LAST:event_btnListarTodosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

       String cpf = TextCPF.getText().trim();
    if (!cpf.isEmpty()) {
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario funcionario = dao.buscarPorCpf(cpf);
        if (funcionario != null) {
            List<Funcionario> lista = new ArrayList<>();
            lista.add(funcionario);
            carregarTabela(lista);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Funcionário não encontrado.");
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Digite um CPF.");
}
    
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        
        int linhaSelecionada = tabelaFuncionarios.getSelectedRow();

    if (linhaSelecionada != -1) {
        // Pegue o ID da primeira coluna da tabela (ajuste o índice da coluna se necessário)
        int idFuncionario = (int) tabelaFuncionarios.getValueAt(linhaSelecionada, 0);

        EditarFuncionario telaEditar = new EditarFuncionario(idFuncionario);
telaEditar.setVisible(true);

        telaEditar.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        // Atualizar a tabela após fechamento
        FuncionarioDAO dao = new FuncionarioDAO();
        carregarTabela(dao.buscarTodos());
    }
});

        // Opcional: fechar a tela atual ou atualizar a lista após editar
        // this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um funcionário para editar.");
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

    this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
      int linhaSelecionada = tabelaFuncionarios.getSelectedRow();

    if (linhaSelecionada != -1) {
        int confirmacao = JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja excluir este funcionário?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            int idFuncionario = (int) tabelaFuncionarios.getValueAt(linhaSelecionada, 0);

            FuncionarioDAO dao = new FuncionarioDAO();
            boolean sucesso = dao.deletar(idFuncionario);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
                // Atualiza a tabela após a exclusão
                List<Funcionario> listaAtualizada = dao.buscarTodos();
                carregarTabela(listaAtualizada);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir funcionário.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um funcionário para excluir.");
    }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
   int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário na tabela.");
            return;
        }

        try {
            int id = (int) tabelaFuncionarios.getValueAt(linhaSelecionada, 0);
            FuncionarioDAO dao = new FuncionarioDAO();
            Funcionario funcionario = dao.buscarPorId(id);

            if (funcionario != null && telaCadastroUsuario != null) {
                telaCadastroUsuario.definirFuncionarioSelecionado(funcionario);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Funcionário não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao selecionar funcionário: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSelecionarActionPerformed

      public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new BuscarTodos().setVisible(true));
    
}

  
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextCPF;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaFuncionarios;
    // End of variables declaration//GEN-END:variables

    

}
