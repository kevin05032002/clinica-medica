package clinica.medico.view;

import clinica.dao.ConsultaDAO;
import clinica.dao.MedicoDAO;
import clinica.login.SessaoMedico;
import clinica.login.SessaoUsuario;
import clinica.model.Consulta;
import clinica.model.Medico;
import clinica.model.Usuario;
import clinica.view.EditarPerfil;
import clinica.view.TelaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MenuMedico extends JFrame {

    
   
    private Usuario usuarioLogado;

  public MenuMedico(Usuario usuario) {
    this.usuarioLogado = usuario;
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    iniciarRelogio();

    if (usuario != null) {
        lblBoasVindas.setText("Bem-vindo, Dr(a). " + usuario.getLogin() + "!");

        // ⚠ Aqui é onde carregamos o médico associado ao usuário
        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = medicoDAO.buscarPorUsuarioId(usuario.getId());

        if (medico != null) {
            SessaoMedico.setMedicoLogado(medico);
            carregarConsultasDoMedico();// Define o médico logado
        } else {
            JOptionPane.showMessageDialog(this,
                    "Médico não encontrado para este usuário.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

public void carregarConsultasDoMedico() {
    Medico medico = SessaoMedico.getMedicoLogado();
    if (medico == null) {
        JOptionPane.showMessageDialog(this, "Médico não está logado!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    ConsultaDAO consultaDAO = new ConsultaDAO();
    List<Consulta> consultas = consultaDAO.buscarPorMedicoFuturas(medico.getId());

    String[] colunas = {"ID", "Paciente", "Data", "Hora", "Tipo"};

    DefaultTableModel model = new DefaultTableModel(colunas, 0) {
    
        public boolean isCellEditable(int row, int column) {
            return false; // para deixar as células não editáveis
        }
    };

    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");

    for (Consulta c : consultas) {
        Object[] linha = {
            c.getId(),
            c.getPaciente() != null ? c.getPaciente().getNomeCompleto() : "",
            c.getData() != null ? c.getData().format(formatterData) : "",
            c.getHorario() != null ? c.getHorario().format(formatterHora) : "",
            c.getTipo() != null ? c.getTipo() : ""
        };
        model.addRow(linha);
    }

    tabelaConsultasDia.setModel(model);
}
    private void iniciarRelogio() {
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            lblDataHora.setText(dataHora);
        });
        timer.start();
    }

    // Métodos para futuras telas
    private void abrirMinhasConsultas() {
        JOptionPane.showMessageDialog(this, "Abrir lista de consultas do dia...");
    }

    private void abrirAtendimento() {
        JOptionPane.showMessageDialog(this, "Abrir tela de atendimento...");
    }

    private void abrirHistorico() {
        JOptionPane.showMessageDialog(this, "Abrir histórico de consultas...");
    }

    private void abrirNovoProntuario() {
        JOptionPane.showMessageDialog(this, "Abrir preenchimento de prontuário...");
    }

    private void abrirVisualizarProntuarios() {
        JOptionPane.showMessageDialog(this, "Abrir lista de prontuários...");
    }

    private void abrirEditarPerfil() {
        JOptionPane.showMessageDialog(this, "Abrir edição de perfil...");
    }

    private void logout() {
        SessaoUsuario.limpar();
        dispose();
        new TelaLogin().setVisible(true);
    }

    private void mostrarSobre() {
        JOptionPane.showMessageDialog(this, "Sistema Clínica Médica\nVersão 1.0\nDesenvolvido por Kevin");
    }

   
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblBoasVindas = new javax.swing.JLabel();
        lblDataHora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultasDia = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setLayout(new java.awt.BorderLayout());

        lblBoasVindas.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblBoasVindas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBoasVindas.setText("Carregando");
        jPanel2.add(lblBoasVindas, java.awt.BorderLayout.CENTER);

        lblDataHora.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblDataHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDataHora.setText("Carregando");
        jPanel2.add(lblDataHora, java.awt.BorderLayout.PAGE_END);

        tabelaConsultasDia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaConsultasDia);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Consultas Proximas ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jMenu1.setText("Consultas");

        jMenuItem1.setText("Atender Consulta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Historico de Consultas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Prontuario");

        jMenuItem3.setText("Meus Prontuario");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Buscar por Paciente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Perfil");

        jMenuItem5.setText("Editar Perfil");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sistema ");

        jMenuItem6.setText("Logout");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("Sair");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
ListarConsultasAgendadas ListarConsultasAgendadasTela = new ListarConsultasAgendadas();
  ListarConsultasAgendadasTela.setVisible(true);                // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
HistoricoConsultas HistoricoConsultasTela = new HistoricoConsultas();
HistoricoConsultasTela.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       Medico medicoLogado = SessaoMedico.getMedicoLogado();
    if (medicoLogado != null) {
        MeusProntuario telaProntuarios = new MeusProntuario(medicoLogado.getId());
        telaProntuarios.setLocationRelativeTo(this);
        telaProntuarios.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Médico logado não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
    }   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    new EditarPerfil().setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
 int confirmar = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Logout", JOptionPane.YES_NO_OPTION);
    if (confirmar == JOptionPane.YES_OPTION) {
        SessaoUsuario.limpar(); // Limpa o usuário logado
        this.dispose(); // Fecha a janela atual

        // Retorna para a tela de login
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
    }           // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
  System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
 BuscarPorPaciente tela = new BuscarPorPaciente();
        tela.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setLogin("Dr. João");
        new MenuMedico(u).setVisible(true);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBoasVindas;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JTable tabelaConsultasDia;
    // End of variables declaration//GEN-END:variables
}
