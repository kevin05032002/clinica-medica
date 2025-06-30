package clinica.atendente.view;

import clinica.dao.ConsultaDAO;
import clinica.login.SessaoUsuario;
import clinica.model.Consulta;
import clinica.model.Usuario;
import clinica.view.CadastrarConvenio;
import clinica.view.EditarPerfil;
import clinica.view.ListarConvenio;
import clinica.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class MenuAtendente extends javax.swing.JFrame {

private javax.swing.JScrollPane scrollPane;
    private Usuario usuarioLogado;

    // Construtor com usuário
    public MenuAtendente(Usuario usuario) {
        initComponents();
        this.usuarioLogado = usuario;      
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        carregarConsultasProximas();
        this.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowActivated(java.awt.event.WindowEvent e) {
            carregarConsultasProximas();
        }
    });
        if (usuario != null) {
            lblBoasVindas.setText("Bem-vindo, " + usuario.getLogin() + "!");
        }
         Timer timer = new Timer(1000, (ActionEvent e) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataHora = LocalDateTime.now().format(formatter);
            lblDataHora.setText("" + dataHora);
        });
        timer.start();
        
    }
    

    // Construtor padrão (necessário para testes)
    public MenuAtendente() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
 private void carregarConsultasProximas() {
    List<Consulta> consultas = new ConsultaDAO().buscarConsultasProximas();
    System.out.println("Consultas encontradas: " + consultas.size());  // Debug

    // Define o modelo com as colunas desejadas, vazio inicialmente
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[][] {},
        new String[] {"Paciente", "Médico", "Data", "Horário", "Tipo"}
    );
    
    for (Consulta c : consultas) {
        System.out.println("Consulta: Paciente=" + c.getPaciente().getNomeCompleto() + ", Médico=" + c.getMedico().getNome()); // Debug
        modelo.addRow(new Object[]{
            c.getPaciente().getNomeCompleto(),
            c.getMedico().getNome(),
            c.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            c.getHorario().toString(),
            c.getTipo()
        });
    }

    // Agora aplica o modelo preenchido na tabela, apenas UMA vez
    tabelaConsultas.setModel(modelo);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBoasVindas = new javax.swing.JLabel();
        lblDataHora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblBoasVindas.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblBoasVindas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBoasVindas.setText("Carregando");

        lblDataHora.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        lblDataHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDataHora.setText("Carregando");

        tabelaConsultas.setBackground(java.awt.SystemColor.control);
        tabelaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaConsultas);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBoasVindas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1225, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblBoasVindas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(lblDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 254));

        jMenu1.setText("Pacientes");

        jMenuItem1.setText("Cadastrar Paciente ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Listar Paciente ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");

        jMenuItem3.setText("Agendar Consultas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Listar Consultas Agendada");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Convenios");

        jMenuItem8.setText("Cadastrar Convênio");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem7.setText("Listar Convênios ");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Perfil");

        jMenuItem9.setText("Editar Perfil");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Sistema");

        jMenuItem5.setText("Logout");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItem6.setText("Sair");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1237, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
CadastrarPaciente CadastarPacienteTela = new CadastrarPaciente();
   CadastarPacienteTela.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     ListarPaciente  ListarPacienteTela = new  ListarPaciente();
    ListarPacienteTela.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
   System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
int confirmar = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Logout", JOptionPane.YES_NO_OPTION);
    
    if (confirmar == JOptionPane.YES_OPTION) {
        SessaoUsuario.limpar(); // Limpa o usuário logado
        this.dispose(); // Fecha a janela atual

        // Retorna para a tela de login
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
    }          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
  AgendarConsulta tela = new AgendarConsulta();
    tela.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
     ListarConsultas tela = new ListarConsultas();
    tela.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
 ListarConvenio tela = new ListarConvenio();
tela.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
CadastrarConvenio tela = new CadastrarConvenio();
tela.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
 new EditarPerfil().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
    // Criando usuário fake para teste
    Usuario usuarioTeste = new Usuario();
    usuarioTeste.setLogin("Teste");

    java.awt.EventQueue.invokeLater(() -> {
        new MenuAtendente(usuarioTeste).setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBoasVindas;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JTable tabelaConsultas;
    // End of variables declaration//GEN-END:variables
}
