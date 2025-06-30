package clinica.atendente.view;

import clinica.dao.ConvenioDAO;
import clinica.dao.MedicoDAO;
import clinica.dao.PacienteDAO;
import clinica.model.Consulta;
import clinica.model.Convenio;
import clinica.model.Medico;
import clinica.model.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AgendarConsulta extends JFrame {
 private Consulta consulta;

    public AgendarConsulta(Consulta consulta) {
        this.consulta = consulta;
        initComponents();
        preencherCampos();
        carregarPacientes();
        carregarMedicos();
        carregarConvenios();
        carregarHoras();
        carregarTiposConsulta();
    }

  private void preencherCampos() {
    if (consulta == null) return;

    comboPaciente.setSelectedItem(consulta.getPaciente());
    comboMedico.setSelectedItem(consulta.getMedico());
    txtDataConsulta.setText(consulta.getData().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    comboHora.setSelectedItem(consulta.getHorario().toString());
    comboTipoConsulta.setSelectedItem(consulta.getTipo());

    if ("Convênio".equalsIgnoreCase(consulta.getTipo())) {
        comboConvenio.setEnabled(true);
        comboConvenio.setSelectedItem(consulta.getConvenio());
    } else {
        comboConvenio.setEnabled(false);
        comboConvenio.setSelectedItem(null);
    }

    txtObservacao.setText(consulta.getObservacoes());
}

    public AgendarConsulta() {
        setTitle("Agendamento de Consulta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        carregarPacientes();
        carregarMedicos();
        carregarConvenios();
        carregarHoras();
        carregarTiposConsulta();
        
    }

    private void carregarPacientes() {
        try {
            PacienteDAO dao = new PacienteDAO();
            List<Paciente> pacientes = dao.buscarTodos();
            comboPaciente.removeAllItems();
            for (Paciente p : pacientes) {
                comboPaciente.addItem(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar pacientes: " + e.getMessage());
        }
    }

    private void carregarMedicos() {
        try {
            MedicoDAO dao = new MedicoDAO();
            List<Medico> medicos = dao.buscarTodos();
            comboMedico.removeAllItems();
            for (Medico m : medicos) {
                comboMedico.addItem(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar médicos: " + e.getMessage());
        }
    }

    private void carregarConvenios() {
        try {
            ConvenioDAO dao = new ConvenioDAO();
            List<Convenio> convenios = dao.buscarTodos();
            comboConvenio.removeAllItems();
            for (Convenio c : convenios) {
                comboConvenio.addItem(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar convênios: " + e.getMessage());
        }
    }

    private void carregarHoras() {
        comboHora.removeAllItems();
        String[] horas = {
            "08:00", "08:30", "09:00", "09:30",
            "10:00", "10:30", "11:00", "11:30",
            "13:00", "13:30", "14:00", "14:30",
            "15:00", "15:30", "16:00", "16:30",
            "17:00", "17:30", 
        };
        for (String h : horas) {
            comboHora.addItem(h);
        }
    }

    private void carregarTiposConsulta() {
        comboTipoConsulta.removeAllItems();
        comboTipoConsulta.addItem("Particular");
        comboTipoConsulta.addItem("Convênio");
        comboTipoConsulta.addActionListener((ActionEvent e) -> {
    String tipoSelecionado = (String) comboTipoConsulta.getSelectedItem();
    if ("Particular".equalsIgnoreCase(tipoSelecionado)) {
        comboConvenio.setEnabled(false);
        comboConvenio.setSelectedItem(null); // opcional: limpa seleção
    } else {
        comboConvenio.setEnabled(true);
    }
});
    }
    private void limparCampos() {
    comboPaciente.setSelectedIndex(-1);
    comboMedico.setSelectedIndex(-1);
    txtDataConsulta.setText("");
    comboHora.setSelectedIndex(-1);
    comboTipoConsulta.setSelectedIndex(0); // "Particular"
    comboConvenio.setSelectedIndex(-1);
    comboConvenio.setEnabled(false); // Desabilita por padrão (já que tipo é Particular)
    txtObservacao.setText("");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboPaciente = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        comboMedico = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        comboHora = new javax.swing.JComboBox<>();
        comboTipoConsulta = new javax.swing.JComboBox<>();
        comboConvenio = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtDataConsulta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Paciente");

        comboPaciente.setBackground(new java.awt.Color(255, 255, 254));
        comboPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Medico");

        comboMedico.setBackground(new java.awt.Color(255, 255, 254));
        comboMedico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Data");

        comboHora.setBackground(new java.awt.Color(255, 255, 254));
        comboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboTipoConsulta.setBackground(new java.awt.Color(255, 255, 254));
        comboTipoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboConvenio.setBackground(new java.awt.Color(255, 255, 254));
        comboConvenio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        jLabel4.setText("Hora");

        jLabel5.setText("Tipo de Consulta");

        jLabel6.setText("Convênio");

        jLabel7.setText("Observação");

        btnSalvar.setBackground(new java.awt.Color(255, 255, 254));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(255, 255, 254));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 254));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(java.awt.SystemColor.textHighlight);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDataConsulta, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboHora, javax.swing.GroupLayout.Alignment.LEADING, 0, 100, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(btnCancelar))
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(900, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    String dataStr = txtDataConsulta.getText().trim();
    String horaStr = (String) comboHora.getSelectedItem();
    String tipo = (String) comboTipoConsulta.getSelectedItem();
    String observacao = txtObservacao.getText();

    Paciente paciente = (Paciente) comboPaciente.getSelectedItem();
    Medico medico = (Medico) comboMedico.getSelectedItem();
    Convenio convenio = (Convenio) comboConvenio.getSelectedItem();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);

    try {
        java.util.Date dataUtil = sdf.parse(dataStr);
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

        java.time.LocalDate data = dataSql.toLocalDate();
        java.time.LocalTime hora = java.time.LocalTime.parse(horaStr);

        if (consulta == null) {
            consulta = new Consulta(); // nova consulta
        }

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setData(data);
        consulta.setHorario(hora);
        consulta.setTipo(tipo);
        consulta.setConvenio("Convênio".equalsIgnoreCase(tipo) ? convenio : null);
        consulta.setObservacoes(observacao);

        clinica.dao.ConsultaDAO dao = new clinica.dao.ConsultaDAO();

        if (consulta.getId() == 0) {
            dao.inserir(consulta); // INSERIR NOVA
            JOptionPane.showMessageDialog(this, "Consulta agendada com sucesso!");
        } else {
            dao.atualizar(consulta); // EDITAR EXISTENTE
            JOptionPane.showMessageDialog(this, "Consulta atualizada com sucesso!");
        }

        dispose(); // Fecha a janela após salvar
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao salvar consulta: " + ex.getMessage());
    }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       limparCampos(); // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendarConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox comboConvenio;
    private javax.swing.JComboBox<String> comboHora;
    private javax.swing.JComboBox comboMedico;
    private javax.swing.JComboBox comboPaciente;
    private javax.swing.JComboBox<String> comboTipoConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDataConsulta;
    private javax.swing.JTextArea txtObservacao;
    // End of variables declaration//GEN-END:variables
}
