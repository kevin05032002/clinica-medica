

package clinica.view;
import clinica.model.Usuario;
import clinica.view.TelaFuncionario;
import clinica.login.SessaoUsuario;


  

  
public class MenuAdministrador extends javax.swing.JFrame {

    private Usuario usuario;

    public MenuAdministrador(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
    }

    public MenuAdministrador() {
        initComponents();
        this.usuario = null; // ou crie um usuário padrão, se necessário
    }

    // resto do código...


   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Funcionario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Agendamento = new javax.swing.JButton();
        Especialidade = new javax.swing.JButton();
        Usuario = new javax.swing.JButton();
        Medico = new javax.swing.JButton();
        Paciente = new javax.swing.JButton();
        Convenio = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        menuPerfil = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Funcionario.setBackground(new java.awt.Color(103, 229, 186));
        Funcionario.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Funcionario.setText("Cadastrar Funcionario");
        Funcionario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncionarioActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(103, 229, 186));
        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton1.setText("Listar Funcionarios");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(103, 229, 186));
        jButton2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton2.setText("Listar Especialidade");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(103, 229, 186));
        jButton3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton3.setText("Listar Usuario");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setBackground(new java.awt.Color(103, 229, 186));
        jButton4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton4.setText("Listar Medicos");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton5.setBackground(new java.awt.Color(103, 229, 186));
        jButton5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton5.setText("Listar Convênios");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Agendamento.setBackground(new java.awt.Color(103, 229, 186));
        Agendamento.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Agendamento.setText("Ver Agendamentos");
        Agendamento.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        Especialidade.setBackground(new java.awt.Color(103, 229, 186));
        Especialidade.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Especialidade.setText("Cadastrar Especialidades");
        Especialidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Especialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EspecialidadeActionPerformed(evt);
            }
        });

        Usuario.setBackground(new java.awt.Color(103, 229, 186));
        Usuario.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Usuario.setText("Cadastrar Usuario");
        Usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });

        Medico.setBackground(new java.awt.Color(103, 229, 186));
        Medico.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Medico.setText("Cadastrar Médicos");
        Medico.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedicoActionPerformed(evt);
            }
        });

        Paciente.setBackground(new java.awt.Color(103, 229, 186));
        Paciente.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Paciente.setText("Consultar Pacientes");
        Paciente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Convenio.setBackground(new java.awt.Color(103, 229, 186));
        Convenio.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Convenio.setText("Cadastrar Convênios");
        Convenio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(103, 229, 186));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Pictures\\download.jpeg")); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Especialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medico, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Convenio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 615, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Funcionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Especialidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Medico, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Convenio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Paciente)
                .addContainerGap(310, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu4.setBorder(null);
        jMenu4.setText("Perfil");
        jMenu4.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu4MenuSelected(evt);
            }
        });

        menuPerfil.setText("Editar Perfil");
        menuPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPerfilActionPerformed(evt);
            }
        });
        jMenu4.add(menuPerfil);

        jMenuBar2.add(jMenu4);

        btnSair.setText("Sitema");

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        btnSair.add(menuSair);

        jMenuBar2.add(btnSair);

        setJMenuBar(jMenuBar2);

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

        setSize(new java.awt.Dimension(1280, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FuncionarioActionPerformed
      
  TelaFuncionario telaFuncionario = new TelaFuncionario();
    telaFuncionario.setVisible(true);
    telaFuncionario.setLocationRelativeTo(null);
// TODO add your handling code here:
    }//GEN-LAST:event_FuncionarioActionPerformed

    private void EspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EspecialidadeActionPerformed
      
        CadastroEspecialidade telaCadastro = new CadastroEspecialidade();
        telaCadastro.setVisible(true);
        telaCadastro.setLocationRelativeTo(null); // para centralizar a janela
    
    }//GEN-LAST:event_EspecialidadeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void MedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedicoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarTodos buscarTodosTela = new BuscarTodos();
    buscarTodosTela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         ListarEspecialidade telaListar = new ListarEspecialidade();
        telaListar.setVisible(true);
        telaListar.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu4MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu4MenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4MenuSelected

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
      System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPerfilActionPerformed
   
   EditarPerfil ep = new EditarPerfil(usuario);
    ep.setVisible(true);
    }//GEN-LAST:event_menuPerfilActionPerformed

    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        CadastroUsuario TelaCadastroUsuario = new CadastroUsuario();
        TelaCadastroUsuario.setVisible(true);
        TelaCadastroUsuario.setLocationRelativeTo(null);
    }//GEN-LAST:event_UsuarioActionPerformed

     public static void main(String args[]) {
        Usuario usuarioLogado = new Usuario(); // ou receba de outro lugar, como da tela de login

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador(usuarioLogado).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agendamento;
    private javax.swing.JButton Convenio;
    private javax.swing.JButton Especialidade;
    private javax.swing.JButton Funcionario;
    private javax.swing.JButton Medico;
    private javax.swing.JButton Paciente;
    private javax.swing.JButton Usuario;
    private javax.swing.JMenu btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem menuPerfil;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables
}
