package clinica.view;

import clinica.dao.UsuarioDAO;
import clinica.login.SessaoUsuario;
import clinica.model.Usuario;
import clinica.login.SessaoUsuario;

import javax.swing.*;
import java.awt.*;


public class EditarPerfil extends JFrame {

    private Usuario usuario;

    public EditarPerfil() {
        this(SessaoUsuario.getUsuarioLogado());
    }

    public EditarPerfil(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        preencherCampos();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Remover setUndecorated para manter barra título
    }

    private void preencherCampos() {
        if (usuario != null) {
            txtUsuario.setText(usuario.getLogin());
        }
    }

    
  
   
       
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblSenha = new javax.swing.JLabel();
        txtConfirmeSenha = new javax.swing.JPasswordField();
        lblConfirmar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnsSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Usuario");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        lblSenha.setText("Senha");

        lblConfirmar.setText("Confirme a Senha");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 254));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnsSalvar.setBackground(new java.awt.Color(255, 255, 254));
        btnsSalvar.setText("Salvar");
        btnsSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario)
                    .addComponent(txtSenha)
                    .addComponent(txtConfirmeSenha))
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnsSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmar))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(500, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
     dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnsSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsSalvarActionPerformed

    String login = txtUsuario.getText().trim();
    String senha = new String(txtSenha.getPassword());
    String confirmarSenha = new String(txtConfirmeSenha.getPassword());

    // Validações básicas
    if (login.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!senha.equals(confirmarSenha)) {
        JOptionPane.showMessageDialog(this, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Atualizar o usuário logado
    Usuario usuario = SessaoUsuario.getUsuarioLogado();
    if (usuario == null) {
        JOptionPane.showMessageDialog(this, "Usuário da sessão não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    usuario.setLogin(login);
    usuario.setSenha(senha); // Assumindo que é armazenada em texto plano ou já tratada

    UsuarioDAO dao = new UsuarioDAO();
    try {
        dao.alterar(usuario);
        JOptionPane.showMessageDialog(this, "Perfil atualizado com sucesso!");
        this.dispose(); // Fecha a tela
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar perfil: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_btnsSalvarActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnsSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtConfirmeSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
