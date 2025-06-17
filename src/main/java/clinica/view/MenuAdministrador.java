

package clinica.view;
import clinica.dao.EspecialidadeDAO;
import clinica.dao.FuncionarioDAO;
import clinica.dao.MedicoDAO;
import clinica.dao.UsuarioDAO;
import clinica.model.Usuario;
import clinica.view.TelaFuncionario;
import clinica.login.SessaoUsuario;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

  

  
public class MenuAdministrador extends javax.swing.JFrame {

    private Usuario usuario;
private FuncionarioDAO funcionarioDAO;
    private UsuarioDAO usuarioDAO;
    private EspecialidadeDAO especialidadeDAO;
    private MedicoDAO medicoDAO;
    
    public MenuAdministrador(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        if (usuario != null) {
        lblBoasVindas.setText("Bem-vindo, " + usuario.getLogin() + "!");
}   
        
      funcionarioDAO = new FuncionarioDAO();
        usuarioDAO = new UsuarioDAO();
        especialidadeDAO = new EspecialidadeDAO();
        medicoDAO = new MedicoDAO();

        // Carrega os contadores iniciais ao abrir a tela
        atualizarContadores();

        // Timer para atualizar a data e hora
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataHora = LocalDateTime.now().format(formatter);
            lblDataHora.setText("" + dataHora);
        });
        timer.start();
    }
    public MenuAdministrador() {
        initComponents();
        this.usuario = null; // ou crie um usuário padrão, se necessário
        // Inicializa os DAOs também no construtor sem usuário, se for usado
        funcionarioDAO = new FuncionarioDAO();
        usuarioDAO = new UsuarioDAO();
        especialidadeDAO = new EspecialidadeDAO();
        medicoDAO = new MedicoDAO();
        atualizarContadores(); // Carrega contadores mesmo sem usuário logado
    }

    /**
     * Método para atualizar os JLabels com os totais de funcionários, usuários,
     * especialidades e médicos.
     * Este método deve ser chamado sempre que houver uma alteração nos dados.
     */
    public void atualizarContadores() {
        try {
            lblTotalFuncionarios.setText(String.valueOf(funcionarioDAO.contarFuncionarios()));
            lblTotalUsuarios.setText(String.valueOf(usuarioDAO.contarUsuarios()));
            lblTotalEspecialidades.setText(String.valueOf(especialidadeDAO.contarEspecialidades()));
            lblTotalMedicos.setText(String.valueOf(medicoDAO.contarMedicos()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar contadores: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para depuração
        }
    }
    

  
    // resto do código...


   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBoasVindas = new javax.swing.JLabel();
        lblDataHora = new javax.swing.JLabel();
        panelFuncionarios = new javax.swing.JPanel();
        lblTotalFuncionarios = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalUsuarios = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalEspecialidades = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalMedicos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuFuncionario = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuEspecialidade = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuPerfil = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBoasVindas.setBackground(new java.awt.Color(204, 255, 204));
        lblBoasVindas.setFont(new java.awt.Font("Segoe UI Light", 3, 24)); // NOI18N
        lblBoasVindas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBoasVindas.setText("Carregando...");
        jPanel1.add(lblBoasVindas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1490, -1));

        lblDataHora.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        lblDataHora.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDataHora.setText("Carregando...........");
        jPanel1.add(lblDataHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 740, 1230, 30));

        panelFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        panelFuncionarios.setLayout(null);

        lblTotalFuncionarios.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        lblTotalFuncionarios.setText("Funcionarios");
        panelFuncionarios.add(lblTotalFuncionarios);
        lblTotalFuncionarios.setBounds(331, 36, 120, 27);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel1.setText("Total Funcionarios :");
        panelFuncionarios.add(jLabel1);
        jLabel1.setBounds(145, 36, 186, 27);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Desktop\\Usuario.png")); // NOI18N
        panelFuncionarios.add(jLabel4);
        jLabel4.setBounds(451, 25, 50, 50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel3.setText("Total Usuario:");
        panelFuncionarios.add(jLabel3);
        jLabel3.setBounds(501, 36, 133, 27);

        lblTotalUsuarios.setFont(new java.awt.Font("Segoe UI Emoji", 3, 24)); // NOI18N
        lblTotalUsuarios.setText("Usuarios");
        panelFuncionarios.add(lblTotalUsuarios);
        lblTotalUsuarios.setBounds(630, 40, 96, 27);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Desktop\\estetoscópio.png")); // NOI18N
        panelFuncionarios.add(jLabel5);
        jLabel5.setBounds(731, 25, 50, 50);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel6.setText("Total Especialidade:");
        panelFuncionarios.add(jLabel6);
        jLabel6.setBounds(781, 36, 189, 27);

        lblTotalEspecialidades.setFont(new java.awt.Font("Segoe UI Emoji", 3, 24)); // NOI18N
        lblTotalEspecialidades.setText("Especialidade");
        panelFuncionarios.add(lblTotalEspecialidades);
        lblTotalEspecialidades.setBounds(970, 40, 153, 27);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Desktop\\Medico.png")); // NOI18N
        panelFuncionarios.add(jLabel8);
        jLabel8.setBounds(1123, 25, 50, 50);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel7.setText("Total Medicos:");
        panelFuncionarios.add(jLabel7);
        jLabel7.setBounds(1173, 36, 136, 27);

        lblTotalMedicos.setFont(new java.awt.Font("Segoe UI Emoji", 3, 24)); // NOI18N
        lblTotalMedicos.setText("Medicos");
        panelFuncionarios.add(lblTotalMedicos);
        lblTotalMedicos.setBounds(1310, 40, 95, 27);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Desktop\\Funcionario.png")); // NOI18N
        panelFuncionarios.add(jLabel2);
        jLabel2.setBounds(95, 25, 50, 50);

        jPanel1.add(panelFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1510, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1500, 800));

        jButton2.setBackground(new java.awt.Color(255, 255, 254));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Desktop\\imagens\\Funcionario.png")); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setBackground(new java.awt.Color(255, 255, 254));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Desktop\\imagens\\Paciente.png")); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel2.add(jButton3);

        jButton1.setBackground(new java.awt.Color(255, 255, 254));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Desktop\\imagens\\Agenda.png")); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton4.setBackground(new java.awt.Color(255, 255, 254));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Desktop\\imagens\\Siatema.png")); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1500, 90));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuário\\Pictures\\Vaidacerto.jpg")); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(1, 1390));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1510, 780));

        jMenuBar2.setBackground(new java.awt.Color(255, 255, 254));
        jMenuBar2.setBorder(null);

        menuFuncionario.setText("Funcionario");

        jMenuItem1.setText("Cadastra Funcionario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuFuncionario.add(jMenuItem1);

        jMenuItem2.setText("Listar Funcionario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuFuncionario.add(jMenuItem2);

        jMenuBar2.add(menuFuncionario);

        menuEspecialidade.setText("Especialidades");

        jMenuItem3.setText("Cadastro Especialidade");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuEspecialidade.add(jMenuItem3);

        jMenuItem4.setText("Listar Especialidade");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuEspecialidade.add(jMenuItem4);

        jMenuBar2.add(menuEspecialidade);

        menuUsuario.setText("Usuario");

        jMenuItem5.setText("Cadastrar Usuario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuUsuario.add(jMenuItem5);

        jMenuItem6.setText("Listar Usuarios");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuUsuario.add(jMenuItem6);

        jMenuBar2.add(menuUsuario);

        jMenu3.setText("Medico");

        jMenuItem7.setText("Cadastrar Medico");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Listar Medicos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar2.add(jMenu3);

        jMenu1.setText("Convênios");

        jMenuItem9.setText("Cadastrar Convênios");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("Listar Convênios");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuBar2.add(jMenu1);

        jMenu2.setText("Agendamentos ");

        jMenuItem11.setText("Listar Agendamentos");
        jMenu2.add(jMenuItem11);

        jMenuBar2.add(jMenu2);

        jMenu5.setText("Paciente");

        jMenuItem12.setText("Consultar Paciente");
        jMenu5.add(jMenuItem12);

        jMenuBar2.add(jMenu5);

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

        btnSair.setText("Sistema");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1506, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu4MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu4MenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4MenuSelected

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
      System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPerfilActionPerformed
   
   EditarPerfil ep = new EditarPerfil();
    ep.setVisible(true);
    }//GEN-LAST:event_menuPerfilActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    TelaFuncionario TelaFuncionarioTela = new TelaFuncionario();
   TelaFuncionarioTela.setVisible(true); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    BuscarTodos buscarTodosTela = new BuscarTodos();
    buscarTodosTela.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
 CadastroEspecialidade telaCadastro = new CadastroEspecialidade();
        telaCadastro.setVisible(true);
        telaCadastro.setLocationRelativeTo(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
 ListarEspecialidade telaListar = new ListarEspecialidade();
        telaListar.setVisible(true);
        telaListar.setLocationRelativeTo(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
 CadastroUsuario TelaCadastroUsuario = new CadastroUsuario();
        TelaCadastroUsuario.setVisible(true);
        TelaCadastroUsuario.setLocationRelativeTo(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
 new ListarUsuario().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        TelaFuncionario TelaFuncionarioTela = new TelaFuncionario();
   TelaFuncionarioTela.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 EditarPerfil ep = new EditarPerfil();
    ep.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
CadastroMedico tela = new CadastroMedico();
tela.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
EditarMedico tela = new EditarMedico();
tela.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
CadastrarConvenio tela = new CadastrarConvenio();
tela.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
      ListarConvenio tela = new ListarConvenio();
tela.setVisible(true); 
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    
     public static void main(String args[]) {
        Usuario usuarioLogado = new Usuario(); // ou receba de outro lugar, como da tela de login

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador(usuarioLogado).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBoasVindas;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JLabel lblTotalEspecialidades;
    private javax.swing.JLabel lblTotalFuncionarios;
    private javax.swing.JLabel lblTotalMedicos;
    private javax.swing.JLabel lblTotalUsuarios;
    private javax.swing.JMenu menuEspecialidade;
    private javax.swing.JMenu menuFuncionario;
    private javax.swing.JMenuItem menuPerfil;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JPanel panelFuncionarios;
    // End of variables declaration//GEN-END:variables
}
