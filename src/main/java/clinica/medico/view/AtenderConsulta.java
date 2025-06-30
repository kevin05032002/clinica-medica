package clinica.medico.view;

import clinica.dao.ProntuarioDAO;
import clinica.model.Consulta;
import clinica.model.Prontuario;
import clinica.dao.ConsultaDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AtenderConsulta extends JFrame {

   private Consulta  consulta;

    public AtenderConsulta(Consulta consulta) {
        this.consulta = consulta;
        setTitle("Atendimento da Consulta");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        preencherDadosConsulta();
    }

    private void preencherDadosConsulta() {
    if (consulta.getPaciente() != null) {
        lblPaciente.setText("Paciente: " + consulta.getPaciente().getNomeCompleto());
    } else {
        lblPaciente.setText("Paciente: [não informado]");
    }

    if (consulta.getData() != null) {
        lblData.setText("Data: " + consulta.getData().toString());
    } else {
        lblData.setText("Data: [não informada]");
    }

    if (consulta.getHorario() != null) {
        lblHorario.setText("Horário: " + consulta.getHorario());
    } else {
        lblHorario.setText("Horário: [não informado]");
    }

    if (consulta.getTipo() != null) {
        lblTipo.setText("Tipo: " + consulta.getTipo());
    } else {
        lblTipo.setText("Tipo: [não informado]");
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnsalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQueixa = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistorico = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtExame = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtConduta = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnsalvar.setBackground(new java.awt.Color(255, 255, 254));
        btnsalvar.setText("Salvar");
        btnsalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(255, 255, 254));
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 254));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout());

        lblPaciente.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblPaciente.setText("Nome do Paciente");
        jPanel2.add(lblPaciente);

        lblData.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblData.setText("Data da Consulta");
        jPanel2.add(lblData);

        lblHorario.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblHorario.setText("Horario");
        jPanel2.add(lblHorario);

        lblTipo.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblTipo.setText("Tipo ");
        jPanel2.add(lblTipo);

        jLabel5.setText("Queixa");

        txtQueixa.setColumns(20);
        txtQueixa.setRows(5);
        jScrollPane1.setViewportView(txtQueixa);

        txtHistorico.setColumns(20);
        txtHistorico.setRows(5);
        jScrollPane2.setViewportView(txtHistorico);

        jLabel6.setText("Historico Medico");

        txtExame.setColumns(20);
        txtExame.setRows(5);
        jScrollPane3.setViewportView(txtExame);

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setRows(5);
        jScrollPane4.setViewportView(txtDiagnostico);

        txtConduta.setColumns(20);
        txtConduta.setRows(5);
        jScrollPane5.setViewportView(txtConduta);

        jLabel7.setText("Exame");

        jLabel8.setText("Diagnostico");

        jLabel9.setText("Conduta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 129, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalvar)
                        .addGap(95, 95, 95)
                        .addComponent(btnLimpar)
                        .addGap(100, 100, 100)
                        .addComponent(btnCancelar)
                        .addGap(311, 311, 311)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnsalvar)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
        );

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

        setSize(new java.awt.Dimension(1000, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
 try {
            Prontuario prontuario = new Prontuario();
            prontuario.setConsultaId(consulta.getId());
            prontuario.setQueixaPrincipal(txtQueixa.getText().trim());
            prontuario.setHistoricoDoenca(txtHistorico.getText().trim());
            prontuario.setExameFisico(txtExame.getText().trim());
            prontuario.setDiagnostico(txtDiagnostico.getText().trim());
            prontuario.setConduta(txtConduta.getText().trim());
            prontuario.setDataRegistro(Timestamp.valueOf(LocalDateTime.now()));

            ProntuarioDAO dao = new ProntuarioDAO();
            dao.inserir(prontuario);

            JOptionPane.showMessageDialog(this, "Prontuário salvo com sucesso!");
            dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar prontuário: " + ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
txtQueixa.setText("");
        txtHistorico.setText("");
        txtExame.setText("");
        txtDiagnostico.setText("");
        txtConduta.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    Consulta c = new Consulta(); // dummy para teste
    // configure os atributos se necessário
    SwingUtilities.invokeLater(() -> new AtenderConsulta(c).setVisible(true));
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextArea txtConduta;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextArea txtExame;
    private javax.swing.JTextArea txtHistorico;
    private javax.swing.JTextArea txtQueixa;
    // End of variables declaration//GEN-END:variables
}
