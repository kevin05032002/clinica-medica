package clinica.view;

import clinica.dao.UsuarioDAO;
import clinica.model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListarUsuario extends javax.swing.JFrame {

   public ListarUsuario() {
    initComponents();
    setLocationRelativeTo(null); // centraliza a janela
}



    private void buscarUsuario() {
        String login = txtLogin.getText().trim();
        if (login.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite um login para buscar.");
            return;
        }

        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.buscarPorLogin(login);
        atualizarTabela(usuarios);
    }

    private void listarTodosUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.buscarTodos();
        atualizarTabela(usuarios);
    }

    private void EditarUsuario() {
        int linhaSelecionada = tableUsuarios.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int id = (int) tableUsuarios.getValueAt(linhaSelecionada, 0);
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.buscarPorId(id);

            if (usuario != null) {
                EditarUsuario editar = new EditarUsuario(usuario);
                editar.setVisible(true);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para editar.");
        }
    }

    private void deletar() {
        int linhaSelecionada = tableUsuarios.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int id = (int) tableUsuarios.getValueAt(linhaSelecionada, 0);
            int confirmacao = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja excluir este usuário?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                UsuarioDAO dao = new UsuarioDAO();
                boolean sucesso = dao.deletar(id);
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso.");
                    listarTodosUsuarios();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir o usuário.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir.");
        }
    }

    private void atualizarTabela(List<Usuario> usuarios) {
        DefaultTableModel model = (DefaultTableModel) tableUsuarios.getModel();
        model.setRowCount(0); // limpa

        for (Usuario u : usuarios) {
            model.addRow(new Object[]{u.getId(), u.getLogin(), u.getPermissao()});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        btnListarTodos = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setText("Usuario");

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
        btnListarTodos.setText("Listar Todos");
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
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

        btnEditar.setBackground(new java.awt.Color(0, 0, 0));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tableUsuarios.setBackground(new java.awt.Color(0, 0, 0));
        tableUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Usuario", "Permissao"
            }
        ));
        jScrollPane1.setViewportView(tableUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscar)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addGap(7, 7, 7))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(919, 492));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
 int linha = tableUsuarios.getSelectedRow();
    if (linha >= 0) {
        int id = (int) tableUsuarios.getValueAt(linha, 0); // ID está na primeira coluna
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.buscarPorId(id);

        if (usuario != null) {
            EditarUsuario editar = new EditarUsuario(usuario);
            editar.setLocationRelativeTo(null); // opcional, centraliza
            editar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao carregar usuário.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um usuário na tabela.");
    }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    String login = txtLogin.getText().trim();

    if (login.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Digite um login para buscar.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
    }

    UsuarioDAO dao = new UsuarioDAO();
    List<Usuario> usuarios = dao.buscarPorLogin(login);

    if (usuarios.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nenhum usuário encontrado com esse login.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    carregarTabela(usuarios);
       // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosActionPerformed
  
    UsuarioDAO dao = new UsuarioDAO();
    List<Usuario> usuarios = dao.buscarTodos();
    carregarTabela(usuarios);
       // TODO add your handling code here:
    }//GEN-LAST:event_btnListarTodosActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       
    int linhaSelecionada = tableUsuarios.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o usuário selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);

    if (confirmacao == JOptionPane.YES_OPTION) {
        int id = (int) tableUsuarios.getValueAt(linhaSelecionada, 0); // Supondo que a primeira coluna seja o ID

        UsuarioDAO dao = new UsuarioDAO();
        dao.deletar(id);

        // Atualiza tabela
        List<Usuario> usuarios = dao.buscarTodos();
        carregarTabela(usuarios);
    }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

    this.dispose(); // Fecha apenas esta janela
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    private void carregarTabela(List<Usuario> usuarios) {
    DefaultTableModel modelo = (DefaultTableModel) tableUsuarios.getModel();
    modelo.setRowCount(0);

    for (Usuario u : usuarios) {
        modelo.addRow(new Object[]{
            u.getId(),
            u.getLogin(),
            u.getPermissao(),
            u.getFuncionarioId()
        });
    }
}

    
 





 public class TesteListarUsuarios {
    public static void main(String[] args) {
        // Garante aparência nativa do sistema operacional
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Executa a janela na thread da interface gráfica
        SwingUtilities.invokeLater(() -> {
            new ListarUsuario().setVisible(true);
        });
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
